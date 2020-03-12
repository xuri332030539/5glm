package com.st.smartsecurity.controller;

import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.service.JsCityCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 江苏产业生态图公司管理
 * @author lhm
 */
@RestController
@RequestMapping("jsCompany")
//@Api(value = "jsCompany", tags = "江苏城市公司接口", position = 1)
public class JsCityCompanyController {

    @Autowired
    JsCityCompanyService jsCityCompanyService;

    @PostMapping("addCompany")
    @ApiOperation(value = "添加公司")
    @PassToken
    public BaseResponse addCompany(){
        String companyInfo = "[\n" +
                "                    {\"index\":\"105\",\"city\":\"扬州\",\"company\":\"扬州晶新微电子有限公司\",\"business\":\"电子信息类片式半导体分立器件芯片\",\"income\":\"32000\",\"product\":\"高性能片式半导体器件二极管、三极管芯片。年投资额1000万元，研发周期:12个月\",\"hopelis\":\"替代部分进口芯片\",\"elements\":\"算法、芯片、模块、终端、系统、网络、平台\"}\n" +
                "                ]";
        int cityId = 11;
        jsCityCompanyService.addCompany(cityId, companyInfo);
        return BaseResponse.success();
    }
}
