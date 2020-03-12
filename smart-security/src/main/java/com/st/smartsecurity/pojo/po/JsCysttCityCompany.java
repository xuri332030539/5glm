package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`js_cystt_city_company`")
public class JsCysttCityCompany {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 城市id
     */
    @Column(name = "`js_city_id`")
    private Integer jsCityId;

    /**
     * 元素
     */
    @Column(name = "`elements`")
    private String elements;

    /**
     * 内容
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
     * 获取城市id
     *
     * @return js_city_id - 城市id
     */
    public Integer getJsCityId() {
        return jsCityId;
    }

    /**
     * 设置城市id
     *
     * @param jsCityId 城市id
     */
    public void setJsCityId(Integer jsCityId) {
        this.jsCityId = jsCityId;
    }

    /**
     * 获取元素
     *
     * @return elements - 元素
     */
    public String getElements() {
        return elements;
    }

    /**
     * 设置元素
     *
     * @param elements 元素
     */
    public void setElements(String elements) {
        this.elements = elements;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}