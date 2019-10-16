import java.nio.file.AccessDeniedException;
import java.util.Optional;

/**
 * Represents an implementation of the employee authentication level access methods - NOT fully implemented
 */
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepositoryImpl empRepo;
    EmployeeAuthorizationImpl empAuth;

    public EmployeeServiceImpl() {
        this.empRepo = EmployeeRepositoryImpl.getInstance();
        this.empAuth = EmployeeAuthorizationImpl.getInstance();
    }


    @Override
    public void setAdmin(int requesterId, int employeeId) throws AccessDeniedException {
        if (empAuth.canManagePermissions(empRepo.findEmployee(requesterId).get())) {
            Employee employee = empRepo.findEmployee(employeeId).get();
            employee.setAdmin(true);
            empRepo.updateEmployee(employee);
        } else {
            throw new AccessDeniedException("You do not have the ability to manage user permission");
        }
    }

    @Override
    public void createEmployee(int requesterId, Employee employee) throws AccessDeniedException {
        // If requester is an admin, create the employee
        if (empAuth.canManagePermissions(empRepo.findEmployee(requesterId).get())) {
            empRepo.createEmployee(employee);
        } else {
            throw new AccessDeniedException("You do not have the ability to create an employee");
        }

    }

    @Override
    public Optional<Employee> findEmployee(int requesterId, int employeeId) throws AccessDeniedException {
        if (empAuth.canView(empRepo.findEmployee(requesterId).get(), empRepo.findEmployee(employeeId).get())) {
            return this.empRepo.findEmployee(employeeId);
        } else {
            throw new AccessDeniedException("You do not have access to this employee's information");
        }


    }

    @Override
    public void updateEmployee(int requesterId, Employee employee) throws AccessDeniedException {
        if (empAuth.canEdit(empRepo.findEmployee(requesterId).get(), empRepo.findEmployee(employee.getId()).get())) {
            empRepo.updateEmployee(employee);
        } else {
            throw new AccessDeniedException("You do not have the ability to update this employee's information");
        }
    }

    @Override
    public void deleteEmployee(int requesterId, int employeeId) throws AccessDeniedException {
        if (empAuth.canManagePermissions(empRepo.findEmployee(requesterId).get())) {
            empRepo.deleteEmployee(empRepo.findEmployee(employeeId).get());
        } else {
            throw new AccessDeniedException("You do not have the ability to delete this employee");
        }
    }
}
