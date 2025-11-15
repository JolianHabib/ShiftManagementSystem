// Jolian Habib, ID: 211613526

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class prints implements printable, printInterface {
	
	shiftActivityInterface shiftManagment = new ShiftManagmentActivity();
	
	
	@Override
	public void printShiftByDay(ShiftManagementSystem ShiftSystem) throws ArithmeticException{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean isValidInput=false;
		LocalDate date=null;
		while(!isValidInput) {
			try {
				System.out.print("Enter a date to print shifts on it: (dd/MM/yyyy): "); 
		        String DateString = scanner.nextLine();
		        date = LocalDate.parse(DateString,dtf);
		        isValidInput=true;
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());	
			}
		}
		
        shiftManagment.ShiftEmployeeSort(ShiftSystem);
        for(EmployeesInShift employeesInShift : ShiftSystem.getEmployeesInShift()) {
        	if(employeesInShift.getShift().getDate().isEqual(date))
        			System.out.println(employeesInShift);
        }
	}
	
	@Override
	public void printShiftByDayForEmployee(ShiftManagementSystem ShiftSystem, Employee employee) throws ArithmeticException{
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean isValidInput=false;
		LocalDate date=null;
		
		while(!isValidInput) {
			try {
				System.out.print("Enter a date to print shifts on it: (dd/MM/yyyy): "); 
		        String DateString = scanner.nextLine();
		        date = LocalDate.parse(DateString,dtf);
		        isValidInput=true;
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());	
			}
		}
		
        shiftManagment.ShiftEmployeeSort(ShiftSystem);
        for(EmployeesInShift employeesInShift : ShiftSystem.getEmployeesInShift()) {
        	if(employeesInShift.getShift().getDate().isEqual(date)&&employeesInShift.getEmployees().containsKey(employee))
        			System.out.println(employeesInShift);
        }
	}
	
	@Override
	public void printShiftByWeek(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean isValidInput=false;
		LocalDate date=null;
		
		while(!isValidInput) {
			try {
				System.out.print("Enter the start date of the week for print shifts: (dd/MM/yyyy): "); 
		        String DateString = scanner.nextLine();
		        date = LocalDate.parse(DateString,dtf);
		        isValidInput=true;
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());	
			}
		}
		
		shiftManagment.ShiftEmployeeSort(ShiftSystem);
        for(EmployeesInShift employeesInShift : ShiftSystem.getEmployeesInShift()) {
        	if(employeesInShift.getShift().getDate().isAfter(date.minusDays(1))&&employeesInShift.getShift().getDate().isBefore(date.plusWeeks(1)))
        			System.out.println(employeesInShift);
        }
        
	}
	
	@Override
	public void printShiftByWeekForEmployee(ShiftManagementSystem ShiftSystem, Employee employee) throws ArithmeticException{
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean isValidInput=false;
		LocalDate date=null;
		
		while(!isValidInput) {
			try {
				System.out.print("Enter the start date of the week for print shifts: (dd/MM/yyyy): "); 
		        String DateString = scanner.nextLine();
		        date = LocalDate.parse(DateString,dtf);
		        isValidInput=true;
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());	
			}
		}
		
        shiftManagment.ShiftEmployeeSort(ShiftSystem);
        for(EmployeesInShift employeesInShift : ShiftSystem.getEmployeesInShift()) {
        	if(employeesInShift.getShift().getDate().isAfter(date.minusDays(1))&&employeesInShift.getShift().getDate().isBefore(date.plusWeeks(1))&&employeesInShift.getEmployees().containsKey(employee))
        			System.out.println(employeesInShift);
        }
        
	}
	
	@Override
	public void printShiftByMonth(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean isValidInput=false;
		LocalDate date=null;
		
		while(!isValidInput) {
			try {
				System.out.print("Enter the start date of the month for print shifts: (dd/MM/yyyy): "); 
		        String DateString = scanner.nextLine();
		        date = LocalDate.parse(DateString,dtf);
		        isValidInput=true;
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());	
			}
		}
		
		shiftManagment.ShiftEmployeeSort(ShiftSystem);
        for(EmployeesInShift employeesInShift : ShiftSystem.getEmployeesInShift()) {
        	if(employeesInShift.getShift().getDate().isAfter(date.minusDays(1))&&employeesInShift.getShift().getDate().isBefore(date.plusMonths(1)))
        			System.out.println(employeesInShift);
        }
        
	}
	
	@Override
	public void printShiftByMonthForEmployee(ShiftManagementSystem ShiftSystem, Employee employee) throws ArithmeticException{
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean isValidInput=false;
		LocalDate date=null;
		
		while(!isValidInput) {
			try {
				System.out.print("Enter the start date of the month for print shifts: (dd/MM/yyyy): "); 
		        String DateString = scanner.nextLine();
		        date = LocalDate.parse(DateString,dtf);
		        isValidInput=true;
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());
			}
		}
		
        shiftManagment.ShiftEmployeeSort(ShiftSystem);
        for(EmployeesInShift employeesInShift : ShiftSystem.getEmployeesInShift()) {
        	if(employeesInShift.getShift().getDate().isAfter(date.minusDays(1))&&employeesInShift.getShift().getDate().isBefore(date.plusMonths(1))&&employeesInShift.getEmployees().containsKey(employee))
        			System.out.println(employeesInShift);
        }
        
	}
	
	@Override
	public void printYourShifts(ShiftManagementSystem ShiftSystem,Employee employee)throws ArithmeticException {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean isValidInput=false;
		
		while(!isValidInput) {
			try {
				System.out.println("Enter 1 to print shift by day");
				System.out.println("Enter 2 to print shift by week");
				System.out.println("Enter 3 to print shift by month");
		        System.out.print("Enter your choice: ");
		        int choice = scanner.nextInt();
		        scanner.nextLine();
		        switch (choice) {
		        case 1:
		        	printShiftByDayForEmployee(ShiftSystem,employee); 
		        	isValidInput=true;
		        	break;
		        case 2:
		        	printShiftByWeekForEmployee(ShiftSystem,employee);
		        	isValidInput=true;
		            break;
		        case 3:
		        	printShiftByMonthForEmployee(ShiftSystem,employee);
		        	isValidInput=true;
		            break;
		        default:
		            System.out.println("Invalid choice...");
		        }
			}catch(InputMismatchException e){
				System.out.println("Input must be number");
            	scanner.next();	
			}
		}
	}
	
	@Override
	public void printEmployeeShifts(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of the employee which you want to print his shifts");
		String id = scanner.next();
		Employee employee =shiftManagment.getEmployeeById(ShiftSystem, id);
		if(employee!=null) {
			printYourShifts(ShiftSystem,employee);
		}
		else {
			System.out.println("There is no employee with "+ id+" id number");
		}
		
	}
	
	@Override
	public void printEmployeesShifts(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        boolean isValidInput=false;
        
		while(!isValidInput) {
			try {
				System.out.println("Enter 1 to print shift by day");
				System.out.println("Enter 2 to print shift by week");
				System.out.println("Enter 3 to print shift by month");
		        System.out.print("Enter your choice: ");
		        int choice = scanner.nextInt();
		        scanner.nextLine();
		        switch (choice) {
		        case 1:
		        	printShiftByDay(ShiftSystem); 
		        	isValidInput=true;
		        	break;
		        case 2:
		        	printShiftByWeek(ShiftSystem);
		        	isValidInput=true;
		            break;
		        case 3:
		        	printShiftByMonth(ShiftSystem);
		        	isValidInput=true;
		            break;
		        default:
		            System.out.println("Invalid choice...");
		        }
			}catch(InputMismatchException e){
				System.out.println("Input must be number");
            	scanner.next();	
			}
		}
	}
	
}
