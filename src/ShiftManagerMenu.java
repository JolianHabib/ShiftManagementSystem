// Jolian Habib, ID: 211613526

import java.util.Scanner;

public class ShiftManagerMenu implements MenuSystemRun {
	
	@Override
	public void MenuSystem(ShiftManagementSystem shiftSystem, Employee EmployeeInSystem) throws ArithmeticException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		EmployeeManagment SystemEmployee = new EmployeeManagmentActivity(); 
		CheckInOutManagment SystemCheckInOut = new CheckInOutManagmentActivity();
		ShiftManagment SystemShift = new ShiftManagmentActivity();
		printable print = new prints();
		
		while (true) {
		    System.out.println("\nShifts Management System Menu For Shift Manager:");
            System.out.println("Enter 1 to log in to the shift");
            System.out.println("Enter 2 to log out to the shift");
            System.out.println("Enter 3 to print your shifts");
            System.out.println("Enter 4 to Shift Employee assignment");
            System.out.println("Enter 5 to Search shifts");
            System.out.println("Enter 6 to shift update");
            System.out.println("Enter 7 to print shifts for employee");
            System.out.println("Enter 8 to print shifts for employees");
            System.out.println("Enter 9 to Search for employees");
            System.out.println("Enter 10 to Update employee");
            System.out.println("Enter 11 to Printing all employees");
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
            case 4:
            	SystemShift.ShiftEmployeeAssignme(shiftSystem); 
                break;
            case 5:
                SystemShift.searchShift(shiftSystem);
                break;
            case 6:
            	SystemShift.updateShift(shiftSystem);
            	break;  
            case 7:
            	print.printEmployeeShifts(shiftSystem);
            	break;
            case 8:
            	print.printEmployeesShifts(shiftSystem);
            	break;
            case 9:
            	SystemEmployee.searchEmployee(shiftSystem);
            	break;
            case 10:
            	SystemEmployee.updateEmployee(shiftSystem);
                break;
            case 11:
            	SystemEmployee.printEmployees(shiftSystem);
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
