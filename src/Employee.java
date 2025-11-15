// Jolian Habib, ID: 211613526

import java.time.LocalDate;

public class Employee implements Observer {
	private String IdNumber;
	private String firsName;
	private String lastName;
	private LocalDate birthDay;
	private EmployeeRole empoloyeeRole;
	private int rank;
	private String userName;
	

	public Employee(String idNumber, String firsName, String lastName, LocalDate birthDay, EmployeeRole empoloyeeRole,
			int rank, String userName ) {
		IdNumber = idNumber;
		this.firsName = firsName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.empoloyeeRole = empoloyeeRole;
		this.rank = rank;
		this.userName = userName;
	}
	
	public String getIdNumber() {
		return IdNumber;
	}
	
	public String getFirsName() {
		return firsName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public LocalDate getBirthDay() {
		return birthDay;
	}
	
	public EmployeeRole getEmpoloyeeRole() {
		return empoloyeeRole;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}
	
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	
	public void setEmpoloyeeRole(EmployeeRole empoloyeeRole) {
		this.empoloyeeRole = empoloyeeRole;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Employee [IdNumber=" + IdNumber + ", firsName=" + firsName + ", lastName=" + lastName + ", birthDay="
				+ birthDay + ", empoloyeeRole=" + empoloyeeRole + ", rank=" + rank + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void update(Observable obs, Object obj) {
		if(obs instanceof EmployeesInShift) {		
			System.out.println("Hello "+ this.getFirsName());
			System.out.println(obj);
		}
		
		if(obs instanceof AdministratorShiftManagerObserver) {
			System.out.println("Hello "+ this.getFirsName());
			System.out.println(obj);
		}
		
	}		

}
