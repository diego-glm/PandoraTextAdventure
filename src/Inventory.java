import java.util.Scanner;
public class Inventory {

    private Weapon[] weapon_slots = new Weapon[10];
    private Consumables[] item_slots = new Consumables[10];
    private Armor[] armor_slots = new Armor[10];

    Inventory()
    {
        for (int i = 0; i < weapon_slots.length; i++)
        {
            weapon_slots[i] = new Weapon("none", "empty", "empty", "empty", 0);
        }
        for (int i = 0; i < item_slots.length; i++)
        {
            item_slots[i] = new Consumables("none", "empty", "HP", "HP", 0, 0);
        }
        for (int i = 0; i < armor_slots.length; i++)
        {
            armor_slots[i] = new Armor("empty",  "none", 0);
        }
    }

    public void addWeapon(Weapon item) {
        int i;
        for (i = 0; i < weapon_slots.length; i++) {
            if (weapon_slots[i].getName() == "empty") {
                weapon_slots[i] = item;
                break;
            }

            if (weapon_slots[weapon_slots.length - 1].getName() != "empty") {
                StdOut.println("Your Weapon inventory is full.");
            }
        }
    }


    public void addArmor(Armor item) {
        int i;
        for (i = 0; i < armor_slots.length; i++) {
            if (armor_slots[i].getName() == "empty") {
                armor_slots[i] = item;
                break;
            }

            if (armor_slots[armor_slots.length - 1].getName() != "empty") {
                StdOut.println("Your Armor inventory is full.");
            }
        }
    }


    public void addConsumables(Consumables item) {
        int i;
        for (i = 0; i < item_slots.length; i++) {
            if (item_slots[i].getName() == "empty") {
                item_slots[i] = item;
                break;
            }

            if (item_slots[item_slots.length - 1].getName() != "empty") {
                StdOut.println("Your Consumables inventory is full.");
            }
        }
    }


    public void equipWep(Player player, Weapon weapon) {
        if (weapon.getName() != "empty")
        {
            player.changeAttack(weapon.getDamage());
        }
    }

    public void equipArmor(Player player, Armor armor) {
        if (armor.getName() != "empty") {
            player.changeArmor(armor.getDefence());
        }
    }

    public void addBuff(Player player, Consumables consumable)
    {
        if (consumable.getName() != "empty") {
            if (consumable.getBufftype() == "ATT") {
                player.changeAttack(player.getAttack() + consumable.getBuff());
            }

            if (consumable.getBufftype() == "DEF") {
                player.changeArmor(player.getArmor() + consumable.getBuff());
            }

            if (consumable.getBufftype() == "HP") {
                player.changeHealth(player.getHealth() + consumable.getBuff());
            }
        }
    }


    public void removeBuff(Player player, Consumables consumable)
    {
        if (consumable.getBufftype() == "ATT")
        {
            player.changeAttack(player.getAttack() - consumable.getBuff());
        }

        if (consumable.getBufftype() == "DEF")
        {
            player.changeArmor(player.getArmor() - consumable.getBuff());
        }

        if (consumable.getBufftype() == "HP")
        {
            player.changeHealth(player.getHealth() - consumable.getBuff());
        }
    }

    /** Display the inventory as a table with the currents weapons, armors, and consumables. */
    private void display()
    {
        String str = "*************************************INVENTORY************************************\n" +
                     "__________________________________________________________________________________\n" +
                     "|  |     Weapons: (ATT) |     Armors: (DEF) |       Consumables:     (Effect)    |\n";
        for (int i = 0; i < weapon_slots.length; i++)
        {
            double num, att, def, buff, debuff;
            num = i;
            att = weapon_slots[i].getDamage();
            def = armor_slots[i].getDefence();
            buff = item_slots[i].getBuff();
            debuff = item_slots[i].getDebuff();

            str +=   "|__|____________________|___________________|____________________________________|\n";
            str += String.format("|%2.0f|%13s (%3.0f) |%12s (%3.0f) |%18s (%3.0f %3s; %3.0f%3s)|\n",
                    num, weapon_slots[i].getName(), att, armor_slots[i].getName(), def, item_slots[i].getName(), buff, item_slots[i].getBuff(), debuff, item_slots[i].getDebuff());
        }
        str +=       "|__|____________________|___________________|____________________________________|\n";
        StdOut.println(str);
        StdOut.println("What do you want to do?\n" +
                "\n" +
                "(1) Equip Weapon\n" +
                "(2) Equip Armor\n" +
                "(3) Use Consumable\n" +
                "(4) Delete Weapon\n" +
                "(5) Delete Armor\n" +
                "(6) Delete Consumable\n" +
                "(7) Exit Inventory\n" +
                "             \n" +
                "typing anything else will result in the ultimate punishment....");
    }

