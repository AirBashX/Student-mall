package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 拦截器类:
 * 用于规定拦截的规则
 * @author ZSP
 *@see LoginInterceptionConfigurer
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取session对象
		HttpSession session = request.getSession();
		Object uid = session.getAttribute("uid");
		//判断是否正确的获取到了uid
		if(uid==null){//获取uid失败,以为着用户没有登录,重定向登录
			response.sendRedirect("/web/login.html");
			return false;
		}
		return true;
	}
}