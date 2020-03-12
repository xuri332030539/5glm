package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * 公司基本信息接口
 * @author lhm
 */
@Data
@ApiModel
public class CompanyBaseInfoVO {

    @ApiModelProperty("公司基本信息id,更新时传入")
    private Long id;

    @ApiModelProperty("公司id")
    private Long companyUserId;

    /**
     * 备案
     0-未备案；1-已备案
     */
    @ApiModelProperty("备案")
    private Integer isRecord;

    /**
     * 运营公司名称
     */
    @ApiModelProperty("运营公司名称")
    private String operateCom;

    /**
     * 共建高校院所
     */
    @ApiModelProperty("共建高校院所")
    private String school;

    /**
     * 法人
     */
    @ApiModelProperty("法人")
    private String operName;

    /**
     * 注册资金（万元）
     */
    @ApiModelProperty("注册资金")
    private String registCapi;

    /**
     * 成立时间
     */
    @ApiModelProperty("成立时间")
    private Date startDate;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 资质
     1-规上；2-高企；3-独角兽；4-瞪羚羊
     */
    @ApiModelProperty("资质")
    private String econkind;

    /**
     * AI业务占比
     */
    @ApiModelProperty("AI业务占比")
    private String aiPercent;

    /**
     * 技术分层
     1-基础层；2-技术层；3-硬件终端；4-应用层
     */
    @ApiModelProperty("技术分层")
    private String tecLayer;

    /**
     * 企业简介
     */
    @ApiModelProperty("企业简介")
    private String shortInfo;

    /**
     * 主营业务
     */
    @ApiModelProperty("主营业务")
    private String business;

    /**
     * AI业务方向（核心技术）
     */
    @ApiModelProperty("AI业务方向")
    private String aiBusiness;

    /**
     * 专利总数（件）
     */
    @ApiModelProperty("专利总数")
    private Integer patent;

    /**
     * 主要专利名称（以顿号分割）
     */
    @ApiModelProperty("主要专利名称")
    private String patentName;

    /**
     * 主要项目内容（主营业务）
     */
    @ApiModelProperty("主要项目内容")
    private String projectContents;

    /**
     * 七要素(多选)
     1-算法；2-芯片；3- 模块；4-终端；5-系统；6- 网络；7-平台
     */
    @ApiModelProperty("七要素")
    private String elements;

    /**
     * 行业分类
     1-AI芯片；2-视觉传感器；3-计算机视觉；4-智能语言；5-自然语言处理；6-机器学习/知识图谱；7-云平台/OS/大数据服务；8-智能家居；9-服务机器人；10-移动设备/UAV；11-智能驾驶；12-行业应用
     */
    @ApiModelProperty("行业分类")
    private String classification;

    /**
     * 主要项目
     */
    @ApiModelProperty("主要项目")
    private String project;

    /**
     * 涉及领域
     */
    @ApiModelProperty("涉及领域")
    private String field;

    /**
     * 2019年营业总收入（万元）
     */
    @ApiModelProperty("2019年营业总收入")
    private String countIncome;

    /**
     * 2019年利润总额（万元）
     */
    @ApiModelProperty("2019年利润总额")
    private String countproFits;

    /**
     * 2019年净利润（万元）
     */
    @ApiModelProperty("2019年净利润")
    private String profits;

    /**
     * 2019年主营业务收入构成（％）
     */
    @ApiModelProperty("2019年主营业务收入构成")
    private String incomesPercent;

    /**
     * 2019年度纳税总额（万元）
     */
    @ApiModelProperty("2019年度纳税总额")
    private String tax;

    /**
     * 职工人数（人）
     */
    @ApiModelProperty("职工人数")
    private Integer workerCount;

    /**
     * 研发人数（人）
     */
    @ApiModelProperty("研发人数")
    private Integer developmentCount;

    /**
     * 总投资（万元)
     */
    @ApiModelProperty("总投资")
    private String investment;

    /**
     * 入库批次
     */
    @ApiModelProperty("入库批次")
    private String incomingBatches;

    /**
     * 研发投入占比
     */
    @ApiModelProperty("研发投入占比")
    private String developmentPercent;

    /**
     * 企业联系人
     */
    @ApiModelProperty("企业联系人")
    private String contact;

    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String phone;

    /**
     * 所在地(园区、街道）
     */
    @ApiModelProperty("所在地(园区、街道）")
    private String area;

    @ApiModelProperty("公司所在园区")
    String park;

}
