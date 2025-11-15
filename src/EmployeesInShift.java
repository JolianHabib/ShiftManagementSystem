// Jolian Habib, ID: 211613526

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmployeesInShift implements Observable, Comparable<EmployeesInShift> {
	private Shift shift;
	private Map <Employee,CheckInOutRecordController> Employees;
	private List<Observer> employeeObserver;
	
	public EmployeesInShift(Shift shift) {
		this.setShift(shift);
		Employees=new HashMap<Employee,CheckInOutRecordController>();
		this.employeeObserver = new ArrayList <Observer>();	
	}
	
	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public Map<Employee, CheckInOutRecordController> getEmployees() {
		return Employees;
	}
	

	public void setEmployees(Map<Employee, CheckInOutRecordController> employees) {
		Employees = employees;		
	}
	
	@Override
	public void addObserver(Observer observer) {
		employeeObserver.add(observer);	
	}

	@Override
	public void deleteObserver(Observer observer) {
		employeeObserver.remove(observer);		
	}

	@Override
	public void deleteObservers() {
		employeeObserver.clear();		
	}

	@Override
	public void notifyObserver(Observer observer, Object obj) {
		observer.update(this, obj);		
	}

	@Override
	public void notifyAllObserver(Object obj) {
		Iterator<Observer> it = employeeObserver.iterator();
		while(it.hasNext()) {
			it.next().update(this, obj);
		}
	}

	@Override
	public int countObservers() {		
		return employeeObserver.size();
	}

	public List<Observer> getEmployee() {
		return employeeObserver;
	}

	public void setEmployee(List<Observer> employee) {
		this.employeeObserver = employee;
	}

	@Override
	public String toString() {
		return "EmployeesInShift [shift=" + shift + ", Employees=" + Employees + "]";
	}

	@Override
	public int compareTo(EmployeesInShift o) {
		return this.shift.getDate().compareTo(o.shift.getDate());	
	}

}
