import java.util.Random;
/** A Boss. */
public class Boss {

    /** A description of this boss. */
    private String description;

    /** This boss's name. */
    private String name;

    private int health;

    /** The armor of this boss. */
    private int defence;

    /** The attack of this boss. */
    private int attack;

    private int reduction_Attack = 0;
    private int reduction_Defence = 0;
    private int Xp;

    /**
     * @param name
     *            This boss's name.
     *
     * @param description
     *            A description of this boss.
     */
    public Boss(String name, int health , int attack, int defence, int Xp, String description) {
        this.name = name;
        this.health = health;
        this.defence = defence;
        this.Xp = Xp;
        this.description = description;
        this.attack = attack;
    }
    /** Returns this boss's name. */
    public String getName() { return name; }

    /** Returns a description of this boss. */
    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    /** Returns the armor of this boss. */
    public int getArmor() {
        return defence;
    }

    public int getXp(){return Xp;}

    /** Returns the damage attack of this boss. */
    public int getAttack() {
        Random rand = new Random();
        if (rand.nextInt(2) == 1){ return attack + rand.nextInt(5);
        } else{ return attack - rand.nextInt(5); } 
        
    }

    /** Return the gold that the monster drop. */
    public int getGold() {
        Random RANDOM = new Random();
        return RANDOM.nextInt(500); }

    /** Change the boss's health. */
    public void changeHealth(int new_health) { health = new_health; }

    /** Change the boss's attack. */
    public void changeAtttack(int new_Attack) { attack = new_Attack; }

    /** Change the boss's defence. */
    public void changeArmor(int new_Defence) { defence = new_Defence; }

}
