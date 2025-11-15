// Jolian Habib, ID: 211613526

public class SystemStart {
	
	public void Systemstart()throws ArithmeticException {
		ShiftManagementSystem System1= ShiftManagementSystem.getInstance();
		ShiftManagerInterface ShiftManager = new ShiftManager();
		ShiftManager.initialization();
		ShiftManagementSystemMemento memento = System1.saveMemento();

		while (true) {
			System1.restoreMemnto(memento);
		    System.out.println("Wellcome To Shifts Management System:");
		    ShiftManager.ShiftSystemManager();
            memento = System1.saveMemento();
		}           
		
	}
	
}
