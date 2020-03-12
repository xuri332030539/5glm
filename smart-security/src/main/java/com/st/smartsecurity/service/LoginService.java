package com.st.smartsecurity.service;

import com.st.smartsecurity.pojo.dto.CompanyUserDTO;
import com.st.smartsecurity.pojo.vo.CompanyUserVO;

/**
 * 用户登录注册
 * @author lhm
 */
public interface LoginService {

    /**
     * 用户注册
     * @param companyUserVO
     */
    void register(CompanyUserVO companyUserVO);

    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @return
     */
    CompanyUserDTO login(String userName, String userPassword);

    /**
     * 重置密码
     * @param comCode
     * @return
     */
    CompanyUserDTO reset(String comCode);
}
