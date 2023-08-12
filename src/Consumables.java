public class Consumables
{
    private String desc; //item description
    private String name; //item name
    private String bufftype; //bufftype (hp/def/att increase)
    private String debufftype; //bufftype (hp/def/att increase)
    private int buff; //value that is increased
    private int debuff; //value that is decreased

    public Consumables(String desc, String name, String bufftype, String debufftype, int buff, int debuff)
    {
        this.desc = desc;
        this.name = name;
        this.bufftype = bufftype;
        this.debufftype = debufftype;
        this.buff = buff;
        this.debuff = debuff;
    }

    public int getBuff()
    {
        return buff;
    }

    public int getDebuff()
    {
        return debuff;
    }

    public String getBufftype()
    {
        return bufftype;
    }

    public String getDesc()
    {
        return desc;
    }

    public String getName()
    {
        return name;
    }

    public String getDebufftype()
    {
        return debufftype;
    }

}

