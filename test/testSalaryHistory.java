import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSalaryHistory {
    private SalaryHistory salaryHistory;

    @Before
    public void initTestConditions() {
        salaryHistory = new SalaryHistory(1, "2019-01-01", 100000);
    }


    @Test
    public void testSalaryHistoryEmployeeId() {
         assertEquals(1, salaryHistory.getEmployeeId());
         salaryHistory.setEmployeeId(2);
         assertEquals(2, salaryHistory.getEmployeeId());
    }

    @Test
    public void testSalaryHistoryEffectiveDate() {
        assertEquals("2019-01-01", salaryHistory.getEffectiveDate());
        salaryHistory.setEffectiveDate("2000-01-01");
        assertEquals("2000-01-01", salaryHistory.getEffectiveDate());
    }

    @Test
    public void testSalaryHistorySalary() {
        assertEquals(100000, salaryHistory.getSalary());
        salaryHistory.setSalary(999999);
        assertEquals(999999, salaryHistory.getSalary());
    }


}
