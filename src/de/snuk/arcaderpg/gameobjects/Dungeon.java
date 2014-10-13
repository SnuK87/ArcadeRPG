package de.snuk.arcaderpg.gameobjects;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Dungeon
{

	private final int x;
	private final int y;

	private final Shape shape;

	private final Enemy enemy;

	public Dungeon(final int x, final int y, final Enemy enemy)
	{
		this.x = x;
		this.y = y;

		this.enemy = enemy;

		shape = new Rectangle(x, y, 64, 64);
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public Shape getShape()
	{
		return shape;
	}

	public Enemy getEnemy()
	{
		return enemy;
	}

}
