package com.yanghaoyi.aop;

import android.view.View;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : YangHaoYi on 2018/9/12.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/9/12.
 *         Version : V 1.0
 */
@Aspect
public class AnalyticPage {

    private static final String MAIN_PAGE = "MainActivity";


    @Before("execution(* onResume(..))")
    public void aroundOnResume(JoinPoint joinPoint) throws Throwable {
        switch (joinPoint.getTarget().getClass().getSimpleName()){
            case MAIN_PAGE:
                System.out.println("AOP_Click___________________:统计 MainPage onResume");
                break;
            default:
                break;
        }

    }

    @Before("execution(* onPause(..))")
    public void aroundOnPause(JoinPoint joinPoint) throws Throwable {
        switch (joinPoint.getTarget().getClass().getSimpleName()){
            case MAIN_PAGE:
                System.out.println("AOP_Click___________________:统计 MainPage onPause");
                break;
            default:
                break;
        }

    }

}
