import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class LoanTest {

    Loan loan = new Loan(1000,4);

    @Test
    public void TestgetAmount(){
        assertEquals(1000,loan.getAmount(),0.001);
    }

    @Test
    public void TestgetPeriod(){
        assertEquals(4,loan.getPeriod());
    }
}
