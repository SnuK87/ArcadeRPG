package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.Constants;

public class StartMenuState extends BasicGameState
{

	private Button btnStart;
	private Button btnLoadGame;
	private Button btnOptions;
	private Button btnExit;

	@Override
	public void init(final GameContainer container, final StateBasedGame sbg)
			throws SlickException
	{
		btnStart = new Button("Start Game", container.getWidth() / 2 - 60, 200,
				120, 40);
		btnLoadGame = new Button("Load Game", container.getWidth() / 2 - 60,
				250, 120, 40);
		btnOptions = new Button("Options", container.getWidth() / 2 - 60, 300,
				120, 40);
		btnExit = new Button("Exit", container.getWidth() / 2 - 60, 350, 120,
				40);

	}

	@Override
	public void render(final GameContainer container, final StateBasedGame sbg,
			final Graphics g) throws SlickException
	{
		btnStart.render(g);
		btnLoadGame.render(g);
		btnOptions.render(g);
		btnExit.render(g);
	}

	@Override
	public void update(final GameContainer container, final StateBasedGame sbg,
			final int delta) throws SlickException
	{
		final Input input = container.getInput();
		final int mouseX = input.getMouseX();
		final int mouseY = input.getMouseY();

		if (input.isMouseButtonDown(0))
		{
			if (btnStart.isClicked(mouseX, mouseY))
			{
				sbg.enterState(Constants.STATE_CREATECHAR);
			}

			if (btnLoadGame.isClicked(mouseX, mouseY))
			{
				// t0d0
			}

			if (btnOptions.isClicked(mouseX, mouseY))
			{
				// t0d0
			}

			if (btnExit.isClicked(mouseX, mouseY))
			{
				container.exit();
			}
		}
	}

	@Override
	public int getID()
	{
		return 1;
	}

}
