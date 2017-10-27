package rsol.aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public abstract class UserInterceptor {

	public UserInterceptor() {
		super();
	}

	private synchronized void initalize(Object obj) {
		System.out.println("UserInterceptor initialize "
				+ obj.getClass().getName());
	}

	@Pointcut()
	public abstract void interceptMethods();

	/*
	 * @Pointcut("execution(* rsol.aspectj.demo.UserImpl.listUsers(..))") public void
	 * interceptMethods(){}
	 */

/*
	 * @Before("execution (* rsol.aspectj.demo.UserImpl.listUsers(..))") public void
	 * beforePrintlnCall(JoinPoint joinPoint) {
	 * System.out.println("About to make call to print Hello World"); }
	 */


	@Around("interceptMethods() && " + "!within(rsol.aspectj.aspect..*)")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {

		Object returnVal = null;

		try {
			Object targetObj = pjp.getTarget();
			initalize(targetObj);

		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("user intercepted ..");
		}

		try {
			returnVal = pjp.proceed();
			System.out.println("after proceed ..");

		} catch (Throwable e) {
			throw e;
		} finally {

		}

		return returnVal;
	}

}
