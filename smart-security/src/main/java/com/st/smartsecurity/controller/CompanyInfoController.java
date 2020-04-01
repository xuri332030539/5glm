package com.st.smartsecurity.controller;

import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.dto.CompanyBaseInfoDTO;
import com.st.smartsecurity.pojo.vo.CompanyBaseInfoVO;
import com.st.smartsecurity.pojo.vo.CompanySceneVO;
import com.st.smartsecurity.pojo.vo.params.CompanyParamsVO;
import com.st.smartsecurity.service.CompanyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司信息接口
 * @author lhm
 */
@RestController
@RequestMapping("companyInfo")
@Api(value = "companyInfo", tags = "公司信息接口", position = 1)
public class CompanyInfoController {

    @Autowired
    CompanyInfoService companyInfoService;

    @PostMapping("addInfo")
    @ApiOperation(value = "增加公司信息")
    @PassToken
    public BaseResponse addInfo(@RequestBody CompanyBaseInfoVO companyBaseInfoVO){
        Preconditions.checkArgument(companyBaseInfoVO.getCompanyUserId() != null,"公司id不可为空");
        companyInfoService.addInfo(companyBaseInfoVO);
        return BaseResponse.success();
    }

//    @PostMapping("updateCompanyInfo")
//    @ApiOperation(value = "修改公司信息")
//    @PassToken
//    public BaseResponse updateCompanyInfo(@RequestBody CompanyBaseInfoVO companyBaseInfoVO){
//        Preconditions.checkArgument(companyBaseInfoVO.getId() != null,"id不可为空");
//        companyInfoService.updateCompanyInfo(companyBaseInfoVO);
//        return BaseResponse.success();
//    }

    @PostMapping("getCompanyInfo")
    @ApiOperation(value = "获取公司信息")
    @PassToken
    public BaseResponse<CompanyBaseInfoDTO> getCompanyInfo(long companyId){

        return BaseResponse.success(companyInfoService.getCompanyInfo(companyId));
    }

    @PostMapping("addCompanyScene")
    @ApiOperation(value = "增加公司场景")
    @PassToken
    public BaseResponse addCompanyScene(@RequestBody CompanySceneVO companySceneVO){
        Preconditions.checkArgument(companySceneVO.getCompanyId() != null,"公司id不可为空");
        companyInfoService.addCompanyScene(companySceneVO);
        return BaseResponse.success();
    }

    @PostMapping("listCompany")
    @ApiOperation(value = "公司列表")
    @PassToken
    public BaseResponse listCompany(@RequestBody CompanyParamsVO companyParamsVO){
        return BaseResponse.success(companyInfoService.listCompany(companyParamsVO));
    }

    @PostMapping("checkCompany")
    @ApiOperation(value = "审核公司")
    @PassToken
    public BaseResponse checkCompany(long companyId, String state){
        companyInfoService.checkCompany(companyId, state);
        return BaseResponse.success();
    }

    @PostMapping("listCompanyScene")
    @ApiOperation(value = "场景列表")
    @PassToken
    public BaseResponse listCompanyScene(long companyId){
        return BaseResponse.success(companyInfoService.listCompanyScene(companyId));
    }

    @PostMapping("getCompanyScene")
    @ApiOperation(value = "场景详情")
    @PassToken
    public BaseResponse getCompanyScene(long companySceneId){
        return BaseResponse.success(companyInfoService.getCompanyScene(companySceneId));
    }

    @PostMapping("listAllCompanyScene")
    @ApiOperation(value = "获取所有场景")
    @PassToken
    public BaseResponse listAllCompanyScene(String type){
        Preconditions.checkArgument(type != null, "查询场景类型不可为空");
        return BaseResponse.success(companyInfoService.listAllCompanyScene(type));
    }

    @PostMapping("listCompanyBySceneKey")
    @ApiOperation(value = "通过场景关键字查询关联公司")
    @PassToken
    public BaseResponse listCompanyBySceneKey(String key){
        Preconditions.checkArgument(key != null, "关键字不可为空");
        return BaseResponse.success(companyInfoService.listCompanyBySceneKey(key));
    }

    @PostMapping("deleteCompanyScene")
    @ApiOperation(value = "场景删除")
    @PassToken
    public BaseResponse deleteCompanyScene(long companySceneId){
        companyInfoService.deleteCompanyScene(companySceneId);
        return BaseResponse.success();
    }

    @PostMapping("listSceneByName")
    @ApiOperation(value = "通过场景名称查询场景")
    @PassToken
    public BaseResponse listSceneByName(String sceneName){
        Preconditions.checkArgument(!StringUtils.isEmpty(sceneName), "查询场景名称不可为空");
        return BaseResponse.success(companyInfoService.listSceneByName(sceneName));
    }
}
