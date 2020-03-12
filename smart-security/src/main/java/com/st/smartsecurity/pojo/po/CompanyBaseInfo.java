package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`company_base_info`")
public class CompanyBaseInfo {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`company_user_id`")
    private Long companyUserId;

    /**
     * 备案
0-未备案；1-已备案
     */
    @Column(name = "`is_record`")
    private Integer isRecord;

    /**
     * 运营公司名称
     */
    @Column(name = "`operate_com`")
    private String operateCom;

    /**
     * 共建高校院所
     */
    @Column(name = "`school`")
    private String school;

    /**
     * 法人
     */
    @Column(name = "`oper_name`")
    private String operName;

    /**
     * 注册资金（万元）
     */
    @Column(name = "`regist_capi`")
    private String registCapi;

    /**
     * 成立时间
     */
    @Column(name = "`start_date`")
    private Date startDate;

    /**
     * 地址
     */
    @Column(name = "`address`")
    private String address;

    /**
     * 资质
1-规上；2-高企；3-独角兽；4-瞪羚羊
     */
    @Column(name = "`econKind`")
    private String econkind;

    /**
     * AI业务占比
     */
    @Column(name = "`ai_percent`")
    private String aiPercent;

    /**
     * 技术分层
1-基础层；2-技术层；3-硬件终端；4-应用层
     */
    @Column(name = "`tec_layer`")
    private String tecLayer;

    /**
     * 企业简介
     */
    @Column(name = "`short_info`")
    private String shortInfo;

    /**
     * 主营业务
     */
    @Column(name = "`business`")
    private String business;

    /**
     * AI业务方向（核心技术）
     */
    @Column(name = "`ai_business`")
    private String aiBusiness;

    /**
     * 专利总数（件）
     */
    @Column(name = "`patent`")
    private Integer patent;

    /**
     * 主要专利名称（以顿号分割）
     */
    @Column(name = "`patent_name`")
    private String patentName;

    /**
     * 主要项目内容（主营业务）
     */
    @Column(name = "`project_contents`")
    private String projectContents;

    /**
     * 七要素(多选)
1-算法；2-芯片；3- 模块；4-终端；5-系统；6- 网络；7-平台
     */
    @Column(name = "`elements`")
    private String elements;

    /**
     * 行业分类
1-AI芯片；2-视觉传感器；3-计算机视觉；4-智能语言；5-自然语言处理；6-机器学习/知识图谱；7-云平台/OS/大数据服务；8-智能家居；9-服务机器人；10-移动设备/UAV；11-智能驾驶；12-行业应用
     */
    @Column(name = "`classification`")
    private String classification;

    /**
     * 主要项目
     */
    @Column(name = "`project`")
    private String project;

    /**
     * 涉及领域
     */
    @Column(name = "`field`")
    private String field;

    /**
     * 2019年营业总收入（万元）
     */
    @Column(name = "`count_income`")
    private String countIncome;

    /**
     * 2019年利润总额（万元）
     */
    @Column(name = "`countpro_fits`")
    private String countproFits;

    /**
     * 2019年净利润（万元）
     */
    @Column(name = "`profits`")
    private String profits;

    /**
     * 2019年主营业务收入构成（％）
     */
    @Column(name = "`incomes_percent`")
    private String incomesPercent;

    /**
     * 2019年度纳税总额（万元）
     */
    @Column(name = "`tax`")
    private String tax;

    /**
     * 职工人数（人）
     */
    @Column(name = "`worker_count`")
    private Integer workerCount;

    /**
     * 研发人数（人）
     */
    @Column(name = "`development_count`")
    private Integer developmentCount;

    /**
     * 总投资（万元)
     */
    @Column(name = "`investment`")
    private String investment;

    /**
     * 入库批次
     */
    @Column(name = "`incoming_batches`")
    private String incomingBatches;

    /**
     * 研发投入占比
     */
    @Column(name = "`development_percent`")
    private String developmentPercent;

    @Column(name = "`state`")
    private String state;

    /**
     * 企业联系人
     */
    @Column(name = "`contact`")
    private String contact;

