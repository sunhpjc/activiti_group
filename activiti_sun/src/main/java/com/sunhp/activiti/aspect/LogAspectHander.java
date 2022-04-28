package com.sunhp.activiti.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sujian
 * @Description 日志切面
 **/
@Aspect
@Component
@Slf4j
public class LogAspectHander {
    /**
     * 定义一个切面，拦截包和包下面的所有方法,*后面空格一定要有
     */
    @Pointcut("execution(* com.sujian.blindbox.controller..*.*(..))")
    public void logPointCut(){

    }
    /**
     * 在上面定义的切面方法之前执行该方法
     * @param joinPoint
     */
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("===================start====================");
        log.info("URI          : {}", request.getRequestURI());
        log.info("HTTP Method  : {}", request.getMethod());
        log.info("Request Args : {}", JSONObject.toJSONString(joinPoint.getArgs()));
    }
    /**
     * 在上面定义的切面方法之后执行该方法
     */
    @After("logPointCut()")
    public void doAfter() {
        log.info("====================end=====================");
        log.info(" ");
    }

    /**
     * 环绕通知
     */
    @AfterReturning(value = "logPointCut()", returning = "result")
    public void doAfterReturning(Object result){
        log.info("Response Args : {}", JSONObject.toJSONString(result));
    }
}
