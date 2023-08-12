/** A shield. */
public class Armor
{
    /** Description of the shield. */
    private String description;

    /** Name of the shield. */
    private String name;

    /** Amount of defence the shield blocks. */
    private int defence;

    /**
     * @param name
     *            Name of the shield.
     * @param description
     *            Description of the shield.
     * @param defence
     *            Amount of defence the shield blocks.
     */
    public Armor(String name, String description, int defence)
        {
            this.name = name;
            this.defence = defence;
            this.description = description;
        }

        /** Returns description of the shield. */
        public String getDescription()
        {
            return this.description;
        }

        /** Return the name of the shield. */
        public String getName()
        {
            return this.name;
        }

        /** return the amount of defence the shield blocks. */
        public int getDefence()
        {
            return this.defence;
        }
}
