import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class LoanTest {

    Loan loan = new Loan(10000,5);

    //Constructor Tests
    @Test
    public void TestGetAmount(){
        assertEquals(10000,loan.getAmount(),0.001);
    }

    @Test
    public void TestGetPeriod(){
        assertEquals(5,loan.getPeriod());
    }

    @Test
    public void TestRate(){
        assertEquals(5,loan.getRate(),0.001);
    }

    @Test
    public void TestMonthlyPayments(){
        assertEquals(188.71,loan.getMonthlyPayment(),0.01);
    }


}
