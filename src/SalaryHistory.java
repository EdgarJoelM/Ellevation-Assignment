import java.util.Objects;

/**
 * Represents the historical record of an employee's salary
 */
public class SalaryHistory {
    private int employeeId;
    private String effectiveDate;
    private long salary;

    /**
     * Constructs an instance of an employee's salary history
     * @param employeeId Represents an employee's ID
     * @param effectiveDate Represents the date of salary change
     * @param salary Represents the annual salary of the employee at the given date
     */
    public SalaryHistory(int employeeId, String effectiveDate, long salary) {
        this.employeeId = employeeId;
        this.effectiveDate = effectiveDate;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    /**
     * Overrides the existing toString method to represent a salary history instance through its employee id,
     * effective date, and salary
     * @return String representing a historical salary update
     */
    @Override
    public String toString() {
        return "SalaryHistory{" +
                "employeeId=" + employeeId +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", salary=" + salary +
                '}';
    }

    /**
     * Overrides the existing equals method to compare this salary history's attributes with a given objects attributes
     * if that given object is an instance of a salary history
     * @param o Object to be compared with this salary history
     * @return boolean value determining if this employee is equal to the given object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalaryHistory)) return false;
        SalaryHistory that = (SalaryHistory) o;
        return employeeId == that.employeeId &&
                salary == that.salary &&
                Objects.equals(effectiveDate, that.effectiveDate);
    }

    /**
     * Overrides the existing hashCode method to consider this salary history's attributes
     * @return int value representing this salary history's hashed employee id, effective date, and salary
     */
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, effectiveDate, salary);
    }
}
