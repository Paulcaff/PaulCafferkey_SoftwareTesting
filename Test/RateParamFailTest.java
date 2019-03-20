import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)
public class RateParamFailTest {
    private double expectedRate;
    private double amount;
    private int years;

    public RateParamFailTest(double expectedRate, double amount, int years){
        this.expectedRate = expectedRate;
        this.amount = amount;
        this.years = years;
    }

    @Parameterized.Parameters (name="{index}: checkAmount({1}) = {0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {0, 0, 2},
                {0, 10001, 2},
                {0, null, 2},
                {0, 2000, 0},
                {0, 2000, 6},
                {0, 2000, null},
                {0, 499, 2},
                {0, 2000, '#'},
                {0, '#', 2},
        });
    }
    @Test (expected = IllegalArgumentException.class)
    public void testRate(){
        Loan loan = new Loan(amount, years);
        assertEquals(expectedRate, loan.getRate(), 0.001);
    }
}