import java.util.Objects;

/**
 * An employee represents a user of the Ellevation Inc application.
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private String position;
    private boolean isAdmin;
    private String department;
    private long salary;
    private long vacationBalance;
    private long annualBonus;
    private int managerId;


    /**
     * (@code Employee) constructs a new instance of an Employee.
     * @param id represents the id of this employee
     * @param name represents the name of this employee
     * @param age represents the age of this employee
     * @param position represents the position of this employee
     * @param isAdmin represents this employee's administrative status
     * @param department represents the department that this employee works
     * @param salary represents the salary of this employee
     * @param vacationBalance represents the available vacation days this employee has
     * @param annualBonus represents the annual bonus amount this employee receives
     * @param managerId represents the id of this employee's direct manager
     */
    public Employee(int id, String name, int age, String position, boolean isAdmin, String department, long salary, long vacationBalance, long annualBonus, Integer managerId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.isAdmin = isAdmin;
        this.department = department;
        this.salary = salary;
        this.vacationBalance = vacationBalance;
        this.annualBonus = annualBonus;
        if (managerId != null) {
            this.managerId = managerId;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getVacationBalance() {
        return vacationBalance;
    }

    public void setVacationBalance(long vacationBalance) {
        this.vacationBalance = vacationBalance;
    }

    public long getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(long annualBonus) {
        this.annualBonus = annualBonus;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    /**
     * Represents the employee using their id, name, and age.
     * @return String that represents this employee
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * Overrides equality comparison from memory allocation to attribute comparison
     * @param o Object to be compared to this employee
     * @return boolean value determining equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                age == employee.age &&
                Objects.equals(name, employee.name);
    }

    /**
     * Overrides the default hashCode method
     * @return int value hashed from this employee's name, id, and age
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
