package org.dongchao.core.logs;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by zhaodongchao on 2017/5/5.
 */
@Component
@Aspect
public class LogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Pointcut("execution(* org.dongchao.controller.*.*(..))")
    public void log(){
        //此方法仅作为切点，里面的类容不会执行
    }
    @Before(value = "log()")
    public void before(JoinPoint joinPoint){
        //TODO 记录方法执行之前的log
    }
    @After(value = "log()")
    public void after(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info(request.getRemoteHost());
        logger.info(request.getRequestURI());
        logger.info(joinPoint.getTarget().getClass()+"."+joinPoint.getSignature().getName()+"("+ Arrays.asList(joinPoint.getArgs()).toString()+")");
    }
    @AfterReturning(pointcut = "log()",returning = "object")
    public void doAfterRetruning(Object object){
        logger.info("this method return "+object.toString());
    }
}
