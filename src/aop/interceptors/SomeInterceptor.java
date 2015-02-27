package aop.interceptors;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SomeInterceptor {
	static {
		System.out.println("this is SomeInterceptor");
	}
	
	/**
     * A join point is in the web layer if the method is defined
     * in a type in the com.xyz.someapp.web package or any sub-package
     * under that.
     */
    @Pointcut("within(controller..*)")
    public void inWebLayer() {
    	System.out.println("this is inWebLayer within");
    }
    
    @Pointcut("execution(* controller..*(..))")
    public void inWebLayer2() {
    	System.out.println("this is inWebLayer within");
    }
    
    @Pointcut("execution(* someMethod(..))")// the pointcut expression
    private void anyOldTransfer() {
    	System.out.println("sop of some method");
    }// the pointcut signature
    
    
    public static final String EDP = "execution(* controller.HelloController.some*(..))";  
    
    @Before(EDP)    //spring中Before通知  
    public void logBefore() {  
        System.out.println("logBefore:现在时间是:"+new Date());  
    }  
      
    @After(EDP)    //spring中After通知  
    public void logAfter() {  
        System.out.println("logAfter:现在时间是:"+new Date());  
    } 
    
    @Around(EDP)   //spring中Around通知  
    public Object logAround(ProceedingJoinPoint joinPoint) {  
        System.out.println("logAround开始:现在时间是:"+new Date()); //方法执行前的代理处理  
        Object[] args = joinPoint.getArgs();  
        Object obj = null;  
        try {  
            obj = joinPoint.proceed(args);  
        } catch (Throwable e) {  
            e.printStackTrace();  
        }  
        System.out.println("logAround结束:现在时间是:"+new Date());  //方法执行后的代理处理  
        return obj;  
    } 
}
