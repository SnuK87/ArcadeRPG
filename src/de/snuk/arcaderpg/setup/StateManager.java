package de.snuk.arcaderpg.setup;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gameobjects.Dungeon;
import de.snuk.arcaderpg.gameobjects.Enemy;
import de.snuk.arcaderpg.gamestates.CreateCharacterState;
import de.snuk.arcaderpg.gamestates.IngameMenu;
import de.snuk.arcaderpg.gamestates.InventoryState;
import de.snuk.arcaderpg.gamestates.StartMenuState;
import de.snuk.arcaderpg.gamestates.WorldState;

public class StateManager extends StateBasedGame
{

	public static List<Dungeon> dungeons;

	public StateManager(final String name)
	{
		super(name);

		initDungeons();

	}

	@Override
	public void initStatesList(final GameContainer arg0) throws SlickException
	{
		addState(new StartMenuState());
		addState(new CreateCharacterState());
		addState(new WorldState());
		addState(new InventoryState());
		addState(new IngameMenu());
	}

	private void initDungeons()
	{
		dungeons = new ArrayList<>();

		final Enemy enemy = new Enemy("Hans", 100, 0);
		final Dungeon dungeon = new Dungeon(4 * 32, 3 * 32, enemy);

		final Enemy enemy2 = new Enemy("Peter", 200, 0);
		final Dungeon dungeon2 = new Dungeon(8 * 32, 16 * 32, enemy2);

		dungeons.add(dungeon);
		dungeons.add(dungeon2);
	}
}
