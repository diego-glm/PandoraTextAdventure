import java.util.Scanner;
public class Pandora {

    /** The player. */
    private Player pandoraPL;

    /** The player's inventory */
    private Inventory inventory;

    /** The map. */
    private Map map;

    private int totalXp;

    /** The player's current gold. */
    private int gold;
    
    /**If player recently killed a monster. */
    private boolean is_monster_recently_killed;

    /** Game start.*/
    public static void main(String[] args) {
        new Pandora().run();
    }

    public Pandora() {
        //Initialize the objects
        pandoraPL = new Player("Pandora", 100, 10, 10);
        inventory = new Inventory();
        map = new Map(10, 10);
        is_monster_recently_killed = false;
        gold = 0;
        // Set player current location.
        map.setCurrentRoom(5, 5);
        // Create Rooms plus story descriptions.
        String[] str1 = {"You wake up and find yourself amongst the bushes. You can't remember much........Everything up until now is all a haze." + "\n" +
                "You do remember one thing though. Your name......" + pandoraPL.getName() + "..........." + "\n" +
                "                                " + "\n" +
                "As you wander aimlessly through greenery, you see the base of some structure off in the distance." + "\n" +
                "Rushing towards, hoping to find some semblance or sign of life, you are greeted by the base of an immense spire reaching" + "\n" +
                "as far as you can see into the sky", "You been here", "You been here"};
        Room towerThicket = new Room("Tower Thicket", str1);
        String[] str6 = {" an island beach that seems to never end, covered in sand and the ocean stretching to the horizon","You have Been" };
        Room beach = new Room("The Endless Beach", str6);
        String[] str7 = {" an under water city below the ocean the resembles Atlantis", "Welcome back to the depths"};
        Room atlantis = new Room("The Lost City of Atlantis", str7);
        // Haunted path.
        String[] str8 = {"You look at a dark path covered with tall sinister trees. Weird noises can be heard", "It the same sinister path from before."};
        Room weirdpath = new Room("weird path", str8);
        String[] str2 = {"the road splits off into two paths.\n Downward path seems to have lights.\n The rightward path seems to be dark but a water stream can be hard", "The interception from before."};
        Room interception1 = new Room("two paths appear", str2);
        String[] str3 = {"A huge house appeared out of the thick trees. It's broken down and covered with spider webs", "It the same old scary house."};
        Room hauntedHouse = new Room("haunted house", str3);

        // Set rooms locations.
        weirdpath.setCoordinates(5, 6);
        interception1.setCoordinates(5, 7);
        hauntedHouse.setCoordinates(6, 7);
        beach.setCoordinates(5,4);
        atlantis.setCoordinates(5,3);
        towerThicket.setCoordinates(5,5);

        // Associate the corresponding map to the rooms (for when there are multiple maps.)
        map.insertRoom(weirdpath);
        map.insertRoom(interception1);
        map.insertRoom(hauntedHouse);
        map.insertRoom(beach);
        map.insertRoom(atlantis);
        map.insertRoom(towerThicket);


        // Set the doors between rooms as open (true). Default: the doors are closed (false).
        map.setDoor(towerThicket, weirdpath,true);
        map.setDoor(weirdpath, interception1, true);
        map.setDoor(interception1, hauntedHouse, true);
        map.setDoor(towerThicket, beach, true);
        map.setDoor(beach, atlantis, true);

        // All Consumables being used
        towerThicket.setConsumables(new Consumables("You see a misty blue bottle with unique designs", "Strength Potion", "ATT", "None", 25, 0));

        // All Weapons being used
        towerThicket.setWeapon(new Weapon("You find unique curved sword filled with holes. Its very light", "CurvedSword", "Melee", "Physical", 38));
        // All Armor being used
        towerThicket.setArmor(new Armor("Robes of Want",  "You find a the old robes with a clover stitched into the center", 20));
        // All monsters and bosses being used.
        beach.setWeapon(new Weapon("Up a head you find a majestic golden bow with radiant golden arrows", "GoldenBow", "Ranged", "Magical", 44));
        beach.setEnemy(new Boss("Crab King", 90, 15, 8, 180, "From the depths of the sands the Crab King arises to engage you in combat"));
        atlantis.setWeapon(new Weapon("Down below you see the great trident of Posedion", "Trident","Melee","Magical",50 ));
        atlantis.setEnemy(new Boss("Poseidon", 210, 50, 50,800,"You come across the God of the sea, storms, earthquakes, horses, the fierce brother of Zeus, Almight Poseidon"));

        // All NPCs
        towerThicket.setNPC(new NPC("Norri", "Well, well....What do we have here?", "Who are you?", "Demanith?", "Can you help me?", "Are there any nearby towns?", "Me?...Names' Norri. I take it you're new to these parts. I go around looting and killing things that come wandering out the Demanith.", "Yessir. The largest spire on the continent. Although people who go in are said to never be seen again.", "Raid the spire??????............That's funny kid......No way you or I are making it outta there alive.", "I think there might be a city out east. Not too sure though since I live in these woods."));
    }

