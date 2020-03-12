package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`company_scene_img`")
public class CompanySceneImg {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司id
     */
    @Column(name = "`company_id`")
    private Long companyId;

    /**
     * 场景图片
     */
    @Column(name = "`scenario_img`")
    private String scenarioImg;

    @Column(name = "`state`")
    private String state;

    /**
     * 场景id
     */
    @Column(name = "`company_scene_id`")
    private Long companySceneId;

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
     * 获取公司id
     *
     * @return company_id - 公司id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId 公司id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取场景图片
     *
     * @return scenario_img - 场景图片
     */
    public String getScenarioImg() {
        return scenarioImg;
    }

    /**
     * 设置场景图片
     *
     * @param scenarioImg 场景图片
     */
    public void setScenarioImg(String scenarioImg) {
        this.scenarioImg = scenarioImg;
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
     * 获取场景id
     *
     * @return company_scene_id - 场景id
     */
    public Long getCompanySceneId() {
        return companySceneId;
    }

    /**
     * 设置场景id
     *
     * @param companySceneId 场景id
     */
    public void setCompanySceneId(Long companySceneId) {
        this.companySceneId = companySceneId;
    }
}