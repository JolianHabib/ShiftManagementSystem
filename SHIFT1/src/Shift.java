// Jolian Habib, ID: 211613526

import java.time.LocalDate;
import java.time.LocalTime;


public class Shift implements Comparable<Shift>{
	private int IdentificationNumber;
	private LocalDate date;
	private LocalTime StartTime;
	private LocalTime finishTime;
		
	public Shift(int identificationNumber, LocalDate date,LocalTime StartTime, LocalTime finishTime) {
		IdentificationNumber = identificationNumber;
		this.setDate(date);
		this.StartTime = StartTime;
		this.finishTime = finishTime;	
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public int getIdentificationNumber() {
		return IdentificationNumber;
	}

	public LocalTime getStartTime() {
		return StartTime;
	}

	public LocalTime getFinishTime() {
		return finishTime;
	}
	
	public void setIdentificationNumber(int identificationNumber) {
		IdentificationNumber = identificationNumber;
	}

	public void setStartTime(LocalTime startTime) {
		StartTime = startTime;
	}

	public void setFinishTime(LocalTime finishTime) {
		this.finishTime = finishTime;
	}

	@Override
	public String toString() {
		return "Shift [IdentificationNumber=" + IdentificationNumber +", date=" + date + ", StartTime=" + StartTime + ", finishTime="
				+ finishTime + "]";
	}

	@Override
	public int compareTo(Shift o) {
		return this.date.compareTo(o.date);	
	}

}
