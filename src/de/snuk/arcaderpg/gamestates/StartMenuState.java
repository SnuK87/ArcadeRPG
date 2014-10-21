package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.Constants;
import de.snuk.arcaderpg.util.GameData;

public class StartMenuState extends BasicGameState
{

	private final GameData gameData = GameData.getInstance();

	private Button btnStart;
	private Button btnLoadGame;
	private Button btnOptions;
	private Button btnExit;

	@Override
	public void init(final GameContainer container, final StateBasedGame sbg)
			throws SlickException
	{
		btnStart = new Button("Start Game", container.getWidth() / 2
				- (Constants.UI_BUTTON_MENU_WIDTH / 2), 200,
				Constants.UI_BUTTON_MENU_WIDTH, Constants.UI_BUTTON_MENU_HEIGHT);
		btnLoadGame = new Button("Load Game", container.getWidth() / 2
				- (Constants.UI_BUTTON_MENU_WIDTH / 2), 275,
				Constants.UI_BUTTON_MENU_WIDTH, Constants.UI_BUTTON_MENU_HEIGHT);
		btnOptions = new Button("Options", container.getWidth() / 2
				- (Constants.UI_BUTTON_MENU_WIDTH / 2), 350,
				Constants.UI_BUTTON_MENU_WIDTH, Constants.UI_BUTTON_MENU_HEIGHT);
		btnExit = new Button("Exit", container.getWidth() / 2
				- (Constants.UI_BUTTON_MENU_WIDTH / 2), 425,
				Constants.UI_BUTTON_MENU_WIDTH, Constants.UI_BUTTON_MENU_HEIGHT);

	}

	@Override
	public void render(final GameContainer container, final StateBasedGame sbg,
			final Graphics g) throws SlickException
	{		
		btnStart.render(g, container.getInput());
		btnLoadGame.render(g, container.getInput());
		btnOptions.render(g, container.getInput());
		btnExit.render(g, container.getInput());
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
				gameData.deserializeHero();
				sbg.enterState(Constants.STATE_WORLD);
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
