package rsol.aspectj.demo;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements User {
	private List<String> users;

	public UserImpl() {
		// TODO Auto-generated constructor stub
		users = new ArrayList<String>();
	}

	@Override
	public void addUser(String name) {
		// System.out.println("adding user " + name);
		users.add(name);

	}

	@Override
	public void deleteUser(String name) {
		// System.out.println("deleting user " + name);
		users.remove(name);
	}

	@Override
	public String getUser() {
		// System.out.println("retrieving user " + users.get(0));
		return users.get(0);
	}

	@Override
	public void listUsers() {
		System.out.println(users.toString());
	}


}
