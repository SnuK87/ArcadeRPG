package de.snuk.arcaderpg.gamestates;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gameobjects.Hero;
import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.Constants;
import de.snuk.arcaderpg.util.GameData;

public class CreateCharacterState extends BasicGameState
{

	private final GameData gameData = GameData.getInstance();

	private TextField tf;
	private Button btnOk;
	private Button btnCancel;
	private Button btnNext;

	private int choice;

	public CreateCharacterState()
	{

	}

	@Override
	public void init(final GameContainer container, final StateBasedGame sbg)
			throws SlickException
	{
		choice = 0;


		tf = new TextField(container, container.getDefaultFont(), 400, 300,
				150, 20);
		btnOk = new Button("Ok", 400, 400, 40, 20);
		btnCancel = new Button("Cancel", 500, 400, 40, 20);
		btnNext = new Button("->", 500, 350, 20, 20);

	}

	@Override
	public void render(final GameContainer container, final StateBasedGame sbg,
			final Graphics g) throws SlickException
	{
		g.drawString("Name: ", 350, 300);
		g.drawRect(400, 300, 150, 20);
		tf.render(container, g);
		tf.setFocus(true);

		g.drawString("Class: ", 350, 350);
		g.drawString(gameData.getClasses().get(choice), 420, 350);
		
		

		btnNext.render(g);
		btnOk.render(g);
		btnCancel.render(g);
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
			if (btnOk.isClicked(mouseX, mouseY))
			{
				final Hero hero = new Hero(tf.getText(), gameData.getClasses().get(choice));
				gameData.setHero(hero);
				tf.setText("");
				sbg.enterState(Constants.STATE_WORLD);
			}

			if (btnCancel.isClicked(mouseX, mouseY))
			{
				tf.setText("");
				choice = 0;
				sbg.enterState(Constants.STATE_STARTMENU);

			}

			if (btnNext.isClicked(mouseX, mouseY))
			{
				if (choice == gameData.getClasses().size() - 1)
				{
					choice = 0;
				} else
				{
					choice++;
				}
			}
		}
	}

	@Override
	public int getID()
	{
		return 2;
	}
}
