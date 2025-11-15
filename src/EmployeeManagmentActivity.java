// Jolian Habib, ID: 211613526

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class EmployeeManagmentActivity implements EmployeeManagment,EmployeeActivityInterface{
	
	@Override
	public void addEmployee(ShiftManagementSystem ShiftSystem)throws ArithmeticException{
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int rank=0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date =null;
		int flag=0;
		String id;
		do {
			System.out.println("Enter Id number of the new employee: (9-digits) ");
			id = scanner.next();
			if(CheckIdNumberOfEmpployeeIsUsed(ShiftSystem,id )==true )
				System.out.println("This id number is used!");
			else if(id.length()!=9)
				System.out.println("This id number is not 9 digit!");
			else
				flag=1;
					
		}while(flag!=1);
		
		System.out.print("Enter first name of the new employee: ");
		String firstName = scanner.next();
		
		System.out.print("Enter last name of the new employee: ");
		String lastName = scanner.next();
		scanner.nextLine();
		
		boolean isValidInput=false;
		while(!isValidInput) {
			try {
				System.out.print("Enter birth date of the new Employee: (dd/MM/yyyy): "); 
		        String DateString = scanner.nextLine();
		        date = LocalDate.parse(DateString,dtf);
		        isValidInput=true;
			}catch(InputMismatchException | DateTimeParseException e){
				System.out.println(e.getMessage());	
			}
		}
        
        System.out.println("Choose Employee Role :");
        EmployeeRole [] allEmployeeRole = EmployeeRole.values();
	    for(int i=0; i<allEmployeeRole.length;i++) {
	       	System.out.println(allEmployeeRole[i].ordinal() + " --> "+allEmployeeRole[i].name());
	    } 
	    
	    System.out.print("Enter Employee Role number: ");
	    int typeIndex = scanner.nextInt();
	    EmployeeRole employeeRole = EmployeeRole.values()[typeIndex];
	    
	    isValidInput =false;
	    while(!isValidInput) {
			try {
				System.out.println("Enter rank of the new employee (positivs number)");
				rank = scanner.nextInt();
				if(rank>0)
					isValidInput=true;
			}catch(InputMismatchException e) {
				System.out.println("Input must be number");
            	scanner.next();
			}
		}
	      
	    String userName;
	    int flag1 =0;
	    do {
	    	System.out.println("Enter user name of the new employee: ");
	    	userName = scanner.next();
	    	if(ShiftSystem.getUserNames().contains(userName)==true)
	    	{
	    		System.out.println("The user Name "+userName+" is used!");
	    	}
	    	
	    	else
	    		flag1=1;
	    	
	    }while(flag1!=1);
	    
	    ShiftSystem.getUserNames().add(userName); 
	    String pass1;
	    System.out.println("Enter a password for a new employee: ");
	    pass1 = scanner.next();
	
	    Employee employee = new Employee(id,firstName,lastName,date,employeeRole,rank,userName);
	    ShiftSystem.getEmployees().add(employee);
	    ShiftSystem.addPass(userName, pass1);
	    
	    if(employee.getEmpoloyeeRole().equals(EmployeeRole.ADMINISTRATOR)||employee.getEmpoloyeeRole().equals(EmployeeRole.SHIFT_MANAGER)) {
	    	ShiftSystem.getObserverEmployee().addObserver(employee);
	    }
	}
	
	@Override
	public boolean CheckIdNumberOfEmpployeeIsUsed(ShiftManagementSystem ShiftSystem, String IdenNumber) {
		if(getEmployeeById(ShiftSystem,IdenNumber)==null)
			return false;
		return true;	
	}
	
	@Override
	public Employee getEmployeeById(ShiftManagementSystem ShiftSystem, String Id) {
		for(Employee employee : ShiftSystem.getEmployees()) {
			if(employee.getIdNumber().equals(Id))
				return employee;
		}
		return null;		
	}
	
	@Override
	public void searchEmployee(ShiftManagementSystem ShiftSystem) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Employee employee;
		String idNumber; 
	    do {
	        System.out.print("Enter ID number: (9-digits) ");
	        idNumber = scanner.nextLine();
	     }while(idNumber.length()!=9);
	    employee = getEmployeeById(ShiftSystem,idNumber);
	    if(employee==null)
	    	System.out.println("There is no employee with the id "+idNumber+"number");
	    else
	    	System.out.println(employee);
	}
	
	@Override
	public void removeEmployee(ShiftManagementSystem ShiftSystem) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		if(ShiftSystem.getEmployees().size()==0) {
			System.out.println("There is no Employees in the system ");
			return ;
		}
		
		String idNumber; 
	    do {
	        System.out.print("Enter ID number: (9-digits) ");
	        idNumber = scanner.nextLine();
	     }while(idNumber.length()!=9);
	    if(getEmployeeById(ShiftSystem,idNumber)!=null) {
	    	ShiftSystem.getUserNames().remove(getEmployeeById(ShiftSystem,idNumber).getUserName());
		    if(getEmployeeById(ShiftSystem,idNumber).getEmpoloyeeRole().equals(EmployeeRole.ADMINISTRATOR)||getEmployeeById(ShiftSystem,idNumber).getEmpoloyeeRole().equals(EmployeeRole.SHIFT_MANAGER)) {
		    	ShiftSystem.getObserverEmployee().deleteObserver(getEmployeeById(ShiftSystem,idNumber));
		    }
		    
		    for(EmployeesInShift employeesInShift: ShiftSystem.getEmployeesInShift()) {
		    	if(employeesInShift.getEmployees().containsKey(getEmployeeById(ShiftSystem,idNumber)) && employeesInShift.getShift().getDate().isAfter(LocalDate.now())) {
		    		employeesInShift.getEmployees().remove(getEmployeeById(ShiftSystem,idNumber));
		    		employeesInShift.getEmployee().remove(getEmployeeById(ShiftSystem,idNumber));
		    		ShiftSystem.getObserverEmployee().notifyAllObserver("The employees of the "+employeesInShift.getShift()+" have changed!");
		    	}
		    }
		    
		    ShiftSystem.getEmployees().remove(getEmployeeById(ShiftSystem,idNumber));
		    System.out.println("The employed with "+idNumber+" number is removed!.");
	    }
	    else {
	    	System.out.println("There is no employee with "+idNumber+" Id number");
	    }
	    
		
	}
	
	@Override
	public void printEmployees(ShiftManagementSystem ShiftSystem) {
		Iterator<Employee> EmployeeIterator = ShiftSystem.getEmployees().iterator();
		while(EmployeeIterator.hasNext()) {
			System.out.println(EmployeeIterator.next());
		}	
	}
	
	@Override
	public void updateEmployee(ShiftManagementSystem ShiftSystem)throws ArithmeticException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String idNumber;
		int rank=0;
		Employee employee;
		System.out.println("Enter Id number of the employee: ");
		idNumber = scanner.nextLine();
		employee = getEmployeeById(ShiftSystem,idNumber);
		
		if(employee!=null) {
			System.out.println("Enter 1 if you want to change the Id number: (another number if you did not to change)");
			int change = scanner.nextInt();
			if(change ==1) {
				int flag=0;
				String id;
				do {
					System.out.println("Enter new Id number of the employee: (9-digits) ");
					id = scanner.next();
					if(CheckIdNumberOfEmpployeeIsUsed(ShiftSystem,id )==true )
						System.out.println("This id number is used!");
					else if(id.length()!=9)
						System.out.println("This id number is not 9 digit!");
					else
						flag=1;
						
				}while(flag!=1);
				employee.setIdNumber(id);	
			}
			
			System.out.println("Enter 1 if you want to change first name: (another number if you did not to change)"); 
			change = scanner.nextInt();
			if(change ==1) {
				System.out.print("Enter new first name of the employee: ");
				String firstName = scanner.next();
				employee.setFirsName(firstName);
			}
			
			System.out.println("Enter 1 if you want to change last name: (another number if you did not to change)"); 
			change = scanner.nextInt();
			if(change ==1) {
				System.out.print("Enter new last name of the employee: ");
				String lastName = scanner.next();
				employee.setLastName(lastName);
			}
			
			System.out.println("Enter 1 if you want to change birth day: (another number if you did not to change)"); 
			change = scanner.nextInt();
			scanner.nextLine();
			boolean isValidInput=false;
			LocalDate date=null;
			if(change ==1) {
				while(!isValidInput) {
					try {
						System.out.print("Enter new birth date of the Employee: (dd/MM/yyyy): "); 
				        String DateString = scanner.nextLine();
				        date = LocalDate.parse(DateString,dtf);
				        isValidInput=true;
					}catch(InputMismatchException | DateTimeParseException e){
						System.out.println(e.getMessage());
						
					}
				}
		        employee.setBirthDay(date);
			}
			
			isValidInput=false;
			System.out.println("Enter 1 if you want to change Employee Role: (another number if you did not to change)"); 
			change = scanner.nextInt();
			if(change ==1) {
				System.out.println("Choose new Employee Role :");
		        EmployeeRole [] allEmployeeRole = EmployeeRole.values();
			    for(int i=0; i<allEmployeeRole.length;i++) {
			       	System.out.println(allEmployeeRole[i].ordinal() + " --> "+allEmployeeRole[i].name());
			    } 
			    System.out.print("Enter Employee Role number: ");
			    int typeIndex = scanner.nextInt();
			    if(employee.getEmpoloyeeRole().equals(EmployeeRole.WORKER)&&(EmployeeRole.values()[typeIndex].equals(EmployeeRole.SHIFT_MANAGER) || EmployeeRole.values()[typeIndex].equals(EmployeeRole.ADMINISTRATOR))) {
			    	ShiftSystem.getObserverEmployee().addObserver(employee);
			    }
			    if((employee.getEmpoloyeeRole().equals(EmployeeRole.ADMINISTRATOR)||(employee.getEmpoloyeeRole().equals(EmployeeRole.SHIFT_MANAGER))) && EmployeeRole.values()[typeIndex].equals(EmployeeRole.WORKER)) {
			    	ShiftSystem.getObserverEmployee().deleteObserver(employee);
			    }
			    employee.setEmpoloyeeRole( EmployeeRole.values()[typeIndex]);
			}
			
			System.out.println("Enter 1 if you want to change employee rank: (another number if you did not to change)"); 
			change = scanner.nextInt();
			if(change ==1) {
				while(!isValidInput) {
					try {
						System.out.println("Enter new rank of the employee (positivs number)");
						rank = scanner.nextInt();
						if(rank>0)
							isValidInput=true;
					}catch(InputMismatchException e) {
						System.out.println("Input must be number");
		            	scanner.next();
					}
				}   
			    employee.setRank(rank);
			    			
	    	}
		}
		else {
			System.out.println("There is no employee with "+idNumber+" Id number");
		}
	}
}
	
