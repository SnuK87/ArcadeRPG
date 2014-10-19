package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.controller.FightController;
import de.snuk.arcaderpg.gameobjects.Dungeon;
import de.snuk.arcaderpg.gameobjects.Hero;
import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.Constants;
import de.snuk.arcaderpg.util.GameData;
import de.snuk.arcaderpg.util.StaticGameData;

public class DungeonState extends BasicGameState
{

	private final static GameData gameData = GameData.getInstance();
	private final static StaticGameData staticData = StaticGameData
			.getInstance();

	private Button btnAttack;
	private Button btnCast;
	private Button btnRest;

	private FightController fightController;

	private Dungeon dungeon = null;
	private Hero hero;

	private int timeDiff = 0;
	private boolean showDmg = false;

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
		// enemy
		g.drawString(dungeon.getEnemy().getName(), 500, 50);
		g.draw(dungeon.getEnemy().getShape());
		g.drawString("HP: " + dungeon.getEnemy().getCurrentHp(), 600, 100);

		// hero
		hero.renderDungeon(g);
		g.drawString("HP: " + hero.getCurrentHp() + " / "
				+ hero.getStats().getHp(), 800, 500);

		// menu
		if (fightController.isMyTurn())
		{
			btnAttack.render(g);
			btnCast.render(g);
			btnRest.render(g);
		}

		// draw dmg
		drawHeroDmg(g);
		drawEnemyDmg(g);

	}

	@Override
	public void update(final GameContainer container,
			final StateBasedGame game, final int delta) throws SlickException
	{

		if (!fightController.isHeroAlive())
		{
			game.enterState(Constants.STATE_GAMEOVER);
		}

		if (!fightController.isEnemyAlive())
		{
			fightController.win();
			game.enterState(Constants.STATE_WORLD);
		}

		final Input input = container.getInput();
		final int mouseX = input.getMouseX();
		final int mouseY = input.getMouseY();

		if (input.isMousePressed(0))
		{
			if (btnAttack.isClicked(mouseX, mouseY))
			{
				fightController.attackEnemy();
				showDmg = true;
			}
		}

		hero = gameData.getHero();

		if (showDmg)
		{
			timeDiff += delta;
		}

		if (!fightController.isMyTurn() && !showDmg)
		{
			fightController.attackHero();
			showDmg = true;
		}

		if (timeDiff >= 1000)
		{
			if (fightController.isMyTurn())
			{
				fightController.setMyTurn(false);
			} else
			{
				fightController.setMyTurn(true);
			}
			showDmg = false;
			timeDiff = 0;
		}

	}

	@Override
	public int getID()
	{
		return 10;
	}

	private void drawHeroDmg(final Graphics g)
	{
		if (timeDiff < 1000 && showDmg && fightController.isMyTurn())
		{
			g.drawString(Integer.toString(fightController.getLastDmg() * -1),
					dungeon.getEnemy().getShape().getX() + 10, dungeon
							.getEnemy().getShape().getY() + 10);
		}
	}

	private void drawEnemyDmg(final Graphics g)
	{
		if (timeDiff < 1000 && showDmg && !fightController.isMyTurn())
		{
			g.drawString(Integer.toString(fightController.getLastDmg() * -1),
					hero.getxDungeon() + 10, hero.getyDungeon() + 10);

		}
	}

	// public static void setDungeon(final Dungeon d)
	// {
	// dungeon = d;
	//
	// initFight(d.getEnemy());
	//
	// }
	//
	// private static void initFight(final Enemy e)
	// {
	// fightController = new FightController(gameData.getHero(), e);
	// }

	@Override
	public void enter(final GameContainer container, final StateBasedGame game)
	{
		dungeon = staticData.getDungeon(gameData.getCurrentDungeon());
		fightController = new FightController(gameData.getHero(),
				dungeon.getEnemy());

		timeDiff = 0;
		showDmg = false;

	}
}
