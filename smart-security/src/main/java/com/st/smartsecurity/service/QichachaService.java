package com.st.smartsecurity.service;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.JsonObject;
import com.st.smartsecurity.pojo.po.Company;

public interface QichachaService  {
    Company industryDetail(String name);

    /**
     * 获取公司专利数
     * @param companyName
     * @return
     */
    int getCompanyPatent(String companyName);

    JSONArray getCompanyList(String type, String elements);
}
