import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testEmployee {
    private Employee john;
    private Employee jose;
    private Employee sarah;

    @Before
    public void initTestConditions() {
        john = new Employee(1, "John", 21, "Manager", true, "Product",
                70000, 10, 1000, null);
        jose = new Employee(2, "Tim", 30, "Manager", false, "HR",
                60000, 10, 1000, 1);
        sarah = new Employee(3, "Sarah", 21, "Employee", false, "HR",
                50000, 10, 1000, 2);
    }

    @Test
    public void testEmployeeId() {
        assertEquals(2, jose.getId());
        jose.setId(54);
        assertEquals(54, jose.getId());
    }

    @Test
    public void testEmployeeName() {
        assertEquals("John", john.getName());
        assertEquals("Manager", john.getPosition());
        john.setName("Henry");
        assertEquals("Henry", john.getName());
    }

    @Test
    public void testEmployeeAge() {
        assertEquals(21, sarah.getAge());
        sarah.setAge(53);
        assertEquals(53, sarah.getAge());
    }

    @Test
    public void testEmployeePosition() {
        assertEquals("Employee", sarah.getPosition());
        sarah.setPosition("Manager");
        assertEquals("Manager", sarah.getPosition());
    }

    @Test
    public void testEmployeeAdmin() {
        assertTrue(john.isAdmin());
        assertFalse(jose.isAdmin());
        john.setAdmin(false);
        jose.setAdmin(true);
        assertFalse(john.isAdmin());
        assertTrue(jose.isAdmin());
    }

    @Test
    public void testEmployeeDepartment() {
        assertEquals("Product", john.getDepartment());
        john.setDepartment("HR");
        assertEquals("HR", john.getDepartment());
    }

    @Test
    public void testEmployeeSalary() {
        assertEquals(60000, jose.getSalary());
        jose.setSalary(100000);
        assertEquals(100000, jose.getSalary());
    }

    @Test
    public void testEmployeeVacationBalance() {
        assertEquals(10, jose.getVacationBalance());
        jose.setVacationBalance(100);
        assertEquals(100, jose.getVacationBalance());
    }

    @Test
    public void testEmployeeAnnualBonus() {
        assertEquals(1000, jose.getAnnualBonus());
        jose.setAnnualBonus(5000000);
        assertEquals(5000000, jose.getAnnualBonus());
    }

    @Test
    public void testEmployeeManagerId() {
        assertEquals(Optional.of(0), Optional.ofNullable(john.getManagerId()));
        assertEquals(Optional.of(1), Optional.ofNullable(jose.getManagerId()));
        jose.setManagerId(3);
        assertEquals(Optional.of(3),Optional.ofNullable(jose.getManagerId()));
    }
}
