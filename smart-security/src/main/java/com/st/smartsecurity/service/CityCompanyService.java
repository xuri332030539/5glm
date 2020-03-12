package com.st.smartsecurity.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface CityCompanyService {
    JSONArray getCityByElements(String elements);

    JSONArray getCompanyByScene(int scene);
}
