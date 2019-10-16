import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class testEmployeeAuthorization {
    private Employee john;
    private Employee jose;
    private Employee sarah;
    private Employee julie;
    private EmployeeAuthorization empAuth;

    @Before
    public void initTestConditions() {
        john = new Employee(1, "John", 21, "Manager", false, "Product",
                70000, 10, 1000, null);
        jose = new Employee(2, "Tim", 30, "Manager", false, "HR",
                60000, 10, 1000, 1);
        sarah = new Employee(3, "Sarah", 21, "Employee", false, "HR",
                50000, 10, 1000, 2);
        julie = new Employee(4, "Julie", 21, "Employee", true, "Product",
                50000, 10, 1000, 1);
        empAuth = new EmployeeAuthorizationImpl();
    }

    @Test
    public void testCanView() {
        // Direct manager or self can view
        assertTrue(empAuth.canView(john, john));
        assertTrue(empAuth.canView(john, jose));
        // Employees in HR can view other employees not in HR
        assertTrue(empAuth.canView(sarah, john));
        assertFalse(empAuth.canView(sarah, jose));
        // Admins can view everyone
        assertTrue(empAuth.canView(julie, john));
        assertTrue(empAuth.canView(julie, jose));
        assertTrue(empAuth.canView(julie, sarah));
        // managed cannot view manager, manager cannot view second hand managed employee
        assertFalse(empAuth.canView(john, sarah));
        assertFalse(empAuth.canView(sarah, jose));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullCanViewTwoNullParameters() {
        empAuth.canView(null, null);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullCanViewLeftNullParameter() {
        empAuth.canView(null, sarah);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullCanViewSecondNullParameter() {
        empAuth.canView(john, null);
    }

    @Test
    public void testCanEdit() {
        // employee (manager) can edit direct managed, not second hand managed, or self
        assertTrue(empAuth.canEdit(john, jose));
        assertFalse(empAuth.canEdit(john, sarah));
        assertFalse(empAuth.canEdit(john, john));
        // admins cannot edit themselves but can edit everyone else
        assertFalse(empAuth.canEdit(julie, julie));
        assertTrue(empAuth.canEdit(julie, john));
        assertTrue(empAuth.canEdit(julie, jose));
        assertTrue(empAuth.canEdit(julie, sarah));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullCanEditTwoNullParameters() {
        empAuth.canEdit(null, null);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullCanEditLeftNullParameter() {
        empAuth.canEdit(null, sarah);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullCanEditSecondNullParameter() {
        empAuth.canEdit(john, null);
    }

    @Test
    public void testCanManagePermissions() {
        // admin can manage permissions
        assertTrue(empAuth.canManagePermissions(julie));
        // non-admin cannot
        assertFalse(empAuth.canManagePermissions(john));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullParamCanManagePermissions() {
        empAuth.canManagePermissions(null);

    }
}
