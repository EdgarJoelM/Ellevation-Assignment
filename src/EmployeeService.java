import java.nio.file.AccessDeniedException;
import java.util.Optional;

/**
 * Represents employee authorization-related access methods
 */
public interface EmployeeService {

    /**
     * Verifies authorization of employee information retrieval, then, if authorized, sets the employee with the given id as admin
     * @param requesterId Represents the Id of the employee requesting to set admin access
     * @param employeeId  Represents the Id of the employee receiving admin access
     */
    void setAdmin(int requesterId, int employeeId) throws AccessDeniedException;

    /**
     * Verifies authorization of employee creation, then, if authorized, creates the given employee in the database
     * @param requesterId Represents the Id of the employee requesting to create an employee
     * @param employee  Represents the Id of the employee being created in the database
     */
    void createEmployee(int requesterId, Employee employee) throws AccessDeniedException;

    /**
     * Verifies authorization of employee information retrieval, then, if authorized, retrieves the employee information
     * @param requesterId Represents the Id of the employee requesting to view the information of an employee
     * @param employeeId Represents the Id of the employee whose information is being requested
     * @return Employee who's information matches the information on file
     */
    Optional<Employee> findEmployee(int requesterId, int employeeId) throws AccessDeniedException;

    /**
     * Verifies authorization of employee update, then, if authorized, updates that given employee information in the database
     * @param requesterId Represents the id of the employee requesting to update an employee's information
     * @param employee Representation of an employee with its updated information
     */
    void updateEmployee(int requesterId, Employee employee) throws AccessDeniedException;

    /**
     * Verifies authorization of employee deletion, then, if authorized, removes that given employee from the database
     * @param requesterId Represents the id of the employee requesting to delete an employee's information
     * @param employeeId Represents the id of the employee to be deleted
     */
    void deleteEmployee(int requesterId, int employeeId) throws AccessDeniedException;

}
