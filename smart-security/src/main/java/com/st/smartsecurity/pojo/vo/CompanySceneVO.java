package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

/**
 * 公司场景
 * @author lhm
 */
@Data
@ApiModel(value = "公司场景")
public class CompanySceneVO {

    @ApiModelProperty(value = "场景id,更新传")
    private Long sceneId;

    /**
     * 场景分类
     1-智慧交通;2-智能制造;3-智慧城市;4-智慧医疗
     */
    @ApiModelProperty(value = "场景分类")
    private String sceneClassification;

    /**
     * 公司拥有的场景名称
     */
    @ApiModelProperty(value = "公司拥有的场景名称")
    private String scene;

    /**
     * 公司对该场景的定义
     */
    @ApiModelProperty(value = "公司对该场景的定义")
    private String scenarioDefined;

    /**
     * 该场景关键字（必填、以顿号分割）
     */
    @ApiModelProperty(value = "该场景关键字")
    private String scenarioKeyword;

    /**
     * 视频
     */
    @ApiModelProperty(value = "视频")
    private String video;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;

    /**
     * 公司基本信息id
     */
    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty("该场景图片")
    List<String> scenarioImgList;
}
