package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author lhm
 */
@Data
@ApiModel(value = "场景图片")
public class CompanySceneImgDTO {

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    /**
     * 场景图片
     */
    @ApiModelProperty(value = "场景图片")
    private String scenarioImg;


    /**
     * 场景id
     */
    @ApiModelProperty(value = "场景id")
    private Long companySceneId;
}
