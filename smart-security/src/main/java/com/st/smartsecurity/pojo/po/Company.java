package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`company`")
public class Company {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 编号
     */
    @Column(name = "`key`")
    private String key;

    /**
     * 状态
     */
    @Column(name = "`state`")
    private String state;

    /**
     * 专利总数
     */
    @Column(name = "`patent_count`")
    private Integer patentCount;

    /**
     * 详情
     */
    @Column(name = "`content`")
    private String content;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取公司名
     *
     * @return name - 公司名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名
     *
     * @param name 公司名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取编号
     *
     * @return key - 编号
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置编号
     *
     * @param key 编号
     */
    public void setKey(String key) {
        this.key = key;
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
     * 获取专利总数
     *
     * @return patent_count - 专利总数
     */
    public Integer getPatentCount() {
        return patentCount;
    }

    /**
     * 设置专利总数
     *
     * @param patentCount 专利总数
     */
    public void setPatentCount(Integer patentCount) {
        this.patentCount = patentCount;
    }

    /**
     * 获取详情
     *
     * @return content - 详情
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置详情
     *
     * @param content 详情
     */
    public void setContent(String content) {
        this.content = content;
    }
}