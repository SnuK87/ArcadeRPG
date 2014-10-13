package de.snuk.arcaderpg.gameobjects;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Enemy
{
	private final String name;
	private int x;
	private int y;

	private final int hp;
	private final int mp;

	private final Shape shape;

	public Enemy(final String name, final int hp, final int mp)
	{
		this.name = name;
		this.hp = hp;
		this.mp = mp;

		shape = new Rectangle(400, 150, 64, 64);
	}

	public String getName()
	{
		return name;
	}

	public Shape getShape()
	{
		return shape;
	}

}
