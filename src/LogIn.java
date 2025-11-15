// Jolian Habib, ID: 211613526

public class LogIn {
		public boolean logIn(PasswordsSaved passSaved,String pass, String userName) {
			return passSaved.getPasswords().get(pass)==null? false: passSaved.getPasswords().get(pass).contains(userName);
		}

}
