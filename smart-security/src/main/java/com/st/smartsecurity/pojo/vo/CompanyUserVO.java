package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * 公司用户VO
 * @author lhm
 */
@Data
@ApiModel
public class CompanyUserVO {

    @ApiModelProperty(value = "公司名称")
    private String comName;

    @ApiModelProperty(value = "用户名称,登录传")
    private String loginName;

    @ApiModelProperty(value = "用户密码,登陆传")
    private String pwd;

    @ApiModelProperty(value = "统一信用代码")
    private String comCode;

    @ApiModelProperty(value = "公司类型")
    private Long comType;
}
