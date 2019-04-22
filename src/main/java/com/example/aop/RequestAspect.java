package com.example.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestAspect {

    private Logger logger = Logger.getLogger(RequestAspect.class);

    /**
     * 对com.example.controller包下的任意类的任意方法任意参数的public方法
     */
    @Pointcut("execution(public * com.example.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("方法执行前...");
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        logger.info("url:" + request.getRequestURI());
        logger.info("ip:" + request.getRemoteHost());
        logger.info("method:" + request.getMethod());
        logger.info("class_method:" + joinPoint.getSignature().getDeclaringTypeName()+"."
                + joinPoint.getSignature().getName());
        logger.info("args:" + joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint) {
        logger.info("方法执行后...");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result) {
        logger.info("方法返回值:" + result);
    }
}

