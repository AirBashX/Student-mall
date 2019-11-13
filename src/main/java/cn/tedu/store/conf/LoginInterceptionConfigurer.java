package cn.tedu.store.conf;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.tedu.store.interceptor.LoginInterceptor;

/**
 * 拦截器配置类:用于规定拦截器的黑白名单
 * @author ZSP
 *@see LoginInterceptor 
 */
@Configuration
public class LoginInterceptionConfigurer implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//创建拦截器对象
		HandlerInterceptor interceptor=new LoginInterceptor();
		//通过注册工具添加拦截器对象
		//白名单
		ArrayList<String> patterns = new ArrayList<>();
		patterns.add("/js/**");
		patterns.add("/css/**");
		patterns.add("/images/**");
		patterns.add("/bootstrap3/**");
		patterns.add("/web/register.html");
		patterns.add("/web/index.html");
		patterns.add("/web/login.html");
		patterns.add("/users/reg");
		patterns.add("/users/login");
		patterns.add("/districts");
		patterns.add("/districts/**");
		patterns.add("/web/product.html");
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
/*		InterceptorRegistration x = registry.addInterceptor(interceptor);
		x.addPathPatterns(patterns);
		x.excludePathPatterns(patterns);*/
	}
}
