public class Player {

    /**
     * This monster's name.
     */
    private String name;

    /**
     * The armor of this monster.
     */
    private int health;

    /**
     * The attack of this monster.
     */
    private int attack;

    private int defence;

    private int level;

    /**
     * @param name    This player's name.
     * @param health  This player's health.
     * @param attack  This player's attack.
     * @param defence This player's defence.
     */
    public Player(String name, int health, int attack, int defence) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        level = 1;
    }


    /** Returns this player's name. */
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    /** Returns the armor of this player. */
    public int getArmor() {
        return defence;
    }

    /** Returns the damage attack of this player. */
    public int getAttack() {
        return attack;
    }

    /** Change the health of this player*/
    public void changeHealth(int change) {
        health = change;
    }

    /** Change the defence of the player. */
    public void changeArmor(int new_defence) {
        defence = new_defence;
    }

    /** Change the current level of the player to given number (change). */
    public void changeLevel(int change){
        level += change;
        StdOut.println("YOU HAVE LEVELED UP TO LEVEL " + level);
    }

    /** Change the attack of the player. */
    public void changeAttack(int new_Attack) { attack = new_Attack; }
}