    /**
     * 联系方式
     */
    @Column(name = "`phone`")
    private String phone;

    /**
     * 所在地(园区、街道）
     */
    @Column(name = "`area`")
    private String area;

    /**
     * 所在园区
     */
    @Column(name = "`park`")
    private String park;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return company_user_id
     */
    public Long getCompanyUserId() {
        return companyUserId;
    }

    /**
     * @param companyUserId
     */
    public void setCompanyUserId(Long companyUserId) {
        this.companyUserId = companyUserId;
    }

    /**
     * 获取备案
0-未备案；1-已备案
     *
     * @return is_record - 备案
0-未备案；1-已备案
     */
    public Integer getIsRecord() {
        return isRecord;
    }

    /**
     * 设置备案
0-未备案；1-已备案
     *
     * @param isRecord 备案
0-未备案；1-已备案
     */
    public void setIsRecord(Integer isRecord) {
        this.isRecord = isRecord;
    }

    /**
     * 获取运营公司名称
     *
     * @return operate_com - 运营公司名称
     */
    public String getOperateCom() {
        return operateCom;
    }

    /**
     * 设置运营公司名称
     *
     * @param operateCom 运营公司名称
     */
    public void setOperateCom(String operateCom) {
        this.operateCom = operateCom;
    }

    /**
     * 获取共建高校院所
     *
     * @return school - 共建高校院所
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置共建高校院所
     *
     * @param school 共建高校院所
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 获取法人
     *
     * @return oper_name - 法人
     */
    public String getOperName() {
        return operName;
    }

    /**
     * 设置法人
     *
     * @param operName 法人
     */
    public void setOperName(String operName) {
        this.operName = operName;
    }

    /**
     * 获取注册资金（万元）
     *
     * @return regist_capi - 注册资金（万元）
     */
    public String getRegistCapi() {
        return registCapi;
    }

    /**
     * 设置注册资金（万元）
     *
     * @param registCapi 注册资金（万元）
     */
    public void setRegistCapi(String registCapi) {
        this.registCapi = registCapi;
    }

    /**
     * 获取成立时间
     *
     * @return start_date - 成立时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置成立时间
     *
     * @param startDate 成立时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取资质
1-规上；2-高企；3-独角兽；4-瞪羚羊
     *
     * @return econKind - 资质
1-规上；2-高企；3-独角兽；4-瞪羚羊
     */
    public String getEconkind() {
        return econkind;
    }

    /**
     * 设置资质
1-规上；2-高企；3-独角兽；4-瞪羚羊
     *
     * @param econkind 资质
1-规上；2-高企；3-独角兽；4-瞪羚羊
     */
    public void setEconkind(String econkind) {
        this.econkind = econkind;
    }

    /**
     * 获取AI业务占比
     *
     * @return ai_percent - AI业务占比
     */
    public String getAiPercent() {
        return aiPercent;
    }

    /**
     * 设置AI业务占比
     *
     * @param aiPercent AI业务占比
     */
    public void setAiPercent(String aiPercent) {
        this.aiPercent = aiPercent;
    }

    /**
     * 获取技术分层
1-基础层；2-技术层；3-硬件终端；4-应用层
     *
     * @return tec_layer - 技术分层
1-基础层；2-技术层；3-硬件终端；4-应用层
     */
    public String getTecLayer() {
        return tecLayer;
    }

    /**
     * 设置技术分层
1-基础层；2-技术层；3-硬件终端；4-应用层
     *
     * @param tecLayer 技术分层
1-基础层；2-技术层；3-硬件终端；4-应用层
     */
    public void setTecLayer(String tecLayer) {
        this.tecLayer = tecLayer;
    }

    /**
     * 获取企业简介
     *
     * @return short_info - 企业简介
     */
    public String getShortInfo() {
        return shortInfo;
    }

    /**
     * 设置企业简介
     *
     * @param shortInfo 企业简介
     */
    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    /**
     * 获取主营业务
     *
     * @return business - 主营业务
     */
    public String getBusiness() {
        return business;
    }

    /**
     * 设置主营业务
     *
     * @param business 主营业务
     */
    public void setBusiness(String business) {
        this.business = business;
    }

