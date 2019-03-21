import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Customer.class)

public class LoanMockTest {

    @Test
    public void testLoan() throws Exception {
        Customer customer = new Customer("Paul");

        /*call the createMock to create a mock for the Owner class */
        Loan mockLoan = EasyMock.createMock(Loan.class);

        /* Tell PowerMock to intercept any new call and return mockOwner */
        PowerMock.expectNew(Loan.class, 5000.0,5).andReturn(mockLoan);

        /* set up the expected values and return values */
        expect(mockLoan.getMonthlyPayment()).andReturn(175.0);

        /*activate the mock */
        PowerMock.replay(mockLoan, Loan.class);
        double expResult = 175.0;
        customer.takeoutloan();


        double result = customer.getMonthlypayments();
        assertEquals(expResult, result, 0.0005);
        /* verify that PowerMock was called and used */
        PowerMock.verify(mockLoan, Loan.class);
    }
}
