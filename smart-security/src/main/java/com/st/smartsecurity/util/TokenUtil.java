package com.st.smartsecurity.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
* @author xuri
* @date 2019/12/18
*/
@Component
public class TokenUtil {
	/**
	 * 下发Token
	 * @return
	 */
	public String getToken(String id,String pwd) {
		Date start = new Date();
		long currentTime = System.currentTimeMillis() + 60 * 60 * 1000 * 3;//3小时有效时间
		Date end = new Date(currentTime);
		String token = "";
//		System.out.println(qdUserDTO.getId());
		token = JWT.create().withAudience(id).withIssuedAt(start).withExpiresAt(end)
				.sign(Algorithm.HMAC256(pwd));
//		System.out.println(JWT.decode(token).getAudience().get(0));
		return token;
	}


//	public static String getTokenUserId() {
//		String token = getRequest().getHeader("Authorization");// 从 http 请求头中取出 token
//		System.out.println(token);
//		String userId = JWT.decode(token).getAudience().get(0);
//		return userId;
//	}

	/**
	 * 获取request
	 *
	 * @return
	 */
//	public static HttpServletRequest getRequest() {
//		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//				.getRequestAttributes();
//		return requestAttributes == null ? null : requestAttributes.getRequest();
//	}
}
