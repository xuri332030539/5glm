package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 公司场景DTO
 * @author lhm
 */
@Data
@ApiModel
public class CompanySceneDTO {

    @ApiModelProperty("公司id")
    Long companyId;

    @ApiModelProperty("场景id")
    Long sceneId;
    /**
     * 场景分类
     1-智慧政务;2-智慧民生;3-智慧产业
     */
    @ApiModelProperty("场景分类")
    private String sceneClassification;

    /**
     * 公司拥有的场景名称
     */
    @ApiModelProperty("公司拥有的场景名称")
    private String scene;

    /**
     * 公司对该场景的定义
     */
    @ApiModelProperty("公司对该场景的定义")
    private String scenarioDefined;

    /**
     * 该场景关键字（必填、以顿号分割）
     */
    @ApiModelProperty("该场景关键字")
    private String scenarioKeyword;

    @ApiModelProperty("该场景图片")
    List<CompanySceneImgDTO> companySceneImgDTOList;

    @ApiModelProperty("该场景视频")
    String video;

    @ApiModelProperty("该场景关联公司")
    List<CompanyUserDTO> companyUserDTOList;
}
