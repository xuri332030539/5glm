package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 公司DTO
 * @author lhm
 */
@Data
@ApiModel
public class CompanyUserDTO {

    @ApiModelProperty(value = "公司id")
    Long companyId;

    @ApiModelProperty(value = "用户名称")
    private String loginName;

    @ApiModelProperty(value = "用户密码")
    String pwd;

    @ApiModelProperty(value = "信用代码")
    Long comType;

    @ApiModelProperty(value = "公司名称")
    String comName;

    @ApiModelProperty(value = "公司代码")
    String comCode;

    @ApiModelProperty(value = "创建时间")
    Date createDate;

    @ApiModelProperty(value = "状态")
    String state;

    @ApiModelProperty(value = "经纬度")
    String park;
}
