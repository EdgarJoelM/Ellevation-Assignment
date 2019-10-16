import java.util.Optional;

/**
 * Represents the implementation of the employee database crud operations and salary changes - NOT fully implemented
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private EmployeeRepositoryImpl() {
    }

    private static class RepositoryInstance {
        private static final EmployeeRepositoryImpl INSTANCE = new EmployeeRepositoryImpl();
    }

    /**
     * Retrieves the current instance of EmployeeRepositoryImpl
     * @return the current instance of EmployeeRepositoryImpl
     */
    public static EmployeeRepositoryImpl getInstance() {
        return RepositoryInstance.INSTANCE;
    }

    @Override
    public void createEmployee(Employee employee) {
        // N/A
    }

    @Override
    public Optional<Employee> findEmployee(int id) {
        return null; // N/A
    }


    @Override
    public void updateEmployee(Employee employee) {
        // N/A
    }

    @Override
    public void deleteEmployee(Employee employee) {
        // N/A
    }

    @Override
    public void recordSalaryChange(SalaryHistory salaryHistory) {
        // N/A
    }
}
