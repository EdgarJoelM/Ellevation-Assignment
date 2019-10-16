/**
 * Represents the interface used to determine employee authorization access
 */
public interface EmployeeAuthorization {

    /**
     * Determines if an employee can view an employee's information
     * @param reader Represents the employee requesting read access
     * @param employee Represents the employee who's information is to be read
     * @return boolean value determining if the given employee (1) can read the given employee's (2) information.
     * */
    boolean canView(Employee reader, Employee employee);

    /**
     * Determines if an employee can edit an employee's information
     * @param editingEmp Represents the employee requesting edit access
     * @param employee Represents the employee who's information is to be read
     * @return
     */
    boolean canEdit(Employee editingEmp, Employee employee);

    /**
     * Determines if an employee can manage employee permissions
     * @param employee Represents the employee requesting permission managing access
     * @return boolean value determining if the given employee can manage permissions
     */
    boolean canManagePermissions(Employee employee);
}
