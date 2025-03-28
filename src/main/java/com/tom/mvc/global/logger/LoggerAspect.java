package com.tom.mvc.global.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Pointcut("execution(* com.tom.mvc..*Api.*(..))")
    public void api() {
    }

    @Pointcut("execution(* com.tom.mvc..*Controller.*(..))")
    public void controller() {
    }

    @Pointcut("execution(* com.tom.mvc..*Service*.*(..))")
    public void service() {
    }

    @Pointcut("execution(* com.tom.mvc..*Repository*.*(..))")
    public void repository() {
    }


    @Pointcut("execution(* com.tom.mvc..*ControllerAdvice.*(..))")
    public void exception() {
    }

    @Pointcut("execution(* com.tom.mvc..*Controller.healthCheck(..))")
    public void healthCheck() {
    }

    // 어느 위치에서 에러가 발생했는지 확인하는 용도
    @Before("(api() || controller() || service() || repository()) && !healthCheck()")
    @Order(1)
    public void mvcLog(JoinPoint joinPoint) {
        String type = joinPoint.getSignature().getDeclaringTypeName();
        String name = "";

        if (type.contains("Api")) {
            name = "Api\t:  ";
        } else if (type.contains("Controller")) {
            name = "Controller\t:  ";
        } else if (type.contains("Service")) {
            name = "Service\t:  ";
        } else if (type.contains("Repository")) {
            name = "Repository\t:  ";
        } else if (type.contains("Listener")) {
            name = "Listener\t:  ";
//        } else if (type.contains("Filter")) {
//            name = "Filter\t:  ";
        }
        if (log.isDebugEnabled()) {
            log.debug(name + type + "." + joinPoint.getSignature().getName() + "()");

        }
    }

}