    /**
     * 获取AI业务方向（核心技术）
     *
     * @return ai_business - AI业务方向（核心技术）
     */
    public String getAiBusiness() {
        return aiBusiness;
    }

    /**
     * 设置AI业务方向（核心技术）
     *
     * @param aiBusiness AI业务方向（核心技术）
     */
    public void setAiBusiness(String aiBusiness) {
        this.aiBusiness = aiBusiness;
    }

    /**
     * 获取专利总数（件）
     *
     * @return patent - 专利总数（件）
     */
    public Integer getPatent() {
        return patent;
    }

    /**
     * 设置专利总数（件）
     *
     * @param patent 专利总数（件）
     */
    public void setPatent(Integer patent) {
        this.patent = patent;
    }

    /**
     * 获取主要专利名称（以顿号分割）
     *
     * @return patent_name - 主要专利名称（以顿号分割）
     */
    public String getPatentName() {
        return patentName;
    }

    /**
     * 设置主要专利名称（以顿号分割）
     *
     * @param patentName 主要专利名称（以顿号分割）
     */
    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    /**
     * 获取主要项目内容（主营业务）
     *
     * @return project_contents - 主要项目内容（主营业务）
     */
    public String getProjectContents() {
        return projectContents;
    }

    /**
     * 设置主要项目内容（主营业务）
     *
     * @param projectContents 主要项目内容（主营业务）
     */
    public void setProjectContents(String projectContents) {
        this.projectContents = projectContents;
    }

    /**
     * 获取七要素(多选)
1-算法；2-芯片；3- 模块；4-终端；5-系统；6- 网络；7-平台
     *
     * @return elements - 七要素(多选)
1-算法；2-芯片；3- 模块；4-终端；5-系统；6- 网络；7-平台
     */
    public String getElements() {
        return elements;
    }

    /**
     * 设置七要素(多选)
1-算法；2-芯片；3- 模块；4-终端；5-系统；6- 网络；7-平台
     *
     * @param elements 七要素(多选)
1-算法；2-芯片；3- 模块；4-终端；5-系统；6- 网络；7-平台
     */
    public void setElements(String elements) {
        this.elements = elements;
    }

    /**
     * 获取行业分类
1-AI芯片；2-视觉传感器；3-计算机视觉；4-智能语言；5-自然语言处理；6-机器学习/知识图谱；7-云平台/OS/大数据服务；8-智能家居；9-服务机器人；10-移动设备/UAV；11-智能驾驶；12-行业应用
     *
     * @return classification - 行业分类
1-AI芯片；2-视觉传感器；3-计算机视觉；4-智能语言；5-自然语言处理；6-机器学习/知识图谱；7-云平台/OS/大数据服务；8-智能家居；9-服务机器人；10-移动设备/UAV；11-智能驾驶；12-行业应用
     */
    public String getClassification() {
        return classification;
    }

    /**
     * 设置行业分类
1-AI芯片；2-视觉传感器；3-计算机视觉；4-智能语言；5-自然语言处理；6-机器学习/知识图谱；7-云平台/OS/大数据服务；8-智能家居；9-服务机器人；10-移动设备/UAV；11-智能驾驶；12-行业应用
     *
     * @param classification 行业分类
1-AI芯片；2-视觉传感器；3-计算机视觉；4-智能语言；5-自然语言处理；6-机器学习/知识图谱；7-云平台/OS/大数据服务；8-智能家居；9-服务机器人；10-移动设备/UAV；11-智能驾驶；12-行业应用
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * 获取主要项目
     *
     * @return project - 主要项目
     */
    public String getProject() {
        return project;
    }

    /**
     * 设置主要项目
     *
     * @param project 主要项目
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * 获取涉及领域
     *
     * @return field - 涉及领域
     */
    public String getField() {
        return field;
    }

    /**
     * 设置涉及领域
     *
     * @param field 涉及领域
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * 获取2019年营业总收入（万元）
     *
     * @return count_income - 2019年营业总收入（万元）
     */
    public String getCountIncome() {
        return countIncome;
    }

