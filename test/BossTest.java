import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BossTest {

	private Boss titan;

	@BeforeEach
	public void setUp() throws Exception {
		titan = new Boss("Titan", 100, 25, 20, 500, "a giant being with beast-like figure");
	}

	@Test
	public void storesName() {
		assertEquals("Titan", titan.getName());
	}

	@Test
	public void storesHealth() {
		assertEquals(100, titan.getHealth());
	}

	@Test
	public void storesAttack() {
		int attack = titan.getAttack();
		int f = 0;
		for (int i = 20; i < 31; i++) {
			if (i == attack) {
				f = i;
			}
		}
		assertEquals(f, attack);
	}

	@Test
	public void storesDefence() {
		assertEquals(20, titan.getArmor());
	}

	@Test
	public void storesExperience() {
		assertEquals(500, titan.getXp());
	}

	@Test
	public void storesDescription() {
		assertEquals("a giant being with beast-like figure", titan.getDescription());
	}

	@Test
	public void manipulatesHealth() {
		titan.changeHealth(50);
		assertEquals(50, titan.getHealth());
	}

	@Test
	public void manipulatesAttack() {
		titan.changeAtttack(10);
		int attack = titan.getAttack();
		int f = 0;
		for (int i = 5; i < 16; i++) {
			if (i == attack) {
				f = i;
			}
		}
		assertEquals(f, attack);
	}

	@Test
	public void manipulatesDefence() {
		titan.changeArmor(50);
		assertEquals(50, titan.getArmor());
	}

}
