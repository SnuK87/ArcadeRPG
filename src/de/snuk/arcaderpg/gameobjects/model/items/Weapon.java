package de.snuk.arcaderpg.gameobjects.model.items;

public class Weapon
{
	private final String name;
	private final int dmgFrom;
	private final int dmgTo;

	public Weapon(final String name, final int dmgfrom, final int dmgto)
	{
		this.name = name;
		dmgFrom = dmgfrom;
		dmgTo = dmgto;
	}

	public int getDmgFrom()
	{
		return dmgFrom;
	}

	public int getDmgTo()
	{
		return dmgTo;
	}

	public int getMidDmg()
	{
		return (dmgFrom + dmgTo) / 2;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return name + " (" + dmgFrom + " - " + dmgTo + ")";
	}
}
