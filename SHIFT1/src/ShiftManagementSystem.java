// Jolian Habib, ID: 211613526

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




public class ShiftManagementSystem {
		
	private static ShiftManagementSystem _instance = null;
	private int number;
	private Set<Employee> Employees;
	private List <Shift> Shifts;
	private PasswordsSaved Passwords;
	private HashSet<String> UserNames;
	private AdministratorShiftManagerObserver ObserverEmployee; //this for Administrator or ShiftManager to informed them when add or removed shift.
	private List <EmployeesInShift> employeesInShift;	
		
	private ShiftManagementSystem(){
		this.Employees = new HashSet<>(); 
		this.Shifts = new ArrayList<>();
		this.Passwords = new PasswordsSaved();
		this.UserNames=new HashSet<>();
		this.setObserverEmployee(new AdministratorShiftManagerObserver());
		this.setEmployeesInShift(new ArrayList<>());		
	}
	
	public static ShiftManagementSystem getInstance() {
		if(_instance == null) {
			_instance = new ShiftManagementSystem();	
		}
		return _instance;
	}
	
	public void addPass(String userName, String pass) {
		Passwords.addUser(pass, userName);
	}
		
	public Set<Employee> getEmployees() {
		return Employees;
	}
	
	public List<Shift> getShifts() {
		return Shifts;
	}
	
	public PasswordsSaved getPasswords() {
		return Passwords;
	}

	public void setPasswords(PasswordsSaved passwords) {
		Passwords = passwords;
	}

	public void setEmployees(HashSet<Employee> employees) {
		Employees = employees;
	}
	
	public void setShifts(List<Shift> shifts) {
		Shifts = shifts;
	}
	
	public HashSet<String> getUserNames() {
		return UserNames;
	}

	public void setUserNames(HashSet<String> userNames) {
		UserNames = userNames;
	}
	
	public AdministratorShiftManagerObserver getObserverEmployee() {
		return ObserverEmployee;
	}

	public void setObserverEmployee(AdministratorShiftManagerObserver observerEmployee) {
		ObserverEmployee = observerEmployee;
	}

	public Employee getEmployeByUserName(String userName) {
		for(Employee Employee : Employees) {
			if(Employee.getUserName().equals(userName) ) {				
				return Employee;
			}
		}
		return null;	 
	}

	public ShiftManagementSystemMemento saveMemento () { 
		return new ShiftManagementSystemMemento(this);
	}
	
	public void restoreMemnto(ShiftManagementSystemMemento mementoSystem) {
		this.Employees =  mementoSystem.getEmployees();
		this.Shifts = mementoSystem.getShifts();
		this.Passwords = mementoSystem.getPasswords();
		this.UserNames= mementoSystem.getUserNames();
		this.ObserverEmployee= mementoSystem.getObserverEmployee();
		this.employeesInShift = mementoSystem.getEmployeesInShift();			
	}
	
	public int getNumber() {
		return number++;
	}

	public List <EmployeesInShift> getEmployeesInShift() {
		return employeesInShift;
	}

	public void setEmployeesInShift(List <EmployeesInShift> employeesInShift) {
		this.employeesInShift = employeesInShift;
	}
	
}
