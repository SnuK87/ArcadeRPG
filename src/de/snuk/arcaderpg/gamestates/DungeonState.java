package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gameobjects.Enemy;
import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.GameData;

public class DungeonState extends BasicGameState
{

	private final GameData gameData = GameData.getInstance();

	private final Button btnAttack;
	private final Button btnCast;
	private final Button btnRest;

	private final Enemy enemy;

	public DungeonState(final Enemy e) throws SlickException
	{
		enemy = e;
		System.out.println("miu");
		btnAttack = new Button("Attack", 200, 600, 120, 40);
		btnCast = new Button("Cast", 340, 600, 120, 40);
		btnRest = new Button("Rest", 480, 600, 120, 40);
	}

	@Override
	public void init(final GameContainer container, final StateBasedGame game)
			throws SlickException
	{

	}

	@Override
	public void render(final GameContainer container,
			final StateBasedGame game, final Graphics g) throws SlickException
	{
		g.drawString(enemy.getName(), 500, 50);
		g.draw(enemy.getShape());

		// menu
		btnAttack.render(g);
		btnCast.render(g);
		btnRest.render(g);

	}

	@Override
	public void update(final GameContainer container,
			final StateBasedGame game, final int delta) throws SlickException
	{

	}

	@Override
	public int getID()
	{
		return 10;
	}

}
