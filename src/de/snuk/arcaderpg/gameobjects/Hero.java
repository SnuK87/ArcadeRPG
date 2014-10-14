package de.snuk.arcaderpg.gameobjects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import de.snuk.arcaderpg.util.Constants;

public class Hero
{

	private final String name;
	private String clazz;
	private int hp;
	private int mp;

	// graphic world
	private final Shape shape;
	private int x; // position in tiles
	private int y; // position in tiles
	
	//graphic dungeon
//	private final shapeDungeon;
	private int xDungeon;
	private int yDungeon;

	public Hero(final String name, String clazz)
	{
		this.name = name;
		this.clazz = clazz;
		
		x = 0;
		y = 9;

		shape = new Rectangle(x * Constants.UI_TILE_SIZE, y * Constants.UI_TILE_SIZE, Constants.UI_TILE_SIZE, Constants.UI_TILE_SIZE);
	}

	public String getName()
	{
		return name;
	}

	public void renderWorld(Graphics g){
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

	
	public void renderDungeon(Graphics g){
		
		//position depends on how much heroes we have
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

	public String getClazz() {
		return clazz;
	}
}
