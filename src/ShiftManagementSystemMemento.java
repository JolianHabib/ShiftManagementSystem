// Jolian Habib, ID: 211613526

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ShiftManagementSystemMemento {
	private Set<Employee> Employees;
	private List <Shift> Shifts;
	private PasswordsSaved Passwords;
	private HashSet<String> UserNames;
	private AdministratorShiftManagerObserver ObserverEmployee; //this for Administrator or ShiftManager to informed them when add or removed shift.
	private List <EmployeesInShift> employeesInShift;	
	private LocalDate created;
	
	public ShiftManagementSystemMemento(Set<Employee> employees, List<Shift> shifts, PasswordsSaved passwords,
			HashSet<String> userNames, AdministratorShiftManagerObserver observerEmployee,List <EmployeesInShift> employeesInShift) {
		this.Employees = employees;
		this.Shifts = shifts;
		this.Passwords = passwords;
		this.UserNames = userNames;
		this.ObserverEmployee = observerEmployee;
		this.employeesInShift = employeesInShift;
		this.created= LocalDate.now();
	}
	
	public ShiftManagementSystemMemento(ShiftManagementSystem shiftManagementSystem) {
		this.Employees = shiftManagementSystem.getEmployees();
		this.Shifts = shiftManagementSystem.getShifts();
		this.Passwords = shiftManagementSystem.getPasswords();
		this.UserNames = shiftManagementSystem.getUserNames();
		this.ObserverEmployee = shiftManagementSystem.getObserverEmployee();
		this.employeesInShift = shiftManagementSystem.getEmployeesInShift();
		this.created= LocalDate.now();
	}
	
	public Set<Employee> getEmployees() {
		return Employees;
	}
	
	public PasswordsSaved getPasswords() {
		return Passwords;
	}
	
	public List <Shift> getShifts() {
		return Shifts;
	}
	
	public HashSet<String> getUserNames() {
		return UserNames;
	}
	
	public AdministratorShiftManagerObserver getObserverEmployee() {
		return ObserverEmployee;
	}
	
	@Override
	public String toString() {
		return "ShiftManagementSystemMemento [Employees=" + Employees + ", Shifts=" + Shifts + ", Passwords="
				+ Passwords + ", UserNames=" + UserNames + ", ObserverEmployee=" + ObserverEmployee + ", created="
				+ created + "]";
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public List <EmployeesInShift> getEmployeesInShift() {
		return employeesInShift;
	}
		
}


