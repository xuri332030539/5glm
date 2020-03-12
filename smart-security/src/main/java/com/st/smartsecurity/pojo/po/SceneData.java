package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`scene_data`")
public class SceneData {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`changjing`")
    private Integer changjing;

    @Column(name = "`company`")
    private String company;

    @Column(name = "`business`")
    private String business;

    @Column(name = "`coordinates`")
    private Integer coordinates;

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
     * @return changjing
     */
    public Integer getChangjing() {
        return changjing;
    }

    /**
     * @param changjing
     */
    public void setChangjing(Integer changjing) {
        this.changjing = changjing;
    }

    /**
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return business
     */
    public String getBusiness() {
        return business;
    }

    /**
     * @param business
     */
    public void setBusiness(String business) {
        this.business = business;
    }

    /**
     * @return coordinates
     */
    public Integer getCoordinates() {
        return coordinates;
    }

    /**
     * @param coordinates
     */
    public void setCoordinates(Integer coordinates) {
        this.coordinates = coordinates;
    }
}