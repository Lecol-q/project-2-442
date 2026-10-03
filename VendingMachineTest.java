import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    @Test 
    public void testInitialBalance() {
        VendingMachine machine = new VendingMachine();

        assertEquals(0, machine.getBalance());
    }
    
    @Test 
    public void testInitialSlotsAreEmpty() {
        VendingMachine machine = new VendingMachine();

        assertNull(machine.getItem("A"));
        assertNull(machine.getItem("B"));
        assertNull(machine.getItem("C"));
        assertNull(machine.getItem("D"));
    }

    @Test 
    public void addItem() {
        VendingMachine machine = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Coke", 2.5);

        machine.addItem(item, "A");

        assertEquals(item, machine.getItem("A"));
    }

    @Test 
    public void testAddItemToOccupiedSlotThrowsException() {
        VendingMachine machine = new VendingMachine();
        VendingMachineItem firstItem = new VendingMachineItem("Coke", 2.5);
        VendingMachineItem secondItem = new VendingMachineItem("Pepsi", 2);

        machine.addItem(firstItem, "A");

        assertThrows(VendingMachineException.class, () -> {
            machine.addItem(secondItem, "A");
        });
    }

    @Test 
    public void testAddItemWithInvalidCodeThrowsException() {
        VendingMachine machine = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Coke", 2.5);

        assertThrows(VendingMachineException.class, () -> {
            machine.addItem(item, "E");
        });
    }

    @Test 
    public void testRemoveItem() {
        VendingMachine machine = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Coke", 2.5);
        machine.addItem(item, "A");

        VendingMachineItem removedItem = machine.removeItem("A");

        assertEquals(item, removedItem);
        assertNull(machine.getItem("A"));
    }

    @Test 
    public void testRemoveItemFromEmptySlotThrowsException() {
        VendingMachine machine = new VendingMachine();

        assertThrows(VendingMachineException.class, () -> {
            machine.removeItem("A");
        });
    }

    @Test 
    public void testRemoveItemWithInvalidCodeThrowsException() {
        VendingMachine machine = new VendingMachine();

        assertThrows(VendingMachineException.class, () -> {
            machine.removeItem("E");
        });
    }

    @Test 
    public void testInsertMoney() {
        VendingMachine machine = new VendingMachine();

        machine.insertMoney(5.00);

        assertEquals(5.00, machine.getBalance());
    }
}
