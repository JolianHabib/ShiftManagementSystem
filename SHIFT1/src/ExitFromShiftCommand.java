// Jolian Habib, ID: 211613526

import java.time.LocalDateTime;

public class ExitFromShiftCommand implements Command {
	private CheckInOutRecord checkInOutRecord;

	public ExitFromShiftCommand(CheckInOutRecord checkInOutRecord) {
		this.checkInOutRecord = checkInOutRecord;
	}
	
	@Override
	public void execute() {
		if(checkInOutRecord.getCheckOutTime()==null) {
			if(checkInOutRecord.getCheckInTime()!=null) {
				 checkInOutRecord.setCheckOutTime(LocalDateTime.now());
				 System.out.println("Have a nice day");
			}
			else {
				System.out.println("You have not logged in this shift, you cant log out");
			}
		}		   
		else
			System.out.println("You have logged out from this shift recentlly");
	}
	
}




