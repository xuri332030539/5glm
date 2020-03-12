package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`company_scene`")
public class CompanyScene {
    @Id
    @Column(name = "`scene_id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sceneId;

    /**
     * 场景分类
1-智慧交通;2-智能制造;3-智慧产业
     */
    @Column(name = "`scene_classification`")
    private String sceneClassification;

    /**
     * 公司拥有的场景名称
     */
    @Column(name = "`scene`")
    private String scene;

    /**
     * 该场景关键字（必填、以顿号分割）
     */
    @Column(name = "`scenario_keyword`")
    private String scenarioKeyword;

    /**
     * 视频
     */
    @Column(name = "`video`")
    private String video;

    /**
     * 状态
     */
    @Column(name = "`state`")
    private String state;

    /**
     * 公司id
     */
    @Column(name = "`company_id`")
    private Long companyId;

    /**
     * 公司对该场景的定义
     */
    @Column(name = "`scenario_defined`")
    private String scenarioDefined;

    /**
     * @return scene_id
     */
    public Long getSceneId() {
        return sceneId;
    }

    /**
     * @param sceneId
     */
    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    /**
     * 获取场景分类
1-智慧交通;2-智能制造;3-智慧产业
     *
     * @return scene_classification - 场景分类
1-智慧交通;2-智能制造;3-智慧产业
     */
    public String getSceneClassification() {
        return sceneClassification;
    }

    /**
     * 设置场景分类
1-智慧交通;2-智能制造;3-智慧产业
     *
     * @param sceneClassification 场景分类
1-智慧交通;2-智能制造;3-智慧产业
     */
    public void setSceneClassification(String sceneClassification) {
        this.sceneClassification = sceneClassification;
    }

    /**
     * 获取公司拥有的场景名称
     *
     * @return scene - 公司拥有的场景名称
     */
    public String getScene() {
        return scene;
    }

    /**
     * 设置公司拥有的场景名称
     *
     * @param scene 公司拥有的场景名称
     */
    public void setScene(String scene) {
        this.scene = scene;
    }

    /**
     * 获取该场景关键字（必填、以顿号分割）
     *
     * @return scenario_keyword - 该场景关键字（必填、以顿号分割）
     */
    public String getScenarioKeyword() {
        return scenarioKeyword;
    }

    /**
     * 设置该场景关键字（必填、以顿号分割）
     *
     * @param scenarioKeyword 该场景关键字（必填、以顿号分割）
     */
    public void setScenarioKeyword(String scenarioKeyword) {
        this.scenarioKeyword = scenarioKeyword;
    }

    /**
     * 获取视频
     *
     * @return video - 视频
     */
    public String getVideo() {
        return video;
    }

    /**
     * 设置视频
     *
     * @param video 视频
     */
    public void setVideo(String video) {
        this.video = video;
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
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
     * 获取公司对该场景的定义
     *
     * @return scenario_defined - 公司对该场景的定义
     */
    public String getScenarioDefined() {
        return scenarioDefined;
    }

    /**
     * 设置公司对该场景的定义
     *
     * @param scenarioDefined 公司对该场景的定义
     */
    public void setScenarioDefined(String scenarioDefined) {
        this.scenarioDefined = scenarioDefined;
    }
}