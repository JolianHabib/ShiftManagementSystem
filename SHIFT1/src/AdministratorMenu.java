// Jolian Habib, ID: 211613526

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdministratorMenu implements MenuSystemRun {
	
	@Override
	public void MenuSystem(ShiftManagementSystem shiftSystem,Employee EmployeeInSystem) throws ArithmeticException {
		EmployeeManagment SystemEmployee = new EmployeeManagmentActivity(); 
		CheckInOutManagment SystemCheckInOut = new CheckInOutManagmentActivity();
		ShiftManagment SystemShift = new ShiftManagmentActivity();
		printable print = new prints();
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			
		    System.out.println("\nShifts Management System Menu For Administrator:");
            System.out.println("Enter 1 to log in to the shift");
            System.out.println("Enter 2 to log out to the shift");
            System.out.println("Enter 3 to print your shifts");
            System.out.println("Enter 4 to Shift Employee assignment");
            System.out.println("Enter 5 to Search shifts");
            System.out.println("Enter 6 to Add a shift");
            System.out.println("Enter 7 to shift update");
            System.out.println("Enter 8 to Deleting a shift");
            System.out.println("Enter 9 to print shifts for employee");
            System.out.println("Enter 10 to print shifts for employees");
            System.out.println("Enter 11 to Search for employees");
            System.out.println("Enter 12 to Add an employee");
            System.out.println("Enter 13 to Update employee");
            System.out.println("Enter 14 to Deleting an employee");
            System.out.println("Enter 15 to Printing all employees");
            System.out.println("Enter 0 to Logout"); 
            
            try {
                	int choice=0;
                	System.out.print("Enter your choice: ");
                	
                	choice = scanner.nextInt();
                
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
                    	SystemShift.addShift(shiftSystem);
                        break;
                    case 7:
                    	SystemShift.updateShift(shiftSystem);
                    	break;       	
                    case 8: 
                    	SystemShift.removeShift(shiftSystem);          
                    	break;  
                    case 9:
                    	print.printEmployeeShifts(shiftSystem);
                    	break;
                    case 10:
                    	print.printEmployeesShifts(shiftSystem);
                    	break;
                    case 11:
                    	SystemEmployee.searchEmployee(shiftSystem);
                    	break;
                    case 12:
                    	SystemEmployee.addEmployee(shiftSystem);
                    	break;
                    case 13:
                    	SystemEmployee.updateEmployee(shiftSystem);
                        break;
                    case 14:
                    	SystemEmployee.removeEmployee(shiftSystem);
                    	break;
                    case 15:
                    	SystemEmployee.printEmployees(shiftSystem);
                    	break;   
                    case 0:
                        System.out.println("Logging out\nReturning to start system.");
                        return;
                    default:
                        System.out.println("Invalid choice.. try again.");
                    }
      
              } catch(InputMismatchException e) {
                	System.out.println("Input must be number");
                	scanner.next();
               }
            }
	
	}
}
