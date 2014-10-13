package de.snuk.arcaderpg.gameobjects;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Hero
{

	private final String name;
	private int hp;
	private int mp;

	// graphic
	private final Shape shape;
	private int x;
	private int y;

	public Hero(final String name)
	{
		this.name = name;

		x = 0;
		y = 9;

		shape = new Rectangle(x * 32, y * 32, 32, 32);
	}

	public String getName()
	{
		return name;
	}

	public Shape getShape()
	{
		if (x >= 32)
		{
			shape.setX((x * 32) - 1024);
		} else
		{
			shape.setX(x * 32);
		}
		shape.setY(y * 32);
		return shape;
	}

	public int getX()
	{
		return x;
	}

	public void setX(final int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(final int y)
	{
		this.y = y;
	}
}
