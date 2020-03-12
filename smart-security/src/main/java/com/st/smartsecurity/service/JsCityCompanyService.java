package com.st.smartsecurity.service;

/**
 * 江苏产业生态图公司管理
 * @author lhm
 */
public interface JsCityCompanyService {

    /**
     * 添加多个公司
     * @param cityId
     * @param companyInfo
     */
    void addCompany(int cityId, String companyInfo);
}
