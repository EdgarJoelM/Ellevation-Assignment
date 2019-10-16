/**
 * Represents employee authentication-related access methods
 */
public interface EmployeeAuthentication {

    /**
     * Determines if the employee is an employee of Ellevation Inc.
     * @param employee Represents an employee
     * @return boolean value determining if the employee is an employee of Ellevation Inc.
     */
    boolean isEmployee(Employee employee);
}
