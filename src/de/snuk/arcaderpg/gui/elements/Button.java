package de.snuk.arcaderpg.gui.elements;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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

	private final Image image;

	public Button(final String text, final float x, final float y,
			final float width, final float height) throws SlickException
	{
		this.text = text;
		this.x = x;
		this.y = y;

		image = new Image("res\\button.png");

		this.width = image.getWidth();
		this.height = image.getHeight();

		shape = new Rectangle(x, y, this.width, this.height);
	}

	public Button(final String text, final float x, final float y,
			final Image image) throws SlickException
	{
		this.text = text;
		this.x = x;
		this.y = y;

		this.image = image;

		width = image.getWidth();
		height = image.getHeight();

		shape = new Rectangle(x, y, width, height);
	}

	public void render(final Graphics g) throws SlickException
	{
		g.drawImage(image, x, y);
		g.setColor(Color.white);
		g.drawString(text, (x + width / 2) - text.length() * 5, y
				+ (height / 4));
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
