package com.zaytsevp.cache2kexample.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация, для методов, время
 * выполнения которых мы хотим отследить
 *
 * @author Pavel Zaytsev
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TraceExecutionTime {

}
