package rsol.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rsol.aspectj.demo.User;

public class SpringAopDemo {

	public SpringAopDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		User user = (User) ctx.getBean("user");
		user.addUser("majeed");
		user.addUser("majeed1");
		user.getUser();

		user.deleteUser("majeed1");
		user.listUsers();

	}

}
