package com.st.smartsecurity.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.service.QichachaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 企查查
 * @author xuri
 */

@RestController
@RequestMapping("qichacha")
@Api(value = "qichacha", tags = "会议接口", position = 1)
public class QichachaController {
    @Resource
    QichachaService qichachaService;

    @PostMapping("industryDetail")
    @ApiOperation(value = "工商详情")
    @PassToken
    public BaseResponse industryDetail(String name){
        return BaseResponse.success(JSONObject.parseObject(qichachaService.industryDetail(name).getContent()));
    }

    @PostMapping("getPatentCount")
    @ApiOperation(value = "获取专利总数")
    @PassToken
    public BaseResponse getPatentCount(String name){
        Preconditions.checkArgument(StringUtils.isNotEmpty(name),"公司名不可为空");
        return BaseResponse.success(qichachaService.getCompanyPatent(name));
    }

    @PostMapping("getCompanyList")
    @ApiOperation(value = "getCompanyList")
    @PassToken
    public BaseResponse getCompanyList(String type,String elements){
        return BaseResponse.success(qichachaService.getCompanyList(type,elements));
    }
}
