/**
 * Represents authorization access of Ellevation Inc. application for viewing and editing purposes
 */
public class EmployeeAuthorizationImpl implements EmployeeAuthorization {

    @Override
    public boolean canView(Employee reader, Employee employee) {
        if (reader == null || employee == null) {
            throw new IllegalArgumentException("To determine access level, given Employees cannot be null.");
        }

        if (reader.equals(employee) || reader.getId() == employee.getManagerId()) {
            return true;
        } else if (reader.getDepartment().equals("HR") && !employee.getDepartment().equals("HR")) {
            return true;
        } else {
            return reader.isAdmin();
        }
    }

    @Override
    public boolean canEdit(Employee editingEmp, Employee employee) {
        if (editingEmp == null || employee == null) {
            throw new IllegalArgumentException("To determine access level, given Employees cannot be null.");
        }

        if (editingEmp.isAdmin()) {
            return !editingEmp.equals(employee);
        } else {
            return editingEmp.getId() == employee.getManagerId();
        }
    }

    @Override
    public boolean canManagePermissions(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("To determine access level, given employee cannot be null.");
        }
        return employee.isAdmin();
    }
}
