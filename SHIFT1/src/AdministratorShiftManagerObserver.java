// Jolian Habib, ID: 211613526

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdministratorShiftManagerObserver implements Observable  {
	private List<Observer> employee;
	
	AdministratorShiftManagerObserver(){
		this.setEmployee(new ArrayList<Observer>());
	}
	
	public List<Observer> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Observer> employee) {
		this.employee = employee;
	}

	@Override
	public void addObserver(Observer observer) {
		employee.add(observer);	
	}

	@Override
	public void deleteObserver(Observer observer) {
		employee.remove(observer);		
	}

	@Override
	public void deleteObservers() {
		employee.clear();		
	}

	@Override
	public void notifyObserver(Observer observer, Object obj) {
		observer.update(this, obj);	
	}

	@Override
	public void notifyAllObserver(Object obj) {
		Iterator<Observer> it = employee.iterator();
		while(it.hasNext()) {
			it.next().update(this, obj);
		}
	}

	@Override
	public int countObservers() {		
		return employee.size();
	}

}
