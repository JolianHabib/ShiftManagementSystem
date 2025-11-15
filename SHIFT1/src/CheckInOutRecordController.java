// Jolian Habib, ID: 211613526

public class CheckInOutRecordController implements CheckInOutRecordInterface {
	private CheckInOutRecord checkInOutRecord;
	private Command command;

	
	public CheckInOutRecordController() {
		this.checkInOutRecord= new CheckInOutRecord();
	}

	@Override
	public void enterToShift() {
		this.command = new EnterToShiftCommand(checkInOutRecord);
		this.command.execute();		
	}

	@Override
	public void exitFromShift() {
		this.command = new ExitFromShiftCommand(checkInOutRecord);
		this.command.execute();		
	}
	
	public void printCheckInOutRecordController() {
		System.out.println(checkInOutRecord);
	}
	
}
