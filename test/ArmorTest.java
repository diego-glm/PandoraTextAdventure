import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmorTest {

	private Armor shield;

	@BeforeEach
	public void setUp() throws Exception {
		shield = new Armor("Shield", "A circular shield with spikes", 10);
	}

	@Test
	public void storesName() {
		assertEquals("Shield", shield.getName());
	}

	@Test
	public void storesDefence() {
		assertEquals(10, shield.getDefence());
	}

	@Test
	public void storesDescription() {
		assertEquals("A circular shield with spikes", shield.getDescription());
	}

}
