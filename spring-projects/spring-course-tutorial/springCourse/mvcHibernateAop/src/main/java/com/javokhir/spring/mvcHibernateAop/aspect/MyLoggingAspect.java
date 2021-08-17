package com.javokhir.spring.mvcHibernateAop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.javokhir.spring.mvcHibernateAop.dao.*.*(..))") // to apply for all methods in folder dao
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Begin of " + methodName);

        Object targetResultMethod = proceedingJoinPoint.proceed();

        System.out.println("End of " + methodName);
        return targetResultMethod;
    }
}
