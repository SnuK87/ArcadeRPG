package de.snuk.arcaderpg.gui.elements;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Button
{

	private final String text;
	private final float width;
	private final float height;
	private final float x;
	private final float y;
	private final Shape shape;

	public Button(final String text, final float x, final float y,
			final float width, final float height) throws SlickException
	{
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		shape = new Rectangle(x, y, width, height);
	}

	public void render(final Graphics g) throws SlickException
	{
		g.setColor(Color.cyan);
		g.drawString(text, (x + width / 2) - text.length() * 5, y
				+ (height / 4));
		g.drawRect(x, y, width, height);

	}

	public void update(final GameContainer container, final StateBasedGame sbg,
			final int delta)
	{

	}

	public boolean isClicked(final int x, final int y)
	{
		boolean isClicked = false;
		final Point p = new Point(x, y);

		if (shape.intersects(p) || shape.contains(p))
		{
			isClicked = true;
		}

		return isClicked;
	}

	public Shape getShape()
	{

		return shape;
	}

}
