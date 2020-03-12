package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`company_list_info`")
public class CompanyListInfo {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联company_list
     */
    @Column(name = "`company_list_id`")
    private Integer companyListId;

    @Column(name = "`type`")
    private String type;

    /**
     * 详细信息
     */
    @Column(name = "`test`")
    private String test;

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
     * 获取关联company_list
     *
     * @return company_list_id - 关联company_list
     */
    public Integer getCompanyListId() {
        return companyListId;
    }

    /**
     * 设置关联company_list
     *
     * @param companyListId 关联company_list
     */
    public void setCompanyListId(Integer companyListId) {
        this.companyListId = companyListId;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取详细信息
     *
     * @return test - 详细信息
     */
    public String getTest() {
        return test;
    }

    /**
     * 设置详细信息
     *
     * @param test 详细信息
     */
    public void setTest(String test) {
        this.test = test;
    }
}