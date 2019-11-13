package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	
	@Around("execution(* cn.tedu.store.service.impl.*.*(..))")
	public Object afterThrowing(ProceedingJoinPoint pjp) throws Throwable{
		//记录开始时间
		long start = System.currentTimeMillis();
		Object result = null;
		//切入点返回值
		result = pjp.proceed();
		//记录结束时间
		long end = System.currentTimeMillis();
		Long time = end-start;
		System.err.println(time);
		return result;
	}
}
