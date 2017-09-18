package com.xiaoyb.anonation;

import java.lang.annotation.*;

/**
 * @author XIAO
 * @since 2017-09-18 14:57
 **/
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 要执行的操作类型比如：add操作
     **/
    public String operationType() default "";

    /**
     * 要执行的具体操作比如：添加用户
     **/
    public String operationName() default "";
}
