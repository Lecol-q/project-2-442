import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    @Test 
    public void testInitialBalance() {
        VendingMachine machine = new VendingMachine();

        assertEquals(0, machine.getBalance());
    }
    
    
}
