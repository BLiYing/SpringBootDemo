package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title: LogServiceTakeTime.java
 * @Package com.itzixi.web.component
 * @Description: service的方法执行需要多少时间统计
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年4月10日 下午3:21:25
 * @version V1.0
 */
@Aspect
@Component
public class LogServiceTakeTime {
	
	final static Logger log = LoggerFactory.getLogger(LogServiceTakeTime.class);

	/**
	 * 1、execution(): 表达式主体。
	 *
	 * 2、第一个*号：表示返回类型， *号表示所有的类型。
	 *
	 * 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
	 *
	 * 4、第二个*号：表示类名，*号表示所有的类。
	 *
	 * 5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
	 */
	@Pointcut("execution(* com.example.demo.service..*.*(..))")
	public void performance(){
	}

	@Around("performance()")
	public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//记录起始时间 
		long begin = System.currentTimeMillis();
		Object result = "";
		/** 执行目标方法 */
		try{
			result= joinPoint.proceed();
		}
		catch(Exception e){
			log.error("日志记录发生错误, errorMessage: {}", e.getMessage());
		}
		finally{
			/** 记录操作时间 */
			long took = (System.currentTimeMillis() - begin);
			if (took >= 10*1000) {
				log.error("Service 执行时间为: {}ms", took);
			} else if (took >= 5*1000) {
				log.warn("Service 执行时间为: {}ms", took);
			} else  if (took >= 2*1000) {
				log.info("Service执行时间为: {}ms", took);
			} else {
				log.info("Service执行时间为: {}ms", took);
			}
		}
        return result;
	}
	
	@Before("performance()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
		log.info("doBefore");
    }
	
    @AfterReturning(returning = "ret", pointcut = "performance()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
    	log.info("doAfterReturning");
    }
	
}