package com.st.smartsecurity.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.st.smartsecurity.mapper.JsCysttCityCompanyMapper;
import com.st.smartsecurity.mapper.JsCysttCityMapper;
import com.st.smartsecurity.mapper.SceneDataMapper;
import com.st.smartsecurity.pojo.po.JsCysttCity;
import com.st.smartsecurity.pojo.po.JsCysttCityCompany;
import com.st.smartsecurity.pojo.po.SceneData;
import com.st.smartsecurity.service.CityCompanyService;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CityCompanyServiceImpl implements CityCompanyService {
    @Resource
    JsCysttCityMapper jsCysttCityMapper;
    @Resource
    JsCysttCityCompanyMapper jsCysttCityCompanyMapper;
    @Resource
    SceneDataMapper sceneDataMapper;

    @Override
    public JSONArray getCompanyByElements(String elements) {
        Example example = new Example(JsCysttCity.class);
        example.createCriteria();
        JSONArray retJson = new JSONArray();
        List<JsCysttCity> cityList =new ArrayList<>();
        cityList = jsCysttCityMapper.selectByExample(example);
        //遍历城市
        for (JsCysttCity jsCysttCity : cityList){
            Example example1 = new Example(JsCysttCityCompany.class);
            JSONObject jsonObject = new JSONObject();
            Example.Criteria criteria = example1.createCriteria();
            if (elements.equals("上游产业链")){
                criteria.orLike("elements", "%"+"算法"+"%");
                criteria.orLike("elements", "%"+"芯片"+"%");
            }
            if (elements.equals("中游产业链")){
                criteria.orLike("elements", "%"+"模块"+"%");
                criteria.orLike("elements", "%"+"终端"+"%");
            }
            if (elements.equals("下游产业链")){
                criteria.orLike("elements", "%"+"系统"+"%");
                criteria.orLike("elements", "%"+"网络"+"%");
                criteria.orLike("elements", "%"+"平台"+"%");
            }
//            criteria.andEqualTo("jsCityId", jsCysttCity.getId());
            List<JsCysttCityCompany> companyList =  jsCysttCityCompanyMapper.selectByExample(example1);
            if (companyList.size()==0){
                continue;
            }
            List<JsCysttCityCompany> list = new ArrayList<>();
            for (JsCysttCityCompany jsCysttCityCompany:companyList){
                if (jsCysttCityCompany.getJsCityId()==jsCysttCity.getId()){
                    list.add(jsCysttCityCompany);
                }
            }
            //type
            jsonObject.put("type","Feature");
            //properties
            JSONObject properties = new JSONObject();
            properties.put("id",jsCysttCity.getName());
            properties.put("mag",list.size());
            properties.put("time","1507425650893");
            properties.put("tsunami",0);
            properties.put("felt","null");
            //test
            JSONArray jsonArray = new JSONArray();
            for (JsCysttCityCompany jsCysttCityCompany : list){
                jsonArray.add(JSONObject.parseObject(jsCysttCityCompany.getContent()));
            }
            properties.put("test",jsonArray);
            jsonObject.put("properties",properties);
            //geometry
            JSONObject geometry = new JSONObject();
            geometry.put("type","Point");
            String[] split = jsCysttCity.getCoordinates().split(",");
            JSONArray coordinates = new JSONArray();
            coordinates.add(Float.parseFloat(split[0]));
            coordinates.add(Float.parseFloat(split[1]));
            geometry.put("coordinates",coordinates);
            jsonObject.put("geometry",geometry);
            retJson.add(jsonObject);
        }
        return retJson;
    }

    @Override
    public JSONArray getCityByElements(String elements) {
        Example example = new Example(JsCysttCity.class);
        example.createCriteria();
        JSONArray retJson = new JSONArray();
        List<JsCysttCity> cityList =new ArrayList<>();
        cityList = jsCysttCityMapper.selectByExample(example);
        //遍历城市
        for (JsCysttCity jsCysttCity : cityList){
            Example example1 = new Example(JsCysttCityCompany.class);
            JSONObject jsonObject = new JSONObject();
            Example.Criteria criteria = example1.createCriteria();
            if (!elements.equals("全部")){
                criteria.andLike("elements", "%"+elements+"%");
            }
            criteria.andEqualTo("jsCityId", jsCysttCity.getId());
            List<JsCysttCityCompany> companyList =  jsCysttCityCompanyMapper.selectByExample(example1);
            if (companyList.size()==0){
                continue;
            }
            //type
            jsonObject.put("type","Feature");
            //properties
            JSONObject properties = new JSONObject();
            properties.put("id",jsCysttCity.getName());
            properties.put("mag",companyList.size());
            properties.put("time","1507425650893");
            properties.put("tsunami",0);
            properties.put("felt","null");
            //test
            JSONArray jsonArray = new JSONArray();
            for (JsCysttCityCompany jsCysttCityCompany : companyList){
                jsonArray.add(JSONObject.parseObject(jsCysttCityCompany.getContent()));
            }
            properties.put("test",jsonArray);
            jsonObject.put("properties",properties);
            //geometry
            JSONObject geometry = new JSONObject();
            geometry.put("type","Point");
            String[] split = jsCysttCity.getCoordinates().split(",");
            JSONArray coordinates = new JSONArray();
            coordinates.add(Float.parseFloat(split[0]));
            coordinates.add(Float.parseFloat(split[1]));
            geometry.put("coordinates",coordinates);
            jsonObject.put("geometry",geometry);
            retJson.add(jsonObject);
        }
        return retJson;
    }



    @Override
    public JSONArray getCompanyByScene(int scene) {
        JSONArray retJson = new JSONArray();
        Example example = new Example(JsCysttCity.class);
        example.createCriteria();
        List<JsCysttCity> cityList =new ArrayList<>();
        cityList = jsCysttCityMapper.selectByExample(example);
        //遍历城市
        for (JsCysttCity jsCysttCity : cityList){
            JSONObject jsonObject = new JSONObject();
            Example example1 =new Example(SceneData.class);
            example1.createCriteria().andEqualTo("changjing",scene).andEqualTo("coordinates",jsCysttCity.getId());
            List<SceneData> sceneDataList = sceneDataMapper.selectByExample(example1);
            if (sceneDataList.size()==0){
                continue;
            }
            //type
            jsonObject.put("type","Feature");
            //properties
            JSONObject properties = new JSONObject();
            properties.put("id",jsCysttCity.getName());
            properties.put("mag",sceneDataList.size());
            properties.put("time","1507425650893");
            properties.put("tsunami",0);
            properties.put("felt","null");
            //test
            JSONArray jsonArray = new JSONArray();
            for (SceneData sceneData : sceneDataList){
                JSONObject companyJson = new JSONObject();
                companyJson.put("companyName",sceneData.getCompany());
                companyJson.put("business",sceneData.getBusiness());
                jsonArray.add(companyJson);
            }
            properties.put("test",jsonArray);
            jsonObject.put("properties",properties);
            //geometry
            JSONObject geometry = new JSONObject();
            geometry.put("type","Point");
            String[] split = jsCysttCity.getCoordinates().split(",");
            JSONArray coordinates = new JSONArray();
            coordinates.add(Float.parseFloat(split[0]));
            coordinates.add(Float.parseFloat(split[1]));
            geometry.put("coordinates",coordinates);
            jsonObject.put("geometry",geometry);
            retJson.add(jsonObject);
        }
        return retJson;
    }
}
