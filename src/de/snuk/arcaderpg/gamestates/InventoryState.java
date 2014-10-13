package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.Constants;

public class InventoryState extends BasicGameState
{

	private Button btnBack;

	@Override
	public void init(final GameContainer container, final StateBasedGame game)
			throws SlickException
	{
		btnBack = new Button("Back", 400, 700, 120, 40);
	}

	@Override
	public void render(final GameContainer container, final StateBasedGame sbg,
			final Graphics g) throws SlickException
	{
		g.drawString("Invetory", 400, 50);

		btnBack.render(g);
	}

	@Override
	public void update(final GameContainer container, final StateBasedGame sbg,
			final int delta) throws SlickException
	{

		final Input input = container.getInput();
		final int mouseX = input.getMouseX();
		final int mouseY = input.getMouseY();

		if (input.isMousePressed(0))
		{
			if (btnBack.isClicked(mouseX, mouseY))
			{
				sbg.enterState(Constants.STATE_WORLD);
			}
		}

	}

	@Override
	public int getID()
	{
		return 6;
	}

}
