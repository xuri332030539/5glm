package com.st.smartsecurity.controller;

import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 创建人:< Chenmq>
 * @project 项目:<chuangyin-data>
 * @date 创建时间:< 2017/8/22>
 * @comments: 说明:< //TODO >
 */

@RestController
@RequestMapping("/qiniu")
public class QiniuController {

    private static final Logger logger = LoggerFactory.getLogger(QiniuController.class);

    @Resource
    private FileService fileService;


    /**
     * 上传图片文件七牛云
     * @param files
     * @return
     */
    @PassToken
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public List<String> uploadImg(@RequestParam("file") MultipartFile[] files) {

        // 返回类型可以自己定义

        // 验证非空
        Map<String,List<String>> map = new HashMap<>();

        map = fileService.uploadImgs(files);

        List<String> resultList = map.get("result");
        logger.info("图片上传返回结果:"+resultList);

        return resultList;
    }

    @PostMapping("test")
    @ApiOperation(value = "test")
    @PassToken
    public BaseResponse test(){
        return BaseResponse.success();
    }
}

