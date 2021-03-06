package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import de.snuk.arcaderpg.gameobjects.Hero;
import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.Constants;
import de.snuk.arcaderpg.util.GameData;
import de.snuk.arcaderpg.util.StaticGameData;

public class WorldState extends BasicGameState
{

	private final GameData gameData = GameData.getInstance();
	private final StaticGameData staticData = StaticGameData.getInstance();

	private TiledMap tileMap;
	private Button btnInventory;
	private Button btnMenu;

	private int objectCount = 0;

	@Override
	public void init(final GameContainer container, final StateBasedGame sbg)
			throws SlickException
	{
		tileMap = new TiledMap("res\\world01_test.tmx");

		// final int objectGroupCount = tileMap.getObjectGroupCount();

		objectCount = tileMap.getObjectCount(0);

		// for (int i = 0; i < objectGroupCount; i++)
		// {
		// for (int j = 0; j < tileMap.getObjectCount(i); j++)
		// {
		//
		// System.out.println(tileMap.getObjectName(i, j));
		// System.out.println(tileMap.getObjectType(i, j));
		// }
		// }

		btnInventory = new Button("Inventory", 100, 10,
				Constants.UI_BUTTON_WORLD_WIDTH,
				Constants.UI_BUTTON_WORLD_HEIGHT);
		btnMenu = new Button("Menu", 850, 10, Constants.UI_BUTTON_WORLD_WIDTH,
				Constants.UI_BUTTON_WORLD_HEIGHT);

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
		btnInventory.render(g, container.getInput());
		btnMenu.render(g, container.getInput());

		// draw objects
		hero.renderWorld(g);
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

		final int heroY = hero.getY();
		final int heroX = hero.getX();

		if (input.isKeyPressed(Input.KEY_RIGHT))
		{
			if (tileMap.getTileId(heroX + 1, heroY, pathLayerIndex) != 0)
			{
				hero.setX(heroX + 1);
				gameData.setHero(hero);
			}

			for (int i = 0; i < objectCount; i++)
			{
				final int d1 = tileMap.getObjectX(0, i);
				final int d2 = tileMap.getObjectY(0, i);

				if (((heroX + 1) >= (d1 / 32) && (heroX + 1) <= (d1 / 32) + 1)
						&& (heroY >= (d2 / 32) && heroY <= (d2 / 32) + 1))
				{
					if (staticData.getDungeon(tileMap.getObjectName(0, i))
							.getEnemy().getCurrentHp() > 0)
					{
						gameData.setCurrentDungeon(tileMap.getObjectName(0, i));
						sbg.enterState(Constants.STATE_DUNGEON);

					} else
					{
						System.out.println(tileMap.getObjectName(0, i)
								+ "ist schon besiegt");
					}
				}
			}
		}

		if (input.isKeyPressed(Input.KEY_LEFT))
		{
			if (tileMap.getTileId(heroX - 1, heroY, pathLayerIndex) != 0)
			{
				hero.setX(heroX - 1);
				gameData.setHero(hero);
			}

			// System.out.println("HeroX: " + heroX);
			// System.out.println("HeroY: " + heroY);

			for (int i = 0; i < objectCount; i++)
			{
				final int d1 = tileMap.getObjectX(0, i);
				final int d2 = tileMap.getObjectY(0, i);

				// System.out.println("Object " + i + " : X=" + d1 / 32 + " Y="
				// + d2 / 32 + " w=" + tileMap.getObjectWidth(0, i)
				// + " h=" + tileMap.getObjectHeight(0, i));

				if (((heroX - 1) >= (d1 / 32) && (heroX - 1) <= (d1 / 32) + 1)
						&& (heroY >= (d2 / 32) && heroY <= (d2 / 32) + 1))
				{
					if (staticData.getDungeon(tileMap.getObjectName(0, i))
							.getEnemy().getCurrentHp() > 0)
					{
						gameData.setCurrentDungeon(tileMap.getObjectName(0, i));
						sbg.enterState(Constants.STATE_DUNGEON);

					} else
					{
						System.out.println(tileMap.getObjectName(0, i)
								+ "ist schon besiegt");
					}
				}
			}
		}

		if (input.isKeyPressed(Input.KEY_UP))
		{
			if (tileMap.getTileId(heroX, heroY - 1, pathLayerIndex) != 0)
			{
				hero.setY(heroY - 1);
				gameData.setHero(hero);
			}

			for (int i = 0; i < objectCount; i++)
			{
				final int d1 = tileMap.getObjectX(0, i);
				final int d2 = tileMap.getObjectY(0, i);

				if (((heroY - 1) >= (d2 / 32) && (heroY - 1) <= (d2 / 32) + 1)
						&& (heroX >= (d1 / 32) && heroX <= ((d1 / 32) + 1)))
				{
					if (staticData.getDungeon(tileMap.getObjectName(0, i))
							.getEnemy().getCurrentHp() > 0)
					{
						gameData.setCurrentDungeon(tileMap.getObjectName(0, i));
						sbg.enterState(Constants.STATE_DUNGEON);

					} else
					{
						System.out.println(tileMap.getObjectName(0, i)
								+ "ist schon besiegt");
					}
				}

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
