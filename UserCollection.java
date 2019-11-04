import java.util.ArrayList;
import java.util.List;

public class UserCollection {
	/*
	 * A userCollection holds created users, and is used to verify a 
	 * users login information.
	 * 
	 */
	private List<User> users = new ArrayList<User>();
	
	public UserCollection() {
		
	}
	/*
	 * Returns true if the lists of users contains a user
	 * with the given username
	 */
	public boolean userExists(String username) {
		for (User u: users) {
			if (u.getName().equals(username))
				return true;
		}
		return false;
	}
	
	/*
	 * Returns a user object if the user exists in the list of users
	 * and their password is correct.
	 */
	public User login(String username, String password) {
		for (User u: users) {
			if (u.getName().equals(username))
				if( u.attemptLogin(password)) {
					return u;
				}
		}
		return null;
	}
	
	/*
	 * Adds a user to the list of users.
	 */
	public void addUser(User add) {
		users.add(add);
	}
	
	
	/*
	 * Returns a string representation of a userCollection
	 */
	public String toString() {
		String output = "{ ";
		for (User u: users) {
			output += u.toString() +", ";
		}
		output = output.substring(0, output.length()-2);
		output += "} ";
		return output;
	}
}