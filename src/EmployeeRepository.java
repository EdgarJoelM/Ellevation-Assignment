/**
 * Represents the employee repository containing all database crud operations and salary change methods
 */
public interface EmployeeRepository {

    /**
     * Creates an employee within the employee database
     * @param employee Represents an employee to be created within the database
     */
    void createEmployee(Employee employee);

    /**
     * Removes an employee from the employee database
     * @param employee Represents an employee to be removed from the database
     */
    void removeEmployee(Employee employee);

    /**
     * Updates an employee's information within the employee database
     * @param employee Represents an employee with updated information
     */
    void updateEmployee(Employee employee);

    /**
     * Deletes an employee from within the employee database
     * @param employee Represents an employee to be deleted from the database
     */
    void deleteEmployee(Employee employee);

    /**
     * Adds a record of a salary change to the database
     * @param salaryHistory Represents the historical salary change
     */
    void recordSalaryChange(SalaryHistory salaryHistory);
}
