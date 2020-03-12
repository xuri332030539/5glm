package com.st.smartsecurity.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import com.qs.common.redis.util.RedisUtil;
import com.st.smartsecurity.mapper.CompanyListInfoMapper;
import com.st.smartsecurity.mapper.CompanyListMapper;
import com.st.smartsecurity.mapper.CompanyMapper;
import com.st.smartsecurity.pojo.po.Company;
import com.st.smartsecurity.pojo.po.CompanyList;
import com.st.smartsecurity.pojo.po.CompanyListInfo;
import com.st.smartsecurity.service.QichachaService;
import com.st.smartsecurity.util.qichacha.QichachaUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

@Service
public class QichachaServiceImpl implements QichachaService {
    @Autowired
    QichachaUtil qichachaUtil;
    @Resource
    CompanyMapper companyMapper;
    @Resource
    CompanyListInfoMapper companyListInfoMapper;
    @Resource
    CompanyListMapper companyListMapper;

    @Override
    public Company industryDetail(String name)  {
        Example example = new Example(Company.class);
        example.createCriteria().andEqualTo("name", name).andNotEqualTo("state","D");
        List<Company> companies = companyMapper.selectByExample(example);
        Company retCompany = new Company();
        //content数据过大，前端调接口时insert可能会卡顿 做两次判断
        if (companies.size()==0){
            Company company = new Company();
            company.setState("N");
            company.setName(name);
            companyMapper.insert(company);
        }

        List<Company> companies2 = companyMapper.selectByExample(example);
        if (companies2.size()==1&&StringUtils.isEmpty(companies2.get(0).getKey())) {
            System.out.println(name+"数据库为空，调用企查查接口");
            String reqInterNme1 = "http://api.qichacha.com/ECIV4/SearchWide";
            String paramStr1 = "keyword=" + name;
            String result1 = qichachaUtil.qichachaCheck(reqInterNme1, paramStr1);
            String status1 = JSONObject.parseObject(result1).getString("Status");
            Preconditions.checkArgument(status1.equals("200"),"查询失败");
            JSONObject jsonObject = JSONObject.parseObject(result1);
            Object o = jsonObject.getJSONArray("Result").get(0);
            String creditCode = JSONObject.parseObject(o.toString()).getString("CreditCode");
            Company company = companies2.get(0);
            company.setKey(creditCode);
            company.setName(name);
            String reqInterNme2 = "http://api.qichacha.com/ECIV4/GetFullDetailsByName";
            String paramStr2 = "keyword=" + creditCode;
            String result2 = qichachaUtil.qichachaCheck(reqInterNme2, paramStr2);
            String status2 = JSONObject.parseObject(result2).getString("Status");
            Preconditions.checkArgument(status2.equals("200"),"查询失败");
            company.setContent(result2);
            companyMapper.updateByPrimaryKey(company);
            retCompany = company;
        }
        if (companies.size()!=1&&companies.size()!=0){
            System.out.println("存在该数据，直接返回");
            retCompany = companies.get(0);
        }
        return retCompany;
    }


    @Override
    public int getCompanyPatent(String companyName) {
        Example example = new Example(Company.class);
        example.createCriteria().andEqualTo("name", companyName).andNotEqualTo("state","D");
        List<Company> companies = companyMapper.selectByExample(example);
        Preconditions.checkArgument(companies.size() != 0,"不存在此公司");
        Company company = companies.get(0);
        if (company.getPatentCount() == null) {
            String reqInterNme1 = "http://api.qichacha.com/PatentV4/SearchMultiPatents";
            String paramStr1 = "searchKey="+company.getKey()+"&pageIndex=1&PageSize=50";
            String result = qichachaUtil.qichachaCheck(reqInterNme1, paramStr1);
            JSONObject jsonObject = JSONObject.parseObject(result);
            String status = jsonObject.getString("Status");
            if("200".equals(status)){
                JSONObject jsonPaging = jsonObject.getJSONObject("Paging");
                int count = jsonPaging.getInteger("TotalRecords");
                company.setPatentCount(count);
            } else {
                System.out.println(status);
                company.setPatentCount(0);
            }
            companyMapper.updateByPrimaryKeySelective(company);
        }
        return company.getPatentCount();
    }

    //    type 句容   elements 南京字段
    @Override
    public JSONArray getCompanyList(String type, String elements) {
        JSONArray retJson = new JSONArray();
        //句容产业园
        if (StringUtils.isNotEmpty(type)) {
            Example example1 = new Example(CompanyList.class);
            List<CompanyList> companyLists = new ArrayList<>();
            example1.createCriteria().andEqualTo("area", "句容");
            companyLists = companyListMapper.selectByExample(example1);
            //产业园
            for (CompanyList companyList : companyLists) {
                Example example2 = new Example(CompanyListInfo.class);
                JSONObject jsonObject = new JSONObject();
                Example.Criteria criteria = example2.createCriteria();
                if (!type.equals("全部")){
                    criteria.andEqualTo("type", type);
                }
                criteria.andEqualTo("companyListId", companyList.getId());
                List<CompanyListInfo> companyListInfos1 = companyListInfoMapper.selectByExample(example2);
                if (companyListInfos1.size()==0){
                    continue;
                }
                //Properties
                JSONObject properties = JSONObject.parseObject(companyList.getProperties());
                JSONObject geometry = JSONObject.parseObject(companyList.getGeometry());
                //存产业园
                JSONArray jsonTest = new JSONArray();
                for (CompanyListInfo companyListInfo : companyListInfos1) {
                    //test
                    jsonTest.add(JSONObject.parseObject(companyListInfo.getTest()));
                }
                properties.put("test", jsonTest);
                properties.put("mag",companyListInfos1.size());
                jsonObject.put("type", "Feature");
                jsonObject.put("properties", properties);
                jsonObject.put("geometry", geometry);
                retJson.add(jsonObject);
            }
        }
        else if (StringUtils.isNotEmpty(elements)){
            Example example1 = new Example(CompanyList.class);
            List<CompanyList> companyLists = new ArrayList<>();
            example1.createCriteria().andEqualTo("area", "南京");
            companyLists = companyListMapper.selectByExample(example1);
            //产业园
            for (CompanyList companyList : companyLists) {
                Example example2 = new Example(CompanyListInfo.class);
                JSONObject jsonObject = new JSONObject();
                Example.Criteria criteria = example2.createCriteria();
                if (!elements.equals("全部")){
                    criteria.andLike("type", "%"+elements+"%");
                }
                criteria.andEqualTo("companyListId", companyList.getId());
                List<CompanyListInfo> companyListInfos1 = companyListInfoMapper.selectByExample(example2);
                if (companyListInfos1.size()==0){
                    continue;
                }

                //Properties
                JSONObject properties = JSONObject.parseObject(companyList.getProperties());
                JSONObject geometry = JSONObject.parseObject(companyList.getGeometry());
                //存产业园
                JSONArray jsonTest = new JSONArray();
                for (CompanyListInfo companyListInfo : companyListInfos1) {
                    //test
                    jsonTest.add(JSONObject.parseObject(companyListInfo.getTest()));
                }
                properties.put("test", jsonTest);
                properties.put("mag",companyListInfos1.size());
                jsonObject.put("type", "Feature");
                jsonObject.put("properties", properties);
                jsonObject.put("geometry", geometry);
                retJson.add(jsonObject);
            }
        }
        return retJson;
    }
}
