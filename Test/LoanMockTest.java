import org.easymock.EasyMock;
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
        Loan loan = new Loan(5000,3);


            /*call the createMock to create a mock for the Owner class */
        Customer customer = EasyMock.createMock(Customer.class);

            /* Tell PowerMock to intercept any new call and return mockOwner */
        PowerMock.expectNew(Customer.class, "Paul", 100.00).andReturn(customer);



            /* set up the expected values and return values */
        expect(customer.getMonthlypayments()).andReturn(100.00);

            /*activate the mock */
        PowerMock.replay(customer, Customer.class);

        double expResult = 10;
        double result = loan.getRate();

        assertEquals(expResult, result, 0.05);
            /* verify that PowerMock was called and used */
       // PowerMock.verify(customer, Customer.class);

    }
}
