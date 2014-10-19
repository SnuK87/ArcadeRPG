package de.snuk.arcaderpg.gameobjects;

import java.io.Serializable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import de.snuk.arcaderpg.gameobjects.model.Attributes;
import de.snuk.arcaderpg.util.Constants;

public class Hero implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2011511662065864152L;
	// attributes
	private final String name;
	private final String clazz;
	private Attributes stats;
	private int level;
	private int experience;

	// graphic world
	private final Shape shape;
	private int x; // position in tiles
	private int y; // position in tiles

	// graphic dungeon
	// private final shapeDungeon;
	private int xDungeon;
	private int yDungeon;

	public Hero(final String name, final String clazz, final Attributes stats)
	{
		this.name = name;
		this.clazz = clazz;

		level = 1;
		experience = 0;
		this.stats = stats;

		x = 0;
		y = 9;

		shape = new Rectangle(x * Constants.UI_TILE_SIZE, y
				* Constants.UI_TILE_SIZE, Constants.UI_TILE_SIZE,
				Constants.UI_TILE_SIZE);
	}

	public String getName()
	{
		return name;
	}

	public void renderWorld(final Graphics g)
	{
		if (x >= 32)
		{
			shape.setX((x * Constants.UI_TILE_SIZE) - 1024);
		} else
		{
			shape.setX(x * Constants.UI_TILE_SIZE);
		}

		// scrolling für y achse
		shape.setY(y * Constants.UI_TILE_SIZE);

		g.draw(shape);
	}

	public void renderDungeon(final Graphics g)
	{

		// position depends on how much heroes we have
		xDungeon = 500;
		yDungeon = 550;

		// size ?
		g.drawRect(xDungeon, yDungeon, 32, 32);
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

	public String getClazz()
	{
		return clazz;
	}

	public Attributes getStats()
	{
		return stats;
	}

	public void setStats(final Attributes stats)
	{
		this.stats = stats;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(final int level)
	{
		this.level = level;
	}

	public int getExperience()
	{
		return experience;
	}

	public void setExperience(final int experience)
	{
		this.experience = experience;
	}
}
