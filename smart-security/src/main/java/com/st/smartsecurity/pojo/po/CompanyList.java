package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`company_list`")
public class CompanyList {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`state`")
    private String state;

    @Column(name = "`create_date`")
    private Date createDate;

    @Column(name = "`version_date`")
    private Date versionDate;

    /**
     * 地区
     */
    @Column(name = "`area`")
    private String area;

    @Column(name = "`properties`")
    private String properties;

    @Column(name = "`geometry`")
    private String geometry;

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
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return version_date
     */
    public Date getVersionDate() {
        return versionDate;
    }

    /**
     * @param versionDate
     */
    public void setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
    }

    /**
     * 获取地区
     *
     * @return area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return properties
     */
    public String getProperties() {
        return properties;
    }

    /**
     * @param properties
     */
    public void setProperties(String properties) {
        this.properties = properties;
    }

    /**
     * @return geometry
     */
    public String getGeometry() {
        return geometry;
    }

    /**
     * @param geometry
     */
    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
}