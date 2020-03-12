package com.st.smartsecurity.service.Impl;

import com.google.common.base.Preconditions;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.mapper.CompanyUserMapper;
import com.st.smartsecurity.pojo.dto.CompanyUserDTO;
import com.st.smartsecurity.pojo.po.CompanyUser;
import com.st.smartsecurity.pojo.vo.CompanyUserVO;
import com.st.smartsecurity.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    @Resource
    CompanyUserMapper companyUserMapper;

    @Override
    public void register(CompanyUserVO companyUserVO) {
        CompanyUser user = new CompanyUser();
        user.setLoginName(companyUserVO.getLoginName());
        Preconditions.checkArgument(companyUserMapper.selectCount(user) == 0,"用户名已存在");
        CompanyUser companyUser = BeanUtil.copyProperties(companyUserVO, CompanyUser.class);
        companyUser.setPwd(DigestUtils.md5Hex(companyUserVO.getPwd()));
        companyUser.setCreateDate(new Date());
        companyUser.setVersionDate(new Date());
        companyUser.setState("F");
        companyUserMapper.insertSelective(companyUser);
    }

    @Override
    public CompanyUserDTO login(String userName, String userPassword) {
        CompanyUser user = new CompanyUser();
        user.setLoginName(userName);
        user.setPwd(DigestUtils.md5Hex(userPassword));
        List<CompanyUser> companyUserList = companyUserMapper.select(user);
        Preconditions.checkArgument(companyUserList.size() > 0,"用户名或密码错误");
        CompanyUser companyUser = companyUserList.get(0);
        CompanyUserDTO companyUserDTO = new CompanyUserDTO();
        companyUserDTO.setCompanyId(companyUser.getId());
        companyUserDTO.setLoginName(companyUser.getLoginName());
        companyUserDTO.setComType(companyUser.getComType());
        return companyUserDTO;
    }

    @Override
    public CompanyUserDTO reset(String comCode) {
        CompanyUser user = new CompanyUser();
        user.setComCode(comCode);
        List<CompanyUser> companyUserList = companyUserMapper.select(user);
        Preconditions.checkArgument(companyUserList.size() != 0,"信用代码不存在");
        CompanyUser companyUser = companyUserList.get(0);
        companyUser.setPwd(DigestUtils.md5Hex("qwer1234"));
        companyUserMapper.updateByPrimaryKeySelective(companyUser);
        CompanyUserDTO companyUserDTO = new CompanyUserDTO();
        companyUserDTO.setLoginName(companyUser.getLoginName());
        companyUserDTO.setPwd("qwer1234");
        return companyUserDTO;
    }
}
