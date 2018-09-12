package com.yanghaoyi.aop;

import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : YangHaoYi on 2018/9/12.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/9/12.
 *         Version : V 1.0
 */
@Aspect
public class AnalyticClick {

    //根据Analytic注解找到方法切入点
    @Pointcut("execution(* android.view.View.OnClickListener.onClick(..))")
    public void methodAnnotated() {
    }

    //在连接点进行方法替换
    @Around("execution(* android.view.View.OnClickListener.onClick(..))")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        View view = null;
        for (Object arg : joinPoint.getArgs())
            if (arg instanceof View) view = (View) arg;
        if (view != null) {
            if(view.getId() == R.id.tvClick){
                System.out.println("AOP_Click___________________点击统计");
            }
            //执行原方法
            joinPoint.proceed();
        }
    }

}
