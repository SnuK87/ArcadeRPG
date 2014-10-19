package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gameobjects.Dungeon;
import de.snuk.arcaderpg.gameobjects.Hero;
import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.GameData;

public class DungeonState extends BasicGameState
{

	private final GameData gameData = GameData.getInstance();

	private Button btnAttack;
	private Button btnCast;
	private Button btnRest;

	private static Dungeon dungeon = null;

	public DungeonState() throws SlickException
	{

	}

	@Override
	public void init(final GameContainer container, final StateBasedGame game)
			throws SlickException
	{
		btnAttack = new Button("Attack", 200, 650, 120, 40);
		btnCast = new Button("Cast", 340, 650, 120, 40);
		btnRest = new Button("Rest", 480, 650, 120, 40);
	}

	@Override
	public void render(final GameContainer container,
			final StateBasedGame game, final Graphics g) throws SlickException
	{
		final Hero hero = gameData.getHero();

		// enemy
		g.drawString(dungeon.getEnemy().getName(), 500, 50);
		g.draw(dungeon.getEnemy().getShape());

		// hero
		hero.renderDungeon(g);

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

	public static void setDungeon(final Dungeon d)
	{
		dungeon = d;
	}

}
