/** A room. */
public class Room {

    /** This room's name. */
    private String name;
    /** A description of this room. */
    private String[] description;

    /** The Consumables in this room. */
    private Consumables consumables;

    /** The weapon in this room. */
    private Weapon weapon;

    /** The boss in this room. */
    private Boss boss;

    /** The monster in this room */
    private Monster monster;

    /** The armor in this room. */
    private Armor armor;

    /** The NPCs in this room. */
    private NPC npc;

    /** The x and y coordinates */
    int x, y;

    /** Check for if player has been in this room before. */
    private boolean been_in_this_room;

    /**
     * @param name
     *            This room's name.
     * @param description
     *            A description of this room.
     */
    public Room(String name, String[] description) {
        this.name = name;
        this.description = description;
        x = 0;
        y = 0;
        been_in_this_room = false;
    }

    /** Returns a description of this room. */
    public String getDescription() {
        if (!been_in_this_room) {
            been_in_this_room  = true;
            return description[0];
        } else {
            return description[1];
        }
    }

    /** Returns this room's name. */
    public String getName() {
        return name;
    }

    /** Returns the corresponding consumable in the current room. */
    public Consumables getConsumables() { return consumables; }

    /** Returns the corresponding monster or NPC in the current room. */
    public Monster getMonster() { return monster; }
    public Boss getBoss() { return boss;}
    public NPC getNPC() { return  npc;}

    /** Returns the corresponding weapon in the current room. */
    public Weapon getWeapon() { return weapon; }

    /** Returns the corresponding armor in the current room. */
    public Armor getArmor() { return armor; }

    /** Return x coordinate for the room. */
    public int getX() { return x; }

    /** Return y coordinate for the room. */
    public int getY() { return y; }

    /** Set the given consumable to the room. */
    public void setConsumables(Consumables consumable) { this.consumables = consumables; }

    /** Set the given enemy (monster or boss) or NPC into the room. */
    public void setEnemy(Monster monster) { this.monster = monster; }
    public void setEnemy(Boss boss) { this.boss = boss; }
    public void setNPC(NPC npc) { this.npc = npc; }

    /** Set the given weapon to the room. */
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }

    /** Set the given armor to the room. */
    public void setArmor(Armor armor) { this.armor = armor; }

    /** Set the given numbers into the room location in a map. */
    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

}
