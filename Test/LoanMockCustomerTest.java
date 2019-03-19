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

public class LoanMockCustomerTest {



    @Test
    public void testCustomer() throws Exception {

        System.out.println("in test");
        Loan loan = new Loan(5000,3);

        /*call the createMock to create a mock for the Owner class */
        Customer mockCustomer = EasyMock.createMock(Customer.class);

        /* Tell PowerMock to intercept any new call and return mockOwner */
        PowerMock.expectNew(Customer.class, "Paul",100.0).andReturn(mockCustomer);

        /* set up the expected values and return values */
        expect(mockCustomer.getMonthlypayments()).andReturn(100.0);

        /*activate the mock */
        PowerMock.replay(mockCustomer, Customer.class);

        double expResult = 161.3359;
        double result = loan.getMonthlyPayment();
        assertEquals(expResult, result, 0.05);
        /* verify that PowerMock was called and used */
        //PowerMock.verify(mockCustomer, Customer.class);
    }
}
