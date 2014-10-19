package de.snuk.arcaderpg.setup;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gamestates.CreateCharacterState;
import de.snuk.arcaderpg.gamestates.DungeonState;
import de.snuk.arcaderpg.gamestates.IngameMenu;
import de.snuk.arcaderpg.gamestates.InventoryState;
import de.snuk.arcaderpg.gamestates.StartMenuState;
import de.snuk.arcaderpg.gamestates.WorldState;

public class StateManager extends StateBasedGame
{

	public StateManager(final String name)
	{
		super(name);

	}

	@Override
	public void initStatesList(final GameContainer arg0) throws SlickException
	{
		addState(new StartMenuState());
		addState(new CreateCharacterState());
		addState(new WorldState());
		addState(new InventoryState());
		addState(new IngameMenu());
		addState(new DungeonState());
	}
}
