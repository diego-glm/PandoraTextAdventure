public class NPC {
    private String description;

    private String name;

    private Inventory NPCInventory;

    private String D1;

    private String D2;

    private String D3;

    private String D4;

    private String R1;

    private String R2;

    private String R3;

    private String R4;

    private boolean tradingOver;

    public NPC(String name, String description, String D1, String D2, String D3, String D4, String R1, String R2, String R3, String R4) {
        this.name = name;
        this.description = description;
        //this.NPCInventory = NPCInventory;
        this.D1 = D1;
        this.D2 = D2;
        this.D3 = D3;
        this.D4 = D4;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.R4 = R4;
    }

    public String getNPCName() {
        return name;
    }

    public String getNPCDescription() {
        return description;
    }

    public Inventory getNPCInventory() {
        return NPCInventory;
    }

    public String getDialogue1() {
        return D1;
    }

    public String getDialogue2() {
        return D2;
    }

    public String getDialogue3() {
        return D3;
    }

    public String getDialogue4() {
        return D4;
    }

    public String getResponse1() {
        return R1;
    }

    public String getResponse2() {
        return R2;
    }

    public String getResponse3() {
        return R3;
    }

    public String getResponse4() {
        return R4;
    }
}
    //The following commented out code is a trading system we begun to implement but could not finish due to time constraint but the code itself was near completion and was left in as a sign of our work.
    /**
    public void buyWeapon(String line) {
        Weapon[] NPCWeapon = NPCInventory.getWepSlots();
        if (line == "1") {

        }
        int num = Integer.parseInt(line);
    }

    public void buyArmor(String line){

    }

    public void buyConsumable(String line){

    }

    public void tradingOptions(String line) {
        String[] words = line.split(" ");
        if (words[0].equals("buy") ){
            if (words[1].equals("weapon") ){
                buyWeapon(words[2]);
            }else if (words[1].equals("armor") ){
                buyArmor(words[2]);
            }else if (words[1].equals("consumable") ){
                buyConsumable(words[2]);
            }else {
                StdOut.println("I don't understand that.");
            }else {
                StdOut.println("I don't understand that.");
            }



            public void trading(String line) {
                StdOut.println(
                        "You begin trading with NPC\n"
                );
                tradingOver = false;
                while (!tradingOver){

                    tradingOptions(StdIn.readLine());
                }
            }


    public void Trade(Player player, NPC npc, Inventory playerinventory, Inventory npcinventory)
    {

    }
}
*/