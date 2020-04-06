package com.st.smartsecurity.controller;

import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.service.CityCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//5G联盟接口
@RestController
@RequestMapping("city")
@Api(value = "city", tags = "城市公司大屏接口", position = 1)
public class CityCompanyController {
    @Autowired
    CityCompanyService cityCompanyService;

    @PostMapping("getCityByElements")
    @ApiOperation("根据elements获取公司")
    @PassToken
    public BaseResponse getCityByElements(String elements){
        return BaseResponse.success(cityCompanyService.getCityByElements(elements));
    }

    @PostMapping("getCompanyByElements")
    @ApiOperation("根据elements获取公司")
    @PassToken
    public BaseResponse getCompanyByElements(String elements) {
        return BaseResponse.success(cityCompanyService.getCompanyByElements(elements));
    }

    @PostMapping("getCompanyByScene")
    @ApiOperation("根据场景获取公司信息")
    @PassToken
    public BaseResponse getCompanyByScene(int scene){
        return BaseResponse.success(cityCompanyService.getCompanyByScene(scene));
    }
}
