import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponTest {

	private Weapon sword;

	@BeforeEach
	public void setUp() throws Exception {
		sword = new Weapon("a trusty steel shortsword", "sword", "none", "none", 10);
	}

	@Test
	public void storesName() {
		assertEquals("sword", sword.getName());
	}

	@Test
	public void storesDamage() {
		assertEquals(10, sword.getDamage());
	}

	@Test
	public void storesDescription() {
		assertEquals("a trusty steel shortsword", sword.getDesc());
	}

}
