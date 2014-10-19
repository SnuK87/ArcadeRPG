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

	private final Shape shape;

	public Enemy(final String name, final Attributes stats)
	{
		this.name = name;
		this.stats = stats;

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

	public Attributes getStats()
	{
		return stats;
	}
}
