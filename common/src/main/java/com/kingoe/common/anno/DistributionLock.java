package com.kingoe.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <note>
 * 这里按照锁的粗细粒度分为两种模式：
 * 1. 粗粒度：由注解中的value字段指定，编译阶段就确定了，同一个方法（业务）共享该锁。不管是谁调这个方法，都是按串行执行。
 * 2. 细粒度：方法的参数列表中的一个参数作为锁的key值，比如一个编号、一个流水号等等业务唯一参数。
 *      主要应用在如果同一个（同一组）交易允许不同人同时做，但同一个人必须串行执行的场景；由index指定作为key的形参位置。
 * </note>
 * 开发自定义注解
 * @author jinwu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DistributionLock {
    /**
     * 分布式锁key
     */
    String value() default "";
    /**
     * 获取分布式锁的等待时间
     */
    int waitTime() default 5 * 1000;
    /**
     * 分布式锁key所在参数列表中的位置
     */
    int index() default -1;
}
