package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`company_user`")
public class CompanyUser {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`com_name`")
    private String comName;

    @Column(name = "`login_name`")
    private String loginName;

    @Column(name = "`pwd`")
    private String pwd;

    @Column(name = "`com_code`")
    private String comCode;

    @Column(name = "`state`")
    private String state;

    @Column(name = "`create_date`")
    private Date createDate;

    @Column(name = "`version_date`")
    private Date versionDate;

    @Column(name = "`com_type`")
    private Long comType;

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
     * @return com_name
     */
    public String getComName() {
        return comName;
    }

    /**
     * @param comName
     */
    public void setComName(String comName) {
        this.comName = comName;
    }

    /**
     * @return login_name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return com_code
     */
    public String getComCode() {
        return comCode;
    }

    /**
     * @param comCode
     */
    public void setComCode(String comCode) {
        this.comCode = comCode;
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
     * @return com_type
     */
    public Long getComType() {
        return comType;
    }

    /**
     * @param comType
     */
    public void setComType(Long comType) {
        this.comType = comType;
    }
}