// Jolian Habib, ID: 211613526

public interface shiftActivityInterface {
	public boolean CheckIdentificationNumberOfShiftIsUsed(ShiftManagementSystem ShiftSystem, int IdenNumber);
	public Shift getShiftByIdenNumber(ShiftManagementSystem ShiftSystem, int IdenNumber);
	public void printShifts(ShiftManagementSystem ShiftSystem);
	public EmployeesInShift gettEmployeesInShiftByShft(ShiftManagementSystem ShiftSystem, Shift shift);
	public Employee getEmployeeById(ShiftManagementSystem ShiftSystem, String Id);
	public void ShiftSort(ShiftManagementSystem ShiftSystem);
	public void ShiftEmployeeSort(ShiftManagementSystem ShiftSystem);

}
