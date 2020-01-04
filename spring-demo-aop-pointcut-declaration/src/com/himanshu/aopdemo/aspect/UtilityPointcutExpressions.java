package com.himanshu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public interface UtilityPointcutExpressions {

//	declare pointcut expression
	@Pointcut("execution(*  com.himanshu.aopdemo.dao.*.*(..))")
	default void applyingCommonForDAO() {}
	
//	@Pointcut for getters
	@Pointcut("execution(*  com.himanshu.aopdemo.dao.*.get*(..))")
	default void getters() {}
	
//	@Pointcut for setters
	@Pointcut("execution(*  com.himanshu.aopdemo.dao.*.set*(..))")
	default void setters() {}
	
//	@Pointcut for DAO'S
	@Pointcut("applyingCommonForDAO() && !(getters() || setters())")
	default void forDAOwithnogettersandsetter() {}
	
}
