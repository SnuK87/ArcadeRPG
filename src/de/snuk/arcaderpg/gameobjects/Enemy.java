package de.snuk.arcaderpg.gameobjects;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import de.snuk.arcaderpg.gameobjects.model.Attributes;

public class Enemy
{
	private final String name;
	// private int x;
	// private int y;

	private final Attributes stats;

	private int currentHp;

	private final int goldLoot;

	private final Shape shape;

	public Enemy(final String name, final Attributes stats, final int gold)
	{
		this.name = name;
		this.stats = stats;
		currentHp = stats.getHp();
		goldLoot = gold;

		shape = new Rectangle(400, 150, 64, 64);
	}

	public int getPhysicalDamange()
	{

		final int dmg = stats.getStrength() / 10;

		return dmg;
	}

	public String getName()
	{
		return name;
	}

	public Shape getShape()
	{
		return shape;
	}

	public Attributes getStats()
	{
		return stats;
	}

	public int getCurrentHp()
	{
		return currentHp;
	}

	public void setCurrentHp(final int currentHp)
	{
		this.currentHp = currentHp;
	}

	public int getGoldLoot()
	{
		return goldLoot;
	}
}
