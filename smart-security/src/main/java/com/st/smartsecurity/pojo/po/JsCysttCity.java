package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`js_cystt_city`")
public class JsCysttCity {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 城市名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 经纬度
     */
    @Column(name = "`coordinates`")
    private String coordinates;

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
     * 获取城市名
     *
     * @return name - 城市名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置城市名
     *
     * @param name 城市名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取经纬度
     *
     * @return coordinates - 经纬度
     */
    public String getCoordinates() {
        return coordinates;
    }

    /**
     * 设置经纬度
     *
     * @param coordinates 经纬度
     */
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}