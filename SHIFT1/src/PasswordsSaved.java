// Jolian Habib, ID: 211613526

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PasswordsSaved {
		private HashMap<String,ArrayList<String>> passwords;
		
		public PasswordsSaved(){
			this.passwords = new HashMap<>();
		}
		
		public HashMap<String, ArrayList<String>> getPasswords() {
			return passwords;
		}

		public void setPasswords(HashMap<String, ArrayList<String>> passwords) {
			this.passwords = passwords;
		}
		
		public boolean addUser(String pass, String userName ) {
			ArrayList<String> users = passwords.get(pass);
			if(users == null) {
				passwords.put(pass, new ArrayList<>(Arrays.asList(new String[] {userName})));
				return true;
			}else {
				return users.contains(userName)? false: users.add(userName);
			}
		}

}
