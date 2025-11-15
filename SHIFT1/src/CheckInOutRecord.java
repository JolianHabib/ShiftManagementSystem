// Jolian Habib, ID: 211613526

import java.time.LocalDateTime;

public class CheckInOutRecord {
	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;
	
	
	public CheckInOutRecord() {
		this.checkInTime = null;
		this.checkOutTime = null;	
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	@Override
	public String toString() {
		return "CheckInOutRecord [checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime + "]";
	}
	
}
