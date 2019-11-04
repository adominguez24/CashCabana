import java.util.Scanner;

public class Main {
		
	private static final int EXIT_SELECTION = 7;
	
	public static void main(String[] args) {
		User currentUser = null;
		UserCollection allUsers = new UserCollection();
		Scanner input = new Scanner(System.in);
		userInterface(currentUser, allUsers, input);
					
		input.close();
	}
	
	public static void prompt() {
		System.out.println("Welcome to Cash Cabana, please select an option");
		System.out.println();
		System.out.println("1: Deposit");
		System.out.println("2: Withdraw");
		System.out.println("3: Get Balance");
		System.out.println("4: Create New User");
		System.out.println("5: Log In");
		System.out.println("6: Log Out");
		System.out.println("7: Exit");
	}
	
	public static void userInterface(User currentUser, UserCollection allUsers, Scanner input) {
		int selected = 0;
		prompt();
		
		while (selected != EXIT_SELECTION) {
			System.out.println("Next Option?");
			
			String inputString = input.nextLine();
			try {
				selected = Integer.parseInt(inputString);
			} catch(Exception e) {
				System.out.println("Invalid input");
				continue;
			}

			switch (selected) {
				case 1:
					if (loggedIn(currentUser)) {
						System.out.println("Amount?");
						String in = input.nextLine();
						currentUser.deposit(Integer.parseInt(in));
						System.out.println("New Balance: " + currentUser.getBalance());
					}
					break;
				case 2:
					if (loggedIn(currentUser)) {
						System.out.println("Amount?");
						String in = input.nextLine();
						currentUser.withdraw(Integer.parseInt(in));
						System.out.println("New Balance: " + currentUser.getBalance());
					}
					break;
					
				case 3:
					if (loggedIn(currentUser)) {
						System.out.println("Balance: "+currentUser.getBalance());
					}
					break;
				case 4:
					addNewUser(allUsers, input);
					break;
				case 5:
					currentUser = login(allUsers, input);
					break;
				case 6:
					currentUser = null;
					System.out.println("Logout Successful");;
					break;
				default:
					System.out.println("Invalid Input");
			}
		}	
		System.out.println("Bye!");	
	}

	public static void addNewUser(UserCollection all, Scanner in) {
		System.out.println("New Username? ");
		String name = in.nextLine();
		System.out.println("Password? ");
		String pass = in.nextLine();
		
		User toAdd = new User(name, pass);
		all.addUser(toAdd);
		System.out.println("User " + name + " Added!");
	}
	
	public static User login(UserCollection all, Scanner in) {
		System.out.println("Username? ");
		String name = in.nextLine();
		System.out.println("Password? ");
		String pass = in.nextLine();
		
		User attempt = all.login(name, pass);
		if (attempt == null) {
			System.out.println("Login failed!");
		} else {
			System.out.println("Logged in as " + name);
		}
		return attempt;
	}
	
	public static boolean loggedIn(User in) {
		if (in == null) {
			System.out.println("You must log in to do this!");
			return false;
		} else {
			return true;
		}
	}
}
