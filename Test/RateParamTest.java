import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)
public class RateParamTest {
    private double expectedRate;
    private double amount;
    private int years;

    public RateParamTest(double expectedRate, double amount, int years){
        this.expectedRate = expectedRate;
        this.amount = amount;
        this.years = years;
    }

    @Parameterized.Parameters (name="{index}: checkAmount({1}) = {0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {10, 2000, 2},
                {10, 500, 2},
                {5, 10000, 4},
                {8, 7500, 2},
                {6, 2500, 4},
                {5, 7500, 4},
                {10, 2500, 1},
                {8, 7500, 1},
                {10, 2500, 3},
                {8, 7500, 3},
                {6, 2500, 5},
                {5, 7500, 5},
                {10, 5000, 2},
                {8, 5001, 2},
                {8, 10000, 2},
                {6, 5000, 4},
                {5, 5001, 4},
                {5, 10000, 5},
                {6, 500, 4},
        });
    }
    @Test
    public void testrate(){
        Loan loan = new Loan(amount, years);
        assertEquals(expectedRate, loan.getRate(), 0.001);
    }
}