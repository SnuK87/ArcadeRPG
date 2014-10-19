package de.snuk.arcaderpg.gameobjects.model.items;

public class Weapon
{
	private final int dmgFrom;
	private final int dmgTo;

	public Weapon(final int dmgfrom, final int dmgto)
	{
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
}
