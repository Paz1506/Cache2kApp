package com.zaytsevp.cache2kexample.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Аспект для вычисления времени выполнения метода,
 * помеченного аннотацией @TraceExecutionTime
 *
 * @author Pavel Zaytsev
 */
@Aspect
@Slf4j
@Component
//TODO: убрать все лишнее
public class TraceExecutionTimeAspect {

//    private long startTime;
//    @Pointcut("execution(* com.zaytsevp.cache2kexample.*.*(..))")
//    @Pointcut("@annotation(TraceExecutionTime)")
//    public void selectAllMethods() { }
//
//    @Before("selectAllMethods()")
//    public void startExecutionTime() {
//        startTime = System.currentTimeMillis();
//    }
//
//    @After("selectAllMethods()")
//    public void endExecutionTime() {
//        log.info("Logging execution time: {} ms.", (System.currentTimeMillis() - startTime));
//    }

    @Around("@annotation(TraceExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info("Method {} executed in {} ms", joinPoint.getSignature(), executionTime);

        return proceed;
    }
}
