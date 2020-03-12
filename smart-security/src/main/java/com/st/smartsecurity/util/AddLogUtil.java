//package com.st.smartsecurity.util;
//
//import com.st.smartsecurity.pojo.po.Log;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//
///**
// *
// * @author xuri
// * @date 2019/10/24
// */
//@Component
//public class AddLogUtil {
//    @Resource
//    HttpServletRequest servletRequest;
//    @Resource
//    LogMapper logMapper;
//
//    public void addLog(String msg){
//        Object loginName = servletRequest.getSession().getAttribute("loginName");
//        if (loginName==null){
//            return;
//        }
//        Object loginRole = servletRequest.getSession().getAttribute("loginRole");
//        Log log = new Log();
//        log.setName(loginName.toString());
//        log.setRole(loginRole.toString());
//        log.setCreateDate(new Date());
//        log.setContent(msg);
//        logMapper.insert(log);
//    }
//}
//
