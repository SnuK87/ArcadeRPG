package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.Constants;

public class IngameMenu extends BasicGameState
{

	Button btnSave;
	Button btnLoad;
	Button btnSettings;
	Button btnExit;
	Button btnBack;

	@Override
	public void init(final GameContainer container, final StateBasedGame sbg)
			throws SlickException
	{
		btnSave = new Button("Save", 400, 350, 120, 40);
		btnLoad = new Button("Load", 400, 250, 120, 40);
		btnSettings = new Button("Settings", 400, 300, 120, 40);
		btnExit = new Button("Exit", 400, 200, 120, 40);
		btnBack = new Button("Back", 400, 400, 120, 40);

	}

	@Override
	public void render(final GameContainer container, final StateBasedGame sbg,
			final Graphics g) throws SlickException
	{

		btnSave.render(g);
		btnLoad.render(g);
		btnSettings.render(g);
		btnExit.render(g);
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
			if (btnSave.isClicked(mouseX, mouseY))
			{

			}
			if (btnLoad.isClicked(mouseX, mouseY))
			{

			}
			if (btnSettings.isClicked(mouseX, mouseY))
			{

			}
			if (btnExit.isClicked(mouseX, mouseY))
			{
				sbg.enterState(Constants.STATE_STARTMENU,
						new FadeOutTransition(), new FadeInTransition());
			}
			if (btnBack.isClicked(mouseX, mouseY))
			{
				sbg.enterState(Constants.STATE_WORLD);
			}
		}
	}

	@Override
	public int getID()
	{
		// TODO Auto-generated method stub
		return 7;
	}

}
