package rsol.aspectj;

import rsol.aspectj.demo.User;
import rsol.aspectj.demo.UserImpl;

public class AspectJrtDemo {

	public AspectJrtDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		User user = new UserImpl();
		user.addUser("majeed");
		user.addUser("majeed1");
		user.getUser();

		user.deleteUser("majeed1");
		user.listUsers();

	}

}
