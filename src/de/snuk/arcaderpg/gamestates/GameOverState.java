package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState
{

	@Override
	public void init(final GameContainer container, final StateBasedGame game)
			throws SlickException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(final GameContainer container,
			final StateBasedGame game, final Graphics g) throws SlickException
	{
		g.drawString("GAME OVER!", 500, 500);

	}

	@Override
	public void update(final GameContainer container,
			final StateBasedGame game, final int delta) throws SlickException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public int getID()
	{
		return 15;
	}

}
