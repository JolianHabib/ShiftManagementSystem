// Jolian Habib, ID: 211613526

public interface Observable {
	public void addObserver(Observer observer);
	public void deleteObserver(Observer observer);
	public void deleteObservers();
	public void notifyObserver(Observer observer, Object obj);
	public void notifyAllObserver(Object obj);
	public int countObservers();

}