    public void open(Player player)
    {
            display();

            Scanner pandora_input1 = new Scanner(System.in);
            int pi1 = pandora_input1.nextInt();
            if (pi1 == 1) {
                StdOut.println("Counting left to right, which weapon would you like to equip (enter a number)");
                Scanner pandora_input2 = new Scanner(System.in);
                int pi2 = pandora_input1.nextInt();
                equipWep(player, weapon_slots[pi2 - 1]);
            } else if (pi1 == 2) {
                StdOut.println("Counting left to right, which armor piece would you like to equip (enter a number)");
                Scanner pandora_input2 = new Scanner(System.in);
                int pi2 = pandora_input1.nextInt();
                equipArmor(player, armor_slots[pi2 - 1]);
            } else if (pi1 == 3) {
                StdOut.println("Counting left to right, which item would you like to use (enter a number)");
                Scanner pandora_input2 = new Scanner(System.in);
                int pi2 = pandora_input1.nextInt();
                addBuff(player, item_slots[pi2 - 1]);
                item_slots[pi2 - 1] = new Consumables("empty", "empty", "HP", "HP", 0, 0);;
            } else if (pi1 == 4) {
                StdOut.println("Counting left to right, which weapon would you like to delete (enter a number)");
                Scanner pandora_input2 = new Scanner(System.in);
                int pi2 = pandora_input1.nextInt();
                weapon_slots[pi2 - 1] = new Weapon("empty", "empty", "empty", "empty", 0);;
            } else if (pi1 == 5) {
                StdOut.println("Counting left to right, which armor piece would you like to delete (enter a number)");
                Scanner pandora_input2 = new Scanner(System.in);
                int pi2 = pandora_input1.nextInt();
                armor_slots[pi2 - 1] = new Armor("empty", "empty", 0);;
            } else if (pi1 == 6) {
                StdOut.println("Counting left to right, which item would you like to delete (enter a number)");
                Scanner pandora_input2 = new Scanner(System.in);
                int pi2 = pandora_input1.nextInt();
                item_slots[pi2 - 1] = new Consumables("empty", "empty", "HP", "HP", 0, 0);;
            } else if (pi1 == 7) {
                return;
            }
            else {
                StdOut.println("that's not an option, you will now be punished for your crimes...");
                System.exit(0);
            }
        }



    public Weapon[] getWepSlots()
    {
        return weapon_slots;
    }

    public Armor[] getArmSlots()
    {
        return armor_slots;
    }

    public Consumables[] getConSlots()
    {
        return item_slots;
    }

    public Weapon getWep()
    {
        return weapon_slots[0];
    }

    public Armor getArm()
    {
        return armor_slots[0];
    }

    public Consumables getCon()
    {
        return item_slots[0];
    }





    //Use this to test the code.
    public static void main(String[] args) {
        StdOut.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "▒▒▄▄▄▒▒▒█▒▒▒▒▄▒▒▒▒▒▒▒▒\n" +
                "▒█▀█▀█▒█▀█▒▒█▀█▒▄███▄▒\n" +
                "░█▀█▀█░█▀██░█▀█░█▄█▄█░\n" +
                "░█▀█▀█░█▀████▀█░█▄█▄█░\n" +
                "████████▀█████████████\n");


    }
}



