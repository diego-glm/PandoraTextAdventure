public class Weapon
{
    private String desc;
    private String name;
    private String weapontype;
    private String damagetype;
    private int damage;

    public Weapon(String desc, String name, String weapontype, String damagetype, int damage)
    {
        this.desc = desc;
        this.name = name;
        this.weapontype = weapontype;
        this.damagetype = damagetype;
        this.damage = damage;
    }

    public String getDesc()
    {
        return this.desc;
    }

    public String getName()
    {
        return this.name;
    }

    public int getDamage()
    {
        return this.damage;
    }

    public String getDamagetype()
    {
        return damagetype;
    }

    public String getWeapontype()
    {
        return weapontype;
    }
}