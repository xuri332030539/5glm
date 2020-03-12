package com.st.smartsecurity.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.st.smartsecurity.mapper.JsCysttCityCompanyMapper;
import com.st.smartsecurity.pojo.po.CompanyListInfo;
import com.st.smartsecurity.pojo.po.JsCysttCityCompany;
import com.st.smartsecurity.service.JsCityCompanyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 江苏产业生态图公司管理
 * @author lhm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JsCityCompanyServiceImpl implements JsCityCompanyService {

    @Resource
    JsCysttCityCompanyMapper jsCysttCityCompanyMapper;

    @Override
    public void addCompany(int cityId, String companyInfo) {
        JSONArray companyArray = JSONArray.parseArray(companyInfo);
        for (int i = 0; i < companyArray.size(); i++) {
            JSONObject company = companyArray.getJSONObject(i);
            String elements = company.getString("elements");
            System.out.println(i+"-"+elements);
            if(StringUtils.isNotEmpty(elements)){
                JsCysttCityCompany jsCysttCityCompany = new JsCysttCityCompany();
                jsCysttCityCompany.setJsCityId(cityId);
                jsCysttCityCompany.setElements(elements);
                jsCysttCityCompany.setContent(company.toJSONString());
                jsCysttCityCompanyMapper.insertSelective(jsCysttCityCompany);
            }
        }
    }
}