    /** List of possible commands. */
    public void listCommands() {
        StdOut.println("Examples of commands:");
        StdOut.println("  (combat)");
        StdOut.println("  (go) [(up), (down), (left), (right)]");
        StdOut.println("  (look)");
        StdOut.println("  (take) [INSERT ITEM. Ex) potion]");
        StdOut.println("  (inventory)");
        StdOut.println("  (interact)");
    }
    
    /** Reset monsters in the room after leaving. */
    public void resetMonsters() {
        if (is_monster_recently_killed) {
            map.getCurrentRoom().setEnemy(new Monster());
            is_monster_recently_killed = false;
        }
    }

    /** Interprets the input of the player. */
    public void handleCommand(String line) {
        String[] words = line.split(" ");

        if ((map.getCurrentRoom().getMonster() != null || map.getCurrentRoom().getBoss() != null) && words[0].equals("take")) {
            StdOut.println("You can not take anything with enemies nearby.");
            listCommands();
        } else if (words[0].equals("attack")) {
            attack();
        } else if (words[0].equals("go")) {
            go(words[1]);
        } else if (words[0].equals("look")) {
            look();
        } else if (words[0].equals("take")) {
            if (words[1] != null) {
                take(words[1]);
            } else {
                StdOut.println("Prompt not understand: Take what?");
            }
        } else if (words[0].equals("inventory")) {
            inventory.open(pandoraPL);
        } else if (words[0].equals("interact")) {
            interact();
        }else {
            StdOut.println("I don't understand that.");
            listCommands();
        }

    }

    /** Players enters in combat against the enemy. */
    public void attack() {

        if (map.getCurrentRoom().getMonster() != null || map.getCurrentRoom().getBoss() != null) {
            // Give credit to Takashi Fujita.
            StdOut.println("──────────────────────░█████╗░░█████╗░███╗░░░███╗██████╗░░█████╗░████████╗─────────────────────\n" +
                           "───────▄██████▄───────██╔══██╗██╔══██╗████╗░████║██╔══██╗██╔══██╗╚══██╔══╝──────▐███████▌──────\n" +
                           "──────▐▀▀▀▀▀▀▀▀▌──────██║░░╚═╝██║░░██║██╔████╔██║██████╦╝███████║░░░██║░░░──────▐░▀░▀░▀░▌──────\n" +
                           "──────▌▌▀▀▌▐▀▀▐▐──────██║░░██╗██║░░██║██║╚██╔╝██║██╔══██╗██╔══██║░░░██║░░░──────▐▄▄▄▄▄▄▄▌──────\n" +
                           "──────▐──▄▄▄▄──▌──────╚█████╔╝╚█████╔╝██║░╚═╝░██║██████╦╝██║░░██║░░░██║░░░▄▀▀▀█▒▐░▀▀▄▀▀░▌▒█▀▀▀▄\n" +
                           "───────▌▐▌──▐▌▐───────░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░▌▌▌▌▐▒▄▌░▄▄▄░▐▄▒▌▐▐▐▐\n");
            StdOut.println("--------------------------------------------BATTLE BEGINS!--------------------------------------");
            if (map.getCurrentRoom().getMonster() != null) { // Combat against the monster
                new Combat(pandoraPL, map.getCurrentRoom().getMonster(), inventory);
                if (map.getCurrentRoom().getMonster().getHealth() <= 0) {
                    StdOut.println(map.getCurrentRoom().getMonster().getName() + " has been defeated.");
                    StdOut.println("You have gained " + map.getCurrentRoom().getMonster().getXp() + "XP.");
                    totalXp += map.getCurrentRoom().getMonster().getXp();
                    if (totalXp >= 1000){
                        totalXp = 0;
                        pandoraPL.changeLevel(1);
                    }
                    map.getCurrentRoom().setEnemy((Monster) null);
                    is_monster_recently_killed = true;
                }
            }
            if (map.getCurrentRoom().getBoss() != null) { // Combat against the boss.
                new Combat(pandoraPL, map.getCurrentRoom().getBoss(), inventory);
                if (map.getCurrentRoom().getBoss().getHealth() <= 0) {
                    StdOut.println(map.getCurrentRoom().getBoss().getName() + " has been defeated.");
                    StdOut.println("You have gained " + map.getCurrentRoom().getBoss().getXp() + "XP.");
                    totalXp += map.getCurrentRoom().getBoss().getXp();
                    if (totalXp >= 1000){
                        totalXp = 0;
                        pandoraPL.changeLevel(1);
                    }
                    map.getCurrentRoom().setEnemy((Boss) null);
                }
            }
            StdOut.println("---------------------------------------------BATTLE ENDED-----------------------------------------\n\n");
            StdOut.println("Your current XP is " + totalXp );
        } else {
            StdOut.println("You look around but there seems no enemies near by.");
        }

    }


