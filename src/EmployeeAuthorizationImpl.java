/**
 * Represents authorization access of Ellevation Inc. application for viewing and editing purposes
 */
public class EmployeeAuthorizationImpl implements EmployeeAuthorization {
    private EmployeeAuthorizationImpl() { }

    private static class ServiceInstance {
        private static final EmployeeAuthorizationImpl INSTANCE = new EmployeeAuthorizationImpl();
    }

    /**
     * Retrieves the current instance of an EmployeeAuthorizationImpl
     * @return the current instance of an EmployeeAuthorizationImpl
     */
    public static EmployeeAuthorizationImpl getInstance() {
        return ServiceInstance.INSTANCE;
    }

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
