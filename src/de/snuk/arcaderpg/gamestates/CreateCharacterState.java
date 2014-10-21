package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gameobjects.Hero;
import de.snuk.arcaderpg.gameobjects.model.Attributes;
import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.Constants;
import de.snuk.arcaderpg.util.GameData;
import de.snuk.arcaderpg.util.StaticGameData;

public class CreateCharacterState extends BasicGameState
{

	private final GameData gameData = GameData.getInstance();
	private final StaticGameData staticData = StaticGameData.getInstance();

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
		final Image imgRight = new Image("res\\arrowBlue_right.png");
		final Image imgLeft = new Image("res\\arrowBlue_left.png");
		btnOk = new Button("", 500, 400, imgRight);
		btnCancel = new Button("", 400, 400, imgLeft);
		btnNext = new Button("", 500, 350, imgRight);

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
		g.drawString(staticData.getClasses().get(choice), 420, 350);

		btnNext.render(g, container.getInput());
		btnOk.render(g, container.getInput());
		btnCancel.render(g, container.getInput());
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
				final String clazz = staticData.getClasses().get(choice);
				final Attributes stats = staticData.getStatsForClass(clazz);

				final Hero hero = new Hero(tf.getText(), clazz, stats);
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
				if (choice == staticData.getClasses().size() - 1)
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