    /** Moves player to desired location. */
    public void go(String direction) {
        Room destination = map.getNeighbor(direction);
        if (destination != null) {
            if (map.getCurrentRoom().getMonster() != null || map.getCurrentRoom().getBoss() != null) {
                if (map.getPreviousRoom() == destination) {
                    map.goNextRoom(destination);
                } else {
                    StdOut.println("You can not pass until the threat is taken care off.");
                }
            } else {
                resetMonsters();
                map.goNextRoom(destination);
            }
        } else {
            StdOut.println("There is no path in that direction.");
        }
    }

    /** Display the elements within the room. */
    public void look() {
        StdOut.println("You are in " + map.getCurrentRoom().getDescription() + ".");
        if (map.getCurrentRoom().getMonster() != null) {
            StdOut.println(map.getCurrentRoom().getMonster().getDescription() + " here.");
        }
        if (map.getCurrentRoom().getBoss() != null) {
            StdOut.println(map.getCurrentRoom().getBoss().getDescription() + " here.");
        }
        if (map.getCurrentRoom().getWeapon() != null) {
            StdOut.println("There is "
                    + map.getCurrentRoom().getWeapon().getName() + " here.");
        }
        if (map.getCurrentRoom().getArmor() != null) {
            StdOut.println("There is "
                    + map.getCurrentRoom().getArmor().getDescription() + " here.");
        }
        if (map.getCurrentRoom().getConsumables() != null) {
            StdOut.println("There is "
                    + map.getCurrentRoom().getConsumables().getName() + " here.");
        }
        if (map.getCurrentRoom().getNPC() != null) {
            StdOut.println(map.getCurrentRoom().getNPC().getNPCName() + " is in here.");
        }
    }

    /** Player grabs and adds the item to the inventory. */
    public void take(String name)
    {
        Weapon weapon = map.getCurrentRoom().getWeapon();
        Armor armor = map.getCurrentRoom().getArmor();
        Consumables consumables = map.getCurrentRoom().getConsumables();
        if (weapon != null && weapon.getName().equals(name))
        {
            map.getCurrentRoom().setWeapon(null);
            inventory.addWeapon(weapon);
        }
        else if (armor != null && armor.getName().equals(name))
        {
            map.getCurrentRoom().setArmor(null);
            inventory.addArmor(armor);
        }
        else if(consumables != null && consumables.getName().equals(name))
        {
            map.getCurrentRoom().setConsumables(null);
            inventory.addConsumables(consumables);
        }
        else
        {
            StdOut.println("There is no " + name + " here.");
        }
    }

    public void interact() {
        if (map.getCurrentRoom().getNPC() != null) {
            StdOut.println( map.getCurrentRoom().getNPC().getNPCName() + ": " + map.getCurrentRoom().getNPC().getNPCDescription());
            StdOut.println("(1) " + map.getCurrentRoom().getNPC().getDialogue1() + "\n" + "(2) " + map.getCurrentRoom().getNPC().getDialogue2() + "\n" + "(3) " + map.getCurrentRoom().getNPC().getDialogue3() + "\n" + "(4) " + map.getCurrentRoom().getNPC().getDialogue4());
            Scanner userinput = new Scanner(System.in);
            int UI = userinput.nextInt();
            if (UI == 1) {
                StdOut.println(map.getCurrentRoom().getNPC().getResponse1());
            } else if (UI == 2) {
                StdOut.println(map.getCurrentRoom().getNPC().getResponse2());
            } else if (UI == 3) {
                StdOut.println(map.getCurrentRoom().getNPC().getResponse3());
            } else if (UI == 4) {
                StdOut.println(map.getCurrentRoom().getNPC().getResponse4());
            }
        }
    }


    public Inventory getplayerinventory()
    {
        return inventory;
    }


    public Player getplayer()
    {
        return pandoraPL;
    }


    /** Runs the game. */
    public void run() {
        StdOut.println(
                "Welcome to Pandora, a RPG text adventure. [Insert more background]\n"
        );
        listCommands();
        while (true) {
            StdOut.println("You are in the " + map.getCurrentRoom().getName() + ".");
            StdOut.print("> ");
            handleCommand(StdIn.readLine());
            StdOut.println();
        }
    }
}