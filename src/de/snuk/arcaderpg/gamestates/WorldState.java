package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import de.snuk.arcaderpg.gameobjects.Dungeon;
import de.snuk.arcaderpg.gameobjects.Hero;
import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.setup.StateManager;
import de.snuk.arcaderpg.util.Constants;
import de.snuk.arcaderpg.util.GameData;

public class WorldState extends BasicGameState
{

	private final GameData gameData = GameData.getInstance();

	private TiledMap tileMap;
	private Button btnInventory;
	private Button btnMenu;

	@Override
	public void init(final GameContainer container, final StateBasedGame sbg)
			throws SlickException
	{
		tileMap = new TiledMap("res\\world01.tmx");

		btnInventory = new Button("Inventory", 100, 10, 120, 20);
		btnMenu = new Button("Menu", 850, 10, 120, 20);

	}

	@Override
	public void render(final GameContainer container, final StateBasedGame sbg,
			final Graphics g) throws SlickException
	{
		final Hero hero = gameData.getHero();
		// scroll and render map
		final int heroX = hero.getX();

		switch (heroX / 32)
		{
		case 0:
			tileMap.render(0, 0);
			break;
		case 1:
			tileMap.render(-1024, 0);
			break;
		case 2:
			tileMap.render(-2048, 0);
			break;
		}

		// menu
		btnInventory.render(g);
		btnMenu.render(g);

		// draw objects
		g.fill(hero.getShape());
	}

	@Override
	public void update(final GameContainer container, final StateBasedGame sbg,
			final int delta) throws SlickException
	{
		final Input input = container.getInput();
		final int mouseX = input.getMouseX();
		final int mouseY = input.getMouseY();

		/*
		 * menu listener
		 */
		if (input.isMousePressed(0))
		{
			if (btnInventory.isClicked(mouseX, mouseY))
			{
				sbg.enterState(Constants.STATE_INVETORY);
			}

			if (btnMenu.isClicked(mouseX, mouseY))
			{
				sbg.enterState(Constants.STATE_INGAMEMENU);
			}
		}

		/*
		 * Movement
		 */

		final Hero hero = gameData.getHero();

		final int pathLayerIndex = tileMap.getLayerIndex("path");
		final int levelLayerIndex = tileMap.getLayerIndex("level");

		final int heroY = hero.getY();
		final int heroX = hero.getX();

		if (input.isKeyPressed(Input.KEY_RIGHT))
		{
			if (tileMap.getTileId(heroX + 1, heroY, pathLayerIndex) != 0)
			{
				hero.setX(heroX + 1);
				gameData.setHero(hero);
			}
		}

		if (input.isKeyPressed(Input.KEY_LEFT))
		{
			if (tileMap.getTileId(heroX - 1, heroY, pathLayerIndex) != 0)
			{
				hero.setX(heroX - 1);
				gameData.setHero(hero);
			}

			if (tileMap.getTileId(heroX - 1, heroY, levelLayerIndex) != 0)
			{
				for (final Dungeon d : StateManager.dungeons)
				{
					if (d.getShape().includes(heroX * 32, heroY * 32))
					{
						sbg.addState(new DungeonState(d.getEnemy()));
						sbg.enterState(Constants.STATE_DUNGEON);
					}
				}

				System.out.println(tileMap.getTileId(4, 4, levelLayerIndex));
				System.out.println("StartFight!");
			}
		}

		if (input.isKeyPressed(Input.KEY_UP))
		{
			if (tileMap.getTileId(heroX, heroY - 1, pathLayerIndex) != 0)
			{
				hero.setY(heroY - 1);
				gameData.setHero(hero);
			}

			if (tileMap.getTileId(heroX, heroY - 1, levelLayerIndex) != 0)
			{
				for (final Dungeon d : StateManager.dungeons)
				{
					if (d.getShape().includes(heroX * 32, heroY * 32))
					{
						sbg.addState(new DungeonState(d.getEnemy()));
						sbg.enterState(Constants.STATE_DUNGEON);
					}
				}

				System.out.println(tileMap.getTileId(4, 4, levelLayerIndex));
				System.out.println("StartFight!");
			}
		}
		if (input.isKeyPressed(Input.KEY_DOWN))
		{
			if (tileMap.getTileId(heroX, heroY + 1, pathLayerIndex) != 0)
			{
				hero.setY(heroY + 1);
				gameData.setHero(hero);
			}
		}
	}

	@Override
	public int getID()
	{
		return 5;
	}
}
