package rsol.aspectj.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* rsol.aspectj.demo.User.addUser(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logBefore() " + joinPoint.getSignature().getName()
				+ " with args: " + Arrays.toString(joinPoint.getArgs()));
	}

	@Before("execution(* rsol.aspectj.demo.User.addUser(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("logAfter() " + joinPoint.getSignature().getName()
				+ " with args: " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* rsol.aspectj.demo.User.getUser(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("logAfterReturning() "
				+ joinPoint.getSignature().getName() + " with args: "
				+ Arrays.toString(joinPoint.getArgs()));
		System.out.println("\t returned value:" + result);
	}

	@Around("execution(* rsol.aspectj.demo.User.addUser(..))")
	   public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() " + joinPoint.getSignature().getName()
				+ " with arg " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("Around before is running!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("Around after is running!");


	   }

	public void logBeforeDeleteUser(JoinPoint joinPoint) {
		System.out.println("logBeforeDeleteUser() "
				+ joinPoint.getSignature().getName() + " with args: "
				+ Arrays.toString(joinPoint.getArgs()));
	}

	public void logAfterDeleteUser(JoinPoint joinPoint) {
		System.out.println("logAfterDeleteUser() "
				+ joinPoint.getSignature().getName() + " with args: "
				+ Arrays.toString(joinPoint.getArgs()));
	}
}
