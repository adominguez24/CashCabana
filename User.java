public class User {
	private String name = "";
	private String password = "";
	private int balance;
	
	/*
	 * A user object holds a name and password, and makes up the user collection.
	 * A user also has a balance,
	 * 
	 * @param String name: the name of the user
	 * @param String password: the password used to login
	 */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		this.balance = 0;
		
	}
	

	public String getName() {
		return this.name;
	}

	/*
	 * attemptLogin returns True if the passed in String password
	 * has the same value as this users password, false otherwise.
	 * @param String password: password to check 
	 */
	public boolean attemptLogin(String password) {
		return password.equals(this.password);
		
	}

	/*
	 * This deposits a given amount into our account
	 */
	public void deposit(int amount) {
		balance += amount;
	}
	
	/*
	 * This withdraws a certain amount from our account
	 */
	public void withdraw(int amount) {
		if(balance - amount >= 0) {
			balance -= amount;
		} else {
			System.out.println("Max withdraw amount available:" + balance);
		}
	}	

	/*
	 * returns a string representation of a user object.
	 */
	public String toString() {
		return name + ": " + balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
}
