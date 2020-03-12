package com.st.smartsecurity.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.qs.common.core.exception.BusinessException;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.annotation.UserLoginToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 拦截器
 *
 * @author xuri
 * @date 2019/12/17
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
	@Resource
	private HttpServletRequest request;


	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
		//跨域问题
		httpServletResponse.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, GET");
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");


		String token = httpServletRequest.getHeader("Authorization");// 从 http 请求头中取出 token
		// 如果不是映射到方法直接通过httpServletResponse
		if (!(object instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) object;
		Method method = handlerMethod.getMethod();
		//检查是否有passtoken注释，有则跳过认证
		if (method.isAnnotationPresent(PassToken.class)) {
			PassToken passToken = method.getAnnotation(PassToken.class);
			if (passToken.required()) {
				return true;
			}
		}

			//执行认证
			if (StringUtils.isEmpty(token)) {
				throw new BusinessException(201, "token为空，请输入token");
			}
			// 比较token
			if (StringUtils.isNotEmpty(token)){
//				System.out.println(JWT.decode(token).getExpiresAt());
//				System.out.println(new Date());
//				System.out.println(request.getSession().getAttribute("token"+JWT.decode(token).getAudience().get(0)).toString());
//				System.out.println(token);
				if (JWT.decode(token).getExpiresAt().before(new Date())||request.getSession().getAttribute("token"+JWT.decode(token).getAudience().get(0))==null){
					throw new BusinessException(202, "token过期，请重新登录");
				}
				if (request.getSession().getAttribute("token"+JWT.decode(token).getAudience().get(0)).toString().equals(token)){
					return true;
				}else{
					throw new BusinessException(203, "token错误，请重新登录");
				}
			}
		return true;
	}


	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
