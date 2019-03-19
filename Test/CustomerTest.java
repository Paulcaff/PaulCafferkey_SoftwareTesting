import org.junit.Test;


import static org.junit.Assert.*;


public class CustomerTest {

    Customer customer = new Customer("Paul",100);

    @Test
    public void TestgetName(){
        assertEquals("Paul",customer.getName());
    }

    @Test
    public void TestgetMpayment(){
        assertEquals(100,customer.getMonthlypayments(),0.001);
    }



}
