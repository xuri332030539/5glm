package com.st.smartsecurity.service;

import com.github.pagehelper.PageInfo;
import com.st.smartsecurity.pojo.dto.CompanyBaseInfoDTO;
import com.st.smartsecurity.pojo.dto.CompanySceneDTO;
import com.st.smartsecurity.pojo.dto.CompanyUserDTO;
import com.st.smartsecurity.pojo.vo.CompanyBaseInfoVO;
import com.st.smartsecurity.pojo.vo.CompanySceneVO;
import com.st.smartsecurity.pojo.vo.params.CompanyParamsVO;

import java.util.List;

/**
 * 公司信息接口
 * @author lhm
 */
public interface CompanyInfoService {

    /**
     * 增加公司信息
     * @param companyBaseInfoVO
     * @return
     */
    void addInfo(CompanyBaseInfoVO companyBaseInfoVO);

    /**
     * 修改公司信息
     * @param companyBaseInfoVO
     */
    void updateCompanyInfo(CompanyBaseInfoVO companyBaseInfoVO);

    /**
     * 获取公司信息
     * @param companyId
     * @return
     */
    CompanyBaseInfoDTO getCompanyInfo(long companyId);

    /**
     * 增加场景信息
     * @param companySceneVO
     */
    void addCompanyScene(CompanySceneVO companySceneVO);

    /**
     * 公司场景列表
     * @param companyId
     * @return
     */
    List<CompanySceneDTO> listCompanyScene(long companyId);

    /**
     * 获取所有公司场景列表
     * @return
     */
    List<CompanySceneDTO> listAllCompanyScene(String type);

    /**
     * 公司列表
     * @return
     */
    PageInfo listCompany(CompanyParamsVO companyParamsVO);

    /**
     * 审核公司
     * @param companyId
     * @param state
     */
    void checkCompany(long companyId, String state);

    /**
     * 获取场景详情
     * @param companySceneId
     * @return
     */
    CompanySceneDTO getCompanyScene(long companySceneId);

    /**
     * 通过场景关键字查询关联公司
     * @param sceneKey
     * @return
     */
    List<CompanyUserDTO> listCompanyBySceneKey(String sceneKey);
}
