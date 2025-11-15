// Jolian Habib, ID: 211613526

import java.util.Scanner;

public class WorkerMenu implements MenuSystemRun{

	@Override
	public void MenuSystem(ShiftManagementSystem shiftSystem, Employee EmployeeInSystem) throws ArithmeticException { 
		CheckInOutManagment SystemCheckInOut = new CheckInOutManagmentActivity();
		printable print = new prints();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
		    System.out.println("\nShifts Management System Menu For Worker:");
            System.out.println("Enter 1 to log in to the shift");
            System.out.println("Enter 2 to log out to the shift");
            System.out.println("Enter 3 to print your shifts");
            System.out.println("Enter 0 to Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
            case 1:
            	SystemCheckInOut.EnterToShift(shiftSystem, EmployeeInSystem);
                break;
            case 2:
            	SystemCheckInOut.ExitfromShift(shiftSystem, EmployeeInSystem); 
                break;
            case 3: 
            	print.printYourShifts(shiftSystem, EmployeeInSystem);
            	break;
            case 0:
                System.out.println("Logging out\nReturning to start system.");
                return;
            default:
                System.out.println("Invalid choice.. try again.");
            }
		}
	}

}
