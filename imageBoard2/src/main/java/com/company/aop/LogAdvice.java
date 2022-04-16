package com.company.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j

public class LogAdvice {
	
	// @Around : after + before
	// before : 메서드 호출전에 사용
	// after : 메서드 호출후에 사용
	@Around("execution(* com.company.service.*Impl.*(..)) "
			+ " or execution(* com.company.mapper.*Mapper.*(..))"
			)
	public Object logTime( ProceedingJoinPoint pjp)
	{
		log.info(".....................@ Around multi-setting : 호출이전 start");
		long start = System.currentTimeMillis();
		log.info("Target : " + pjp.getTarget());
		log.info("Param : " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		try {result = pjp.proceed();}
		catch(Throwable e) {e.printStackTrace();}
		
		long end = System.currentTimeMillis();
		log.info("TIME : " + (end-start));
		log.info(".....................@ Around multi-setting : 호출이후 start");
		return result;
	}
}
