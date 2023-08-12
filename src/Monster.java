import java.util.Random;
public class Monster {

    public static final String[] monster_NAMES = { "Banshee", "Skeleton", "Wisp", "Slime", "Demon", "Hollow" };
    public static final String[] monster_DESCRIPTIONS = { "A transparent human-shaped figure floats from abroad in", "a human skeleton walks around the edges in", "A group of will-o-wisp illuminates", "a jelly-like liquid splashes from here to there in", "A fallen angle from heaven guard this spot over", "A black hollow figure aggressively roams around" };
    public static final int max_attack_damage = 25;
    public static final int max_health = 200;
    public static final int min_health = 1;
    private static final int max_Xp = 500;
    private static final int min_Xp = 100;
    public static final Random RANDOM = new Random();
    private int reduction_Attack = 0;
    private int reduction_Defence = 0;
    private int attack;
    private int Xp;


    private int health;
    private String name;


    public Monster()
    {

        name = monster_NAMES[RANDOM.nextInt(monster_NAMES.length)];


        health = RANDOM.nextInt(max_health);

        attack =RANDOM.nextInt(max_attack_damage);

        Xp = RANDOM.nextInt(max_Xp);


    }


    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public int getXp(){return Xp;}


    public int getAttack()
    {
        if (RANDOM.nextInt(2) == 1){ return attack + RANDOM.nextInt(5);
        } else{ return attack - RANDOM.nextInt(5); }
    }

    public String getDescription() {
        for (int i = 0; i < monster_NAMES.length; i++) {
            if (name.equals(monster_NAMES[i])) {
                return monster_DESCRIPTIONS[i];
            }
        }
        return "none";
    }


    public void changeHealth(int newHp)
    {
        health = newHp;
    }

    public void setAttack(int newAttack) { attack = newAttack; }

    public int getGold() { return RANDOM.nextInt(100); }





}
