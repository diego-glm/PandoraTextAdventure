/**Engaging with monsters or NPCs. */
public class Combat {

    /** The player that enters into combat. */
    private Player player;

    /** The monster entering combat. */
    private Monster monster;

    /** The boss entering combat. */
    private Boss boss;

    /** The inventory of the player. */
    private Inventory inventory;

    /** Original health of the player before combat. */
    private int ply_org_health;

    /** Original defence of the player before combat. */
    private int ply_org_defence;

    /** The name of the enemy */
    private String enemyName;

    /** Boolean for the state of the battle */
    private boolean battleOver;

    /** Boolean for which type of enemy is the combat against. */
    private boolean is_a_boss = false;
    //Constructor for player vs monster.
    public Combat(Player player, Monster monster, Inventory inventory) {
        battleOver = false;
        this.player = player;
        this.monster = monster;
        this.inventory = inventory;
        boss = new Boss("None", 10, 10, 10, 10, "None");

        ply_org_health = player.getHealth();
        ply_org_defence = player.getArmor();
        enemyName = monster.getName();

        battle();
    }
    //Constructor for player vs boss.
    public Combat(Player player, Boss boss, Inventory inventory) {
        battleOver = false;
        is_a_boss = true;
        this.player = player;
        this.boss = boss;
        this.inventory = inventory;
        monster = new Monster();
        monster.setAttack(0);

        ply_org_health = player.getHealth();
        ply_org_defence = player.getArmor();
        enemyName = boss.getName();

        battle();
    }

    /** Lists the stats of the battle and options that the user can type. */
    private void listCommands() {
        if (!is_a_boss) {
            StdOut.print(
                    player.getName() +                   ":                 " + monster.getName() + ":\n" +
                            "HP: " + player.getHealth() +  "                        " + "HP: " + monster.getHealth() + "\n" +
                            "ATT: " + player.getAttack() + "                        " + "ATT: " + monster.getAttack() + "\n" +
                            "DEF: " + player.getArmor() +  "                        " + "DEF: " + 0 + "\n"
            );
        } else {
            StdOut.print(
                    player.getName() +                            ":                 " + boss.getName() + ":\n" +
                            "HP: " + player.getHealth()  + "                         " + "HP: " + boss.getHealth() + "\n" +
                            "ATT: " + player.getAttack() +  "                        " + "ATT: " + boss.getAttack() + "\n" +
                            "DEF: " + player.getArmor()  +  "                        " + "DEF: " + boss.getArmor() + "\n"
            );
        }
        StdOut.println(
                "Options:\n" +
                        "(1) Attack with current weapon.\n" +
                        "(2) Defend: reduce damage by.\n" +
                        "(3) Escape from battle.\n" +
                        "(inventory) Open inventory."
        );
    }

    /** Interpreter of user's input. */
    public void handleCommand(String line){
        StdOut.println("");
        if (player.getArmor() != ply_org_defence) { player.changeArmor(ply_org_defence); }

        switch (line) {// If case ends with break, the monster will attack back. If it ends with return, monster won't attack.
            case "1" : // Attack.
                if (!is_a_boss) {
                    StdOut.println("You attacks " + monster.getName() + ".-------------------->");
                    monster.changeHealth(monster.getHealth() - player.getAttack());
                    break;
                } else {
                    StdOut.println("You attacks " + boss.getName() + ".-------------------->");
                    boss.changeHealth(boss.getHealth() - (player.getAttack() - boss.getArmor()));
                    break;
                }

            case "2" : // Defend.
                StdOut.println("You defend. + 5 DEF");
                    player.changeArmor(player.getArmor() + 5);
                break;
            case "3": // Escape.
                if (is_a_boss) {
                    StdOut.println("You cannot escaped from a boss.");

                } else {
                    StdOut.println("You escaped successfully.");
                    battleOver = true;
                }
                return;
            case "inventory" :
                inventory.open(player);
                StdOut.println("Open Inventory.");
                return;
            default:
                StdOut.println("Invalid input. Try again");
                return;
        }
        enemyAttacks();
        updateStatus();
    }

    /** The enemy attacks back. */
    private void enemyAttacks() {
        // Monster/Boss attacks back.
        if (player.getArmor() < monster.getAttack() && player.getArmor() < boss.getAttack()) {
            if (!is_a_boss) {
                StdOut.println(monster.getName() + " attacks you. <-------------------");
                player.changeHealth(player.getHealth() - (monster.getAttack() - player.getArmor()));
            } else {
                StdOut.println(boss.getName() + " attacks you.<--------------------");
                player.changeHealth(player.getHealth() - (boss.getAttack() - player.getArmor()));
            }
        } else {
            if (!is_a_boss) {
                StdOut.println(monster.getName() + " cannot penetrate your armor.");
            } else {
                StdOut.println(boss.getName() + " cannot penetrate your armor.");
            }
        }
    }

    /** Checks the status of the battle. */
    private void updateStatus() {
        // Who dies first?
        if (player.getHealth() <= 0) {
            StdOut.println("You get a fatal blow. You die. HP : 000");
            StdOut.println("GAME OVER\n");
            System.exit(0);
        } else {
            if (!is_a_boss && monster.getHealth() <= 0) {
                battleOver = true;
            } else if (boss.getHealth() <= 0) {
                battleOver = true;

            }
        }
    }

    public void battle() {
        while (!battleOver) {
            listCommands();
            StdOut.print("What will you do? > ");
            handleCommand(StdIn.readLine());
        }
    }
    

}

