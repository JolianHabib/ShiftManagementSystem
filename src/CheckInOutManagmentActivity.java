// Jolian Habib, ID: 211613526

import java.time.LocalDate;
import java.time.LocalTime;



public class CheckInOutManagmentActivity implements CheckInOutManagment {
	
	ShiftManagmentActivity shiftManagment = new ShiftManagmentActivity();
	
	@Override
	public void EnterToShift(ShiftManagementSystem ShiftSystem, Employee employee) {
		int flag =0;
        shiftManagment.ShiftEmployeeSort(ShiftSystem);
        for(EmployeesInShift employee1 :ShiftSystem.getEmployeesInShift()) {
        	if(employee1.getShift().getDate().isEqual(LocalDate.now()) && employee1.getEmployees().containsKey(employee)){
        		flag=1;
        		if(LocalTime.now().isAfter(employee1.getShift().getStartTime().minusMinutes(30))&&LocalTime.now().isBefore(employee1.getShift().getFinishTime())) {
        			employee1.getEmployees().get(employee).enterToShift();
        			employee1.getEmployees().get(employee).printCheckInOutRecordController();
        			flag=2;
        		}
        	}
        }
        if(flag ==1) {
        	System.out.println("You can enter up to 30 minutes before the start of the shift");
        }
        if(flag==0) {
        	System.out.println("You do not have a shift for this day!");
        }
	}
	
	@Override
	public void ExitfromShift(ShiftManagementSystem ShiftSystem, Employee employee) {
		shiftManagment.ShiftEmployeeSort(ShiftSystem);
		int flag =0;
		for(EmployeesInShift employee1 :ShiftSystem.getEmployeesInShift()) {
        	if(employee1.getShift().getDate().isEqual(LocalDate.now()) && employee1.getEmployees().containsKey(employee)){
        		flag =1;
        		if(LocalTime.now().isAfter(employee1.getShift().getStartTime())&&LocalTime.now().isBefore(employee1.getShift().getFinishTime().plusHours(1))) {
        			employee1.getEmployees().get(employee).exitFromShift();
    				employee1.getEmployees().get(employee).printCheckInOutRecordController();
    				flag =2;
        		}
        		
        	}
        		
		}
		if(flag ==1) {
        	System.out.println("You can exit from the shift at starting of shift until to 60 minutes after the ending of shift");
        }
        if(flag==0) {
        	System.out.println("You do not have a shift for this day!");
        }
		
		
	}
	
}
