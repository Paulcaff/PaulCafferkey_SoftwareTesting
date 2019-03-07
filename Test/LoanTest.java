import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class LoanTest {

    Loan loan = new Loan(100,12);

    @Test
    public void TestgetAmount(){
        assertEquals(100,loan.getAmount());
    }

    @Test
    public void TestgetPeriod(){
        assertEquals(12,loan.getPeriod());
    }
}
