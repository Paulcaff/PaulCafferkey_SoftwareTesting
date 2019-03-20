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
@PrepareForTest(Loan.class)

public class LoanMockTest {

    @Test //(expected = AssertionError.class)
    public void testLoan() throws Exception {
        System.out.println("in test");
        Customer customer = new Customer("Paul",175.0);
        customer.takeoutloan();

        /*call the createMock to create a mock for the relevant classes */
        Loan loan =  EasyMock.createMock(Loan.class);

        /* Tell PowerMock to intercept any new call and return mockOwner */
        PowerMock.expectNew(Loan.class,(double)10000,5).andReturn(loan);

            /* set up the expected values and return values */
        expect(loan.getMonthlyPayment()).andReturn(175.0);

            /*activate the mock */
        PowerMock.replay(loan, Loan.class);

        double expResult = 175;
        double result = loan.getMonthlyPayment();

        assertEquals(expResult,result, 0.05);

        /* verify that PowerMock was called and used */
        //PowerMock.verify(loan, Loan.class);


    }
}
