package com.st.smartsecurity.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.OftenConstant;
import com.st.smartsecurity.mapper.CompanyBaseInfoMapper;
import com.st.smartsecurity.mapper.CompanySceneImgMapper;
import com.st.smartsecurity.mapper.CompanySceneMapper;
import com.st.smartsecurity.mapper.CompanyUserMapper;
import com.st.smartsecurity.pojo.dto.CompanyBaseInfoDTO;
import com.st.smartsecurity.pojo.dto.CompanySceneDTO;
import com.st.smartsecurity.pojo.dto.CompanySceneImgDTO;
import com.st.smartsecurity.pojo.dto.CompanyUserDTO;
import com.st.smartsecurity.pojo.po.CompanyBaseInfo;
import com.st.smartsecurity.pojo.po.CompanyScene;
import com.st.smartsecurity.pojo.po.CompanySceneImg;
import com.st.smartsecurity.pojo.po.CompanyUser;
import com.st.smartsecurity.pojo.vo.CompanyBaseInfoVO;
import com.st.smartsecurity.pojo.vo.CompanySceneVO;
import com.st.smartsecurity.pojo.vo.params.CompanyParamsVO;
import com.st.smartsecurity.service.CompanyInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公司信息接口
 * @author lhm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Resource
    CompanyBaseInfoMapper companyBaseInfoMapper;
    @Resource
    CompanyUserMapper companyUserMapper;
    @Resource
    CompanySceneImgMapper companySceneImgMapper;
    @Resource
    CompanySceneMapper companySceneMapper;

    @Override
    public void addInfo(CompanyBaseInfoVO companyBaseInfoVO) {
        CompanyBaseInfo select = new CompanyBaseInfo();
        select.setCompanyUserId(companyBaseInfoVO.getCompanyUserId());
        List<CompanyBaseInfo> companyBaseInfoList = companyBaseInfoMapper.select(select);
        if(companyBaseInfoList != null && companyBaseInfoList.size() >0){
            select = companyBaseInfoList.get(0);
            companyBaseInfoVO.setId(select.getId());
            this.updateCompanyInfo(companyBaseInfoVO);
        }else {
            CompanyBaseInfo companyBaseInfo = BeanUtil.copyProperties(companyBaseInfoVO, CompanyBaseInfo.class);
            companyBaseInfo.setState(OftenConstant.NORMAL_STATE);
            companyBaseInfoMapper.insertSelective(companyBaseInfo);

        }
    }

    @Override
    public void updateCompanyInfo(CompanyBaseInfoVO companyBaseInfoVO) {
        CompanyBaseInfo companyBaseInfo = BeanUtil.copyProperties(companyBaseInfoVO, CompanyBaseInfo.class);
        companyBaseInfoMapper.updateByPrimaryKeySelective(companyBaseInfo);
    }

    @Override
    public CompanyBaseInfoDTO getCompanyInfo(long companyId) {
        CompanyUser companyUser = companyUserMapper.selectByPrimaryKey(companyId);
        Preconditions.checkArgument(companyUser != null,"没有此公司");
        CompanyBaseInfoDTO companyBaseInfoDTO = new CompanyBaseInfoDTO();


        //添加基本信息
        CompanyBaseInfo companyBaseInfo = new CompanyBaseInfo();
        companyBaseInfo.setCompanyUserId(companyUser.getId());
        List<CompanyBaseInfo> companyBaseInfoList = companyBaseInfoMapper.select(companyBaseInfo);
        Preconditions.checkArgument(companyBaseInfoList.size() > 0,"该公司没有基本信息");
        companyBaseInfo = companyBaseInfoList.get(0);
        companyBaseInfoDTO = BeanUtil.copyProperties(companyBaseInfo, CompanyBaseInfoDTO.class);

        companyBaseInfoDTO.setComName(companyUser.getComName());
        companyBaseInfoDTO.setComCode(companyUser.getComCode());
        companyBaseInfoDTO.setLoginName(companyUser.getLoginName());

        //添加场景信息
        CompanyScene companyScene = new CompanyScene();
        companyScene.setCompanyId(companyUser.getId());
        List<CompanyScene> companySceneList = companySceneMapper.select(companyScene);
        List<CompanySceneDTO> companySceneDTOList = Lists.newArrayList();
        for (CompanyScene scene:companySceneList) {
            companySceneDTOList.add(this.getCompanyScene(scene.getSceneId()));
        }
        companyBaseInfoDTO.setCompanySceneDTOList(companySceneDTOList);

        return companyBaseInfoDTO;
    }

    @Override
    public void addCompanyScene(CompanySceneVO companySceneVO) {
        CompanyScene companyScene = BeanUtil.copyProperties(companySceneVO, CompanyScene.class);
        if(companyScene.getSceneId() != null){
            companySceneMapper.updateByPrimaryKeySelective(companyScene);
        } else {
            companyScene.setState("N");
            companySceneMapper.insertSelective(companyScene);
        }
        if(companySceneVO.getScenarioImgList() != null && companySceneVO.getScenarioImgList().size() != 0){
            CompanySceneImg sceneImg = new CompanySceneImg();
            sceneImg.setState("D");
            Example example = new Example(CompanySceneImg.class);
            example.createCriteria().andEqualTo("companyId",companyScene.getCompanyId()).andEqualTo("companySceneId",companyScene.getSceneId());
            companySceneImgMapper.updateByExampleSelective(sceneImg,example);
            for (String imgAddress:companySceneVO.getScenarioImgList()) {
                CompanySceneImg companySceneImg = new CompanySceneImg();
                companySceneImg.setCompanyId(companyScene.getCompanyId());
                companySceneImg.setScenarioImg(imgAddress);
                companySceneImg.setState("N");
                companySceneImg.setCompanySceneId(companyScene.getSceneId());
                companySceneImgMapper.insertSelective(companySceneImg);
            }
        }
    }

    @Override
    public List<CompanySceneDTO> listCompanyScene(long companyId) {
        CompanyScene companyScene = new CompanyScene();
        companyScene.setCompanyId(companyId);
        List<CompanyScene> companySceneList = companySceneMapper.select(companyScene);
        List<CompanySceneDTO> companySceneDTOList = Lists.newArrayList();
        for (CompanyScene scene:companySceneList) {
            CompanySceneDTO companySceneDTO = BeanUtil.copyProperties(scene, CompanySceneDTO.class);
            companySceneDTOList.add(companySceneDTO);
        }
        return companySceneDTOList;
    }

    @Override
    public List<CompanySceneDTO> listAllCompanyScene(String type) {
        CompanyScene companyScene = new CompanyScene();
        companyScene.setSceneClassification(type);
        List<CompanyScene> companySceneList = companySceneMapper.select(companyScene);
        List<CompanySceneDTO> companySceneDTOList = Lists.newArrayList();
        for (CompanyScene scene:companySceneList) {
            CompanySceneDTO companySceneDTO = BeanUtil.copyProperties(scene, CompanySceneDTO.class);
            companySceneDTOList.add(companySceneDTO);
        }
        return companySceneDTOList;
    }

    @Override
    public PageInfo listCompany(CompanyParamsVO companyParamsVO) {
        Example example = new Example(CompanyUser.class);
        example.createCriteria().andNotEqualTo("state","D");
        example.setOrderByClause("state ASC");
        PageHelper.startPage(companyParamsVO.getPageNum(), companyParamsVO.getPageSize());
        List<CompanyUser> companyUserList = companyUserMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(companyUserList);
        List<CompanyUserDTO> companyUserDTOList = Lists.newArrayList();
        List<CompanyUser> companyUsers = pageInfo.getList();
        for (CompanyUser companyUser:companyUsers) {
            CompanyUserDTO companyUserDTO = BeanUtil.copyProperties(companyUser, CompanyUserDTO.class);
            companyUserDTO.setPwd(null);
            companyUserDTO.setCompanyId(companyUser.getId());
            companyUserDTOList.add(companyUserDTO);
        }
        pageInfo.setList(companyUserDTOList);
        return pageInfo;
    }

    @Override
    public void checkCompany(long companyId, String state) {
        CompanyUser companyUser = new CompanyUser();
        companyUser.setId(companyId);
        companyUser.setState(state);
        companyUserMapper.updateByPrimaryKeySelective(companyUser);
    }

    @Override
    public CompanySceneDTO getCompanyScene(long companySceneId) {
        CompanyScene companyScene = companySceneMapper.selectByPrimaryKey(companySceneId);
        Preconditions.checkArgument(companyScene != null, "没有此场景");
        CompanySceneDTO companySceneDTO = BeanUtil.copyProperties(companyScene, CompanySceneDTO.class);
        //添加场景图片
        CompanySceneImg companySceneImg = new CompanySceneImg();
        companySceneImg.setState("N");
        companySceneImg.setCompanySceneId(companyScene.getSceneId());
        List<CompanySceneImg> companySceneImgList = companySceneImgMapper.select(companySceneImg);
        List<CompanySceneImgDTO> companySceneImgDTOList = Lists.newArrayList();
        for (CompanySceneImg sceneImg:companySceneImgList) {
            CompanySceneImgDTO companySceneImgDTO = BeanUtil.copyProperties(sceneImg, CompanySceneImgDTO.class);
            companySceneImgDTOList.add(companySceneImgDTO);
        }
        companySceneDTO.setCompanySceneImgDTOList(companySceneImgDTOList);
        if(companyScene.getScenarioKeyword() != null){
            List<CompanyUserDTO> companyUserDTOList = this.listCompanyBySceneKey(companyScene.getScenarioKeyword());
            companySceneDTO.setCompanyUserDTOList(companyUserDTOList);
        }
        return companySceneDTO;
    }

    @Override
    public List<CompanyUserDTO> listCompanyBySceneKey(String sceneKey) {
        String[] keys = sceneKey.split("、");
        List<Long> companyIdList = Lists.newArrayList();
        for (String key:keys) {
            Example example = new Example(CompanyScene.class);
            example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE).andLike("scenarioDefined","%"+key+"%");
            List<CompanyScene> companySceneList = companySceneMapper.selectByExample(example);
            for (CompanyScene companyScene:companySceneList) {
                if(companyScene.getCompanyId() != null){
                    companyIdList.add(companyScene.getCompanyId());
                }
            }
        }
        //去重
        List<Long> resultId = Lists.newArrayList();
        for (Long id:companyIdList) {
            if(!resultId.contains(id)){
                resultId.add(id);
            }
        }
        //查询公司
        List<CompanyUserDTO> companyUserDTOList = Lists.newArrayList();
        for (Long id:resultId) {
            CompanyUser companyUser = companyUserMapper.selectByPrimaryKey(id);
            if(companyUser != null){
                CompanyUserDTO companyUserDTO = BeanUtil.copyProperties(companyUser, CompanyUserDTO.class);
                companyUserDTO.setPwd(null);
                companyUserDTO.setCompanyId(companyUser.getId());
                //专利
                CompanyBaseInfo companyBaseInfo = new CompanyBaseInfo();
                companyBaseInfo.setCompanyUserId(companyUser.getId());
                companyBaseInfo.setState(OftenConstant.NORMAL_STATE);
                List<CompanyBaseInfo> companyBaseInfoList = companyBaseInfoMapper.select(companyBaseInfo);
                if(companyBaseInfoList.size() != 0){
                    companyBaseInfo = companyBaseInfoList.get(0);
                    if(companyBaseInfo.getPark() != null){
                        companyUserDTO.setPark(companyBaseInfo.getPark());
                    }
                }
                companyUserDTOList.add(companyUserDTO);
            }
        }
        return companyUserDTOList;
    }

    @Override
    public void deleteCompanyScene(long companySceneId) {
        CompanyScene companyScene = new CompanyScene();
        companyScene.setState(OftenConstant.DELETE_STATE);
        companyScene.setSceneId(companySceneId);
        companySceneMapper.updateByPrimaryKeySelective(companyScene);
    }
}
