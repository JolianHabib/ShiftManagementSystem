// Jolian Habib, ID: 211613526

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShiftManager implements ShiftManagerInterface{
	
	ShiftManagementSystem ShiftManagment = ShiftManagementSystem.getInstance(); 
	
	@Override
	public void initialization() throws ArithmeticException{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date=null;
		int rank=0;
		String idNumber; 
	    do {
	        System.out.print("Enter Administrator ID number: (9-digits) ");
	        idNumber = scanner.nextLine();
	     }while(idNumber.length()!=9);
	    System.out.print("Enter first name of the Administrator: ");
		String firstName = scanner.next();
		
		System.out.print("Enter last name of the Administrator: ");
		String lastName = scanner.next();
		scanner.nextLine();
		
		boolean isValidInput=false;
		while(!isValidInput) {
			try {
				System.out.print("Enter birth date of the Administrator: (dd/MM/yyyy): "); 
		        String DateString = scanner.nextLine();
		        date = LocalDate.parse(DateString,dtf);
		        isValidInput=true;
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());
			}
		}
		
		isValidInput=false;
	    while(!isValidInput) {
			try {
				System.out.println("Enter rank of the Administrator (positivs number)");
				rank = scanner.nextInt();
				if(rank>0)
					isValidInput=true;
			}catch(InputMismatchException e) {
				System.out.println("Input must be number");
            	scanner.next();
			}
		}
	    
	    String userName;
	    System.out.println("Enter a user name for a Administrator: ");
	    userName = scanner.next();
	    
	    String pass1;
	    System.out.println("Enter a password for a Administrator: ");
	    pass1 = scanner.next();
		   
		Employee Administrator = new Employee(idNumber,firstName,lastName,date,EmployeeRole.ADMINISTRATOR,rank,userName);
		ShiftManagment.getEmployees().add(Administrator);
		ShiftManagment.getPasswords().addUser(pass1, Administrator.getUserName());
		ShiftManagment.getUserNames().add(Administrator.getUserName());
		ShiftManagment.getObserverEmployee().addObserver(Administrator);
	}

	@Override
	public int ShiftSystemManager()throws ArithmeticException {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		MenuSystemRun SystemMenu ;
		System.out.println("Enter user name: ");
		String userName  = scanner.next();
		
		System.out.println("Enter password: ");
		String pass  = scanner.next();
		LogIn logIn = new LogIn();
		
		if(logIn.logIn(ShiftManagment.getPasswords(), pass, userName)==true)
			
		{
			Employee EmployeeInSystem =  ShiftManagment.getEmployeByUserName(userName);
			if(EmployeeInSystem.getEmpoloyeeRole().equals(EmployeeRole.ADMINISTRATOR)) {
				SystemMenu = new AdministratorMenu();
				SystemMenu.MenuSystem(ShiftManagment, EmployeeInSystem);
				return 1;
			}
			
			else if(EmployeeInSystem.getEmpoloyeeRole().equals(EmployeeRole.SHIFT_MANAGER)) {
				SystemMenu = new ShiftManagerMenu();
				SystemMenu.MenuSystem(ShiftManagment, EmployeeInSystem);
				return 1;
			}
			
			else if(EmployeeInSystem.getEmpoloyeeRole().equals(EmployeeRole.WORKER)) {
				SystemMenu = new WorkerMenu();
				SystemMenu.MenuSystem(ShiftManagment, EmployeeInSystem); 
				return 1;
			}
				
		}
		else {
			System.out.println("user name or password is incorrect!");
		}
		
		return 0;	
		
	}

}
