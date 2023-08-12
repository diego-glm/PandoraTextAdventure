import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class InventoryTest
{
    private Inventory InvTest;

    @BeforeEach
    public void setUp() throws Exception
    {
        InvTest = new Inventory();
    }

    @Test
    public void addWeapon()
    {
        Weapon testwep1 = new Weapon("none", "empty", "empty", "empty", 0);
        InvTest.addWeapon(testwep1);
        assertEquals(testwep1, InvTest.getWep());
    }

    @Test
    public void addArmor()
    {
        Armor testarm1 = new Armor("empty",  "none", 0);
        InvTest.addArmor(testarm1);
        assertEquals(testarm1, InvTest.getArm());
    }

    @Test
    public void addItem()
    {
        Consumables testitem1 = new Consumables("none", "empty", "HP", "HP", 0, 0);
        InvTest.addConsumables(testitem1);
        assertEquals(testitem1, InvTest.getCon());
    }
}