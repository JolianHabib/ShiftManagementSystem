// Jolian Habib, ID: 211613526

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ShiftManagmentActivity implements ShiftManagment,shiftActivityInterface {
	
	@Override
	public void addShift(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm");
		int IdenNumberRandom, flag=0;
		LocalDate date = null;
		LocalTime finishTime=null,startTime=null; 
		
		boolean isValidInput=false;
		do {
			IdenNumberRandom = random.nextInt(9999)+1;
			if(CheckIdentificationNumberOfShiftIsUsed(ShiftSystem,IdenNumberRandom )==false)
				flag=1;
		}while(flag!=1);
		
		while(!isValidInput) {
			try {
				System.out.print("Enter date of the shift: (dd/MM/yyyy): "); 
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
				System.out.print("Enter start time of the shift: (HH:MM): "); 
		        String StartDateString = scanner.nextLine();
		        startTime = LocalTime.parse(StartDateString,dtf1);
		        isValidInput=true;
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());	
			}
		}
		
		isValidInput=false;
		while(!isValidInput) {
			try {
				System.out.print("Enter finish time of the shift: (HH:MM): "); 
		        String FinishDateString = scanner.nextLine();
		        finishTime = LocalTime.parse(FinishDateString,dtf1);
		        if(finishTime.isAfter(startTime))
		        	isValidInput=true;
		        else {
		        	System.out.println("The finish Time must be after the start Time");
		        }
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());	
			}
		}
	
		Shift shift = new Shift(IdenNumberRandom,date,startTime, finishTime ); 
		ShiftSystem.getShifts().add(shift);
		ShiftSystem.getEmployeesInShift().add(new EmployeesInShift(shift) );
		ShiftSystem.getObserverEmployee().notifyAllObserver("The shift is "+shift+" added!");
	}
	
	@Override
	public boolean CheckIdentificationNumberOfShiftIsUsed(ShiftManagementSystem ShiftSystem, int IdenNumber) {
		Shift shift = getShiftByIdenNumber(ShiftSystem,IdenNumber) ;
		if(shift!=null)
			return true;
		return false;
	}
	
	@Override
	public Shift getShiftByIdenNumber(ShiftManagementSystem ShiftSystem, int IdenNumber) {
		for(Shift shift: ShiftSystem.getShifts() ) {
			if(shift.getIdentificationNumber()==IdenNumber)
				return shift;
		}
		return null;	
	}
	
	@Override
	public void printShifts(ShiftManagementSystem ShiftSystem) {
		ShiftSort(ShiftSystem);
		Iterator<Shift> shiftIterator = ShiftSystem.getShifts().iterator();
		while(shiftIterator.hasNext()) {
			System.out.println(shiftIterator.next());
		}
	}
	
	@Override
	public void removeShift(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
		printShifts(ShiftSystem);
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Shift shift=null;
		boolean isValidInput=false;
		int IdenNumber=0;
		
		while(!isValidInput) {
			try {
				System.out.println("Enter the Identification Number of the shift which you want to remove");
				IdenNumber = scanner.nextInt();
				shift = getShiftByIdenNumber(ShiftSystem,IdenNumber);
				isValidInput=true;
			}catch(InputMismatchException e) {
				System.out.println("Input must be number");
            	scanner.next();
			}
		}
		
		if(shift!=null) {
			ShiftSystem.getObserverEmployee().notifyAllObserver("The "+shift+" removed!");
			EmployeesInShift employeesInShift = gettEmployeesInShiftByShft(ShiftSystem,shift);
			employeesInShift.notifyAllObserver("the shift"+shift+" of you is removed! ");
			ShiftSystem.getEmployeesInShift().remove(employeesInShift);
			ShiftSystem.getShifts().remove(shift);
			System.out.println("The shift with Identification Number "+ IdenNumber+" has removed successfully");
		}
		
		else
			System.out.println("There is no shift with Identification number "+ IdenNumber);
		
	}
	
	@Override
	public EmployeesInShift gettEmployeesInShiftByShft(ShiftManagementSystem ShiftSystem, Shift shift) {
		for(EmployeesInShift employee: ShiftSystem.getEmployeesInShift()) {
			if(employee.getShift().equals(shift))
				return employee;
		}
		return null;
	}
	
	@Override
	public void searchShift(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
		printShifts(ShiftSystem);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Shift shift=null;
		boolean isValidInput=false;
		int IdenNumber=0;
		
		while(!isValidInput) {
			try {
				System.out.println("Enter the Identification Number of the shift which you want to search");
				IdenNumber = scanner.nextInt();
				shift = getShiftByIdenNumber(ShiftSystem,IdenNumber);
				isValidInput=true;
			}catch(InputMismatchException e) {
				System.out.println("Input must be number");
            	scanner.next();
			}
		}
		
		if(shift!=null) {
			System.out.println(shift);
		}
		else {
			System.out.println("There is no shift with Identification number "+ IdenNumber);
		}
	}
	
	@Override
	public void updateShift(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
		printShifts(ShiftSystem);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm");
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Shift shift=null;
		LocalDate date=null;
		LocalTime startTime =null, finishTime=null;
		boolean isValidInput=false, ischanged=false, removedEmployee=false;
		int IdenNumber=0;
		
		while(!isValidInput) {
			try {
				System.out.println("Enter the Identification Number of the shift which you want to change");
				IdenNumber = scanner.nextInt();
				shift = getShiftByIdenNumber(ShiftSystem,IdenNumber);
				isValidInput=true;
			}catch(InputMismatchException e) {
				System.out.println("Input must be number");
            	scanner.next();
			}
		}
		
		isValidInput=false;
		if(shift!=null) {
			EmployeesInShift employeesInShift = gettEmployeesInShiftByShft(ShiftSystem,shift);
			System.out.println("Enter 1 if you want to change the Identification number: (another number if you did not to change)");
			int change = scanner.nextInt();
			if(change ==1) {
				int IdenNumber1, flag=0;
				do {
					System.out.println("Enter a new Identification Number");
					IdenNumber1 = scanner.nextInt();
					if(CheckIdentificationNumberOfShiftIsUsed(ShiftSystem,IdenNumber1 )==false) {
						flag=1;
						ischanged=true;
					}
					else
						System.out.println("This number is used!");	
				}while(flag!=1);
				shift.setIdentificationNumber(IdenNumber1);
			}
			
			System.out.println("Enter 1 if you want to change the Date of shift : (another number if you did not to change)");
			change = scanner.nextInt();
			scanner.nextLine();
			if(change ==1) {
				while(!isValidInput) {
					try {
						System.out.print("Enter new date of the shift: (dd/MM/yyyy): "); 
				        String DateString = scanner.nextLine();
				        date = LocalDate.parse(DateString,dtf);
				        isValidInput=true;
					}catch(InputMismatchException | DateTimeParseException e){
						System.out.println(e.getMessage());
						
					}
				}
				if(!(shift.getDate().isEqual(date)))
						ischanged=true;
		        shift.setDate(date);
			}
			
			System.out.println("Enter 1 if you want to change the Start Time : (another number if you did not to change)");
			change = scanner.nextInt();
			scanner.nextLine();
			if(change ==1) {
				while(!isValidInput) {
					try {
						System.out.print("Enter new start time of the shift: (HH:MM): "); 
				        String StartDateString = scanner.nextLine();
				        startTime = LocalTime.parse(StartDateString,dtf1);
				        isValidInput=true;
					}catch(InputMismatchException | DateTimeParseException e){
						System.out.println(e.getMessage());
						
					}
				}
				if(!(shift.getStartTime().equals(startTime)))
					ischanged=true;
		        shift.setStartTime(startTime);
			}
			
			System.out.println("Enter 1 if you want to change the Finish Time : (another number if you did not to change)");
			change = scanner.nextInt();
			scanner.nextLine();
			if(change ==1) {
				isValidInput=false;
				while(!isValidInput) {
					try {
						System.out.print("Enter new finish time of the shift: (HH:MM): "); 
				        String FinishDateString = scanner.nextLine();
				        finishTime = LocalTime.parse(FinishDateString,dtf1);
				        if(finishTime.isAfter(startTime))
				        	isValidInput=true;
				        else {
				        	System.out.println("The finish Time must be after the start Time");
				        }
					}catch(InputMismatchException | DateTimeParseException e){
						System.out.println(e.getMessage());
						
						
					}
				}if(!(shift.getFinishTime().equals(finishTime)))
					ischanged=true;
		        shift.setFinishTime(finishTime);
			}
			
			System.out.println("Enter 1 if you want to remove emploee from shift : (another number if you did not to change)");
			change = scanner.nextInt();
			scanner.nextLine();
			if(change ==1)
			{
				System.out.println("Enter id number for the employee which you want to remove from the shift");
				String idNumber = scanner.next();
				Employee employee = this.getEmployeeById(ShiftSystem, idNumber);
				if(employee !=null) {
					if(employeesInShift.getEmployees().containsKey(employee)==true)
					{
						employeesInShift.getEmployees().remove(employee);
						employeesInShift.notifyObserver(employee, "You removed from shift");
						employeesInShift.getEmployee().remove(employee);
						removedEmployee=true;
						
					}
				}
			}
			
			if(ischanged==true) {
				ShiftSystem.getObserverEmployee().notifyAllObserver("The "+shift+" is changed!");
				employeesInShift.notifyAllObserver("the "+shift+" of you is changed! ");	
			}
			
			if(ischanged==false&&removedEmployee==true)
				ShiftSystem.getObserverEmployee().notifyAllObserver("The employees of the "+shift+" have changed!");	
		}
		
		else {
			System.out.println("There is no shift with Identification number "+ IdenNumber);
		}
	}
	
	@Override
	public Employee getEmployeeById(ShiftManagementSystem ShiftSystem, String Id) {
		for(Employee employee:ShiftSystem.getEmployees()) {
			if(employee.getIdNumber().equals(Id))
				return employee;
		}
		return null;
		
	}
	
	@Override
	public void ShiftEmployeeAssignme(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
		printShifts(ShiftSystem);
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Shift shift;
		Employee employee;
		boolean isValidInput=false;
		int IdenNumber=0;
		while(!isValidInput) {
			try {
				System.out.println("Enter the Identification Number of the shift which you want to assignment the employee");
				IdenNumber = scanner.nextInt();
				shift = getShiftByIdenNumber(ShiftSystem,IdenNumber);
				isValidInput=true;
			}catch(InputMismatchException e) {
				System.out.println("Input must be number");
            	scanner.next();
			}
		}
		
		shift = getShiftByIdenNumber(ShiftSystem,IdenNumber);
		if(shift==null) {
			System.out.println("There is no shift with Identification number "+ IdenNumber);
			return;
		}
		
		EmployeesInShift employeesInShift = gettEmployeesInShiftByShft(ShiftSystem,shift);
		System.out.println("Enter the Id Number of the employee which you want to assignment to the shift by number "+shift.getIdentificationNumber() );
		String IdNumber = scanner.next();
		employee = getEmployeeById(ShiftSystem,IdNumber);
		if(employee==null) {
			System.out.println("There is no employee with the id number "+IdNumber);
			return;
		}
		
		if(employeesInShift.getEmployees().containsKey(employee))
			System.out.println("The "+employee+ " in this shift");
		else {
			employeesInShift.getEmployees().put(employee, new CheckInOutRecordController());
			employeesInShift.getEmployee().add(employee);
			employeesInShift.notifyObserver(employee, "you assignment to a "+shift);
			
		}

	}
	
	@Override
	public void ShiftSort(ShiftManagementSystem ShiftSystem) {
		Collections.sort(ShiftSystem.getShifts(), new Comparator<Shift>() {  
        @Override
        public int compare(Shift sh1, Shift sh2) {
            return sh1.getDate().compareTo(sh2.getDate());
        }
    });
	}
	
	@Override
	public void ShiftEmployeeSort(ShiftManagementSystem ShiftSystem) {
		Collections.sort(ShiftSystem.getEmployeesInShift(), new Comparator <EmployeesInShift>() {  
		@Override
		public int compare(EmployeesInShift o1, EmployeesInShift o2) {
			return o1.getShift().getDate().compareTo(o2.getShift().getDate());
		}
    });
		
	}
	
}

