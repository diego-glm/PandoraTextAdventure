import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

	private Player player;

	@BeforeEach
	public void setUp() throws Exception {
		player = new Player("Alex", 100, 20, 10);
	}

	@Test
	public void storesName() {
		assertEquals("Alex", player.getName());
	}

	@Test
	public void storesHealth() {
		assertEquals(100, player.getHealth());
	}

	@Test
	public void storesAttack() {
		assertEquals(20, player.getAttack());
	}

	@Test
	public void storesDefence() {
		assertEquals(10, player.getArmor());
	}

}
