// Jolian Habib, ID: 211613526

import java.time.LocalDateTime;

public class EnterToShiftCommand implements Command{
	private CheckInOutRecord checkInOutRecord;

	public EnterToShiftCommand(CheckInOutRecord checkInOutRecord) {
		this.checkInOutRecord = checkInOutRecord;
	}
	
	@Override
	public void execute() {
		if(checkInOutRecord.getCheckInTime()==null) {
			checkInOutRecord.setCheckInTime(LocalDateTime.now());
			System.out.println("Have a nice shift");
		}
		else
			System.out.println("You have logged in to this shift recentlly");	
	}

}