    /**
     * 设置2019年营业总收入（万元）
     *
     * @param countIncome 2019年营业总收入（万元）
     */
    public void setCountIncome(String countIncome) {
        this.countIncome = countIncome;
    }

    /**
     * 获取2019年利润总额（万元）
     *
     * @return countpro_fits - 2019年利润总额（万元）
     */
    public String getCountproFits() {
        return countproFits;
    }

    /**
     * 设置2019年利润总额（万元）
     *
     * @param countproFits 2019年利润总额（万元）
     */
    public void setCountproFits(String countproFits) {
        this.countproFits = countproFits;
    }

    /**
     * 获取2019年净利润（万元）
     *
     * @return profits - 2019年净利润（万元）
     */
    public String getProfits() {
        return profits;
    }

    /**
     * 设置2019年净利润（万元）
     *
     * @param profits 2019年净利润（万元）
     */
    public void setProfits(String profits) {
        this.profits = profits;
    }

    /**
     * 获取2019年主营业务收入构成（％）
     *
     * @return incomes_percent - 2019年主营业务收入构成（％）
     */
    public String getIncomesPercent() {
        return incomesPercent;
    }

    /**
     * 设置2019年主营业务收入构成（％）
     *
     * @param incomesPercent 2019年主营业务收入构成（％）
     */
    public void setIncomesPercent(String incomesPercent) {
        this.incomesPercent = incomesPercent;
    }

    /**
     * 获取2019年度纳税总额（万元）
     *
     * @return tax - 2019年度纳税总额（万元）
     */
    public String getTax() {
        return tax;
    }

    /**
     * 设置2019年度纳税总额（万元）
     *
     * @param tax 2019年度纳税总额（万元）
     */
    public void setTax(String tax) {
        this.tax = tax;
    }

    /**
     * 获取职工人数（人）
     *
     * @return worker_count - 职工人数（人）
     */
    public Integer getWorkerCount() {
        return workerCount;
    }

    /**
     * 设置职工人数（人）
     *
     * @param workerCount 职工人数（人）
     */
    public void setWorkerCount(Integer workerCount) {
        this.workerCount = workerCount;
    }

    /**
     * 获取研发人数（人）
     *
     * @return development_count - 研发人数（人）
     */
    public Integer getDevelopmentCount() {
        return developmentCount;
    }

    /**
     * 设置研发人数（人）
     *
     * @param developmentCount 研发人数（人）
     */
    public void setDevelopmentCount(Integer developmentCount) {
        this.developmentCount = developmentCount;
    }

    /**
     * 获取总投资（万元)
     *
     * @return investment - 总投资（万元)
     */
    public String getInvestment() {
        return investment;
    }

    /**
     * 设置总投资（万元)
     *
     * @param investment 总投资（万元)
     */
    public void setInvestment(String investment) {
        this.investment = investment;
    }

    /**
     * 获取入库批次
     *
     * @return incoming_batches - 入库批次
     */
    public String getIncomingBatches() {
        return incomingBatches;
    }

    /**
     * 设置入库批次
     *
     * @param incomingBatches 入库批次
     */
    public void setIncomingBatches(String incomingBatches) {
        this.incomingBatches = incomingBatches;
    }

    /**
     * 获取研发投入占比
     *
     * @return development_percent - 研发投入占比
     */
    public String getDevelopmentPercent() {
        return developmentPercent;
    }

    /**
     * 设置研发投入占比
     *
     * @param developmentPercent 研发投入占比
     */
    public void setDevelopmentPercent(String developmentPercent) {
        this.developmentPercent = developmentPercent;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取企业联系人
     *
     * @return contact - 企业联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置企业联系人
     *
     * @param contact 企业联系人
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取联系方式
     *
     * @return phone - 联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系方式
     *
     * @param phone 联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取所在地(园区、街道）
     *
     * @return area - 所在地(园区、街道）
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置所在地(园区、街道）
     *
     * @param area 所在地(园区、街道）
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取所在园区
     *
     * @return park - 所在园区
     */
    public String getPark() {
        return park;
    }

    /**
     * 设置所在园区
     *
     * @param park 所在园区
     */
    public void setPark(String park) {
        this.park = park;
    }
}