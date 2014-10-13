package de.snuk.arcaderpg.util;

import de.snuk.arcaderpg.gameobjects.Hero;

public class GameData
{
	private static GameData instance;
	private Hero hero;

	private GameData()
	{

	}

	public static GameData getInstance()
	{
		if (instance == null)
		{
			instance = new GameData();
		}

		return instance;
	}

	public Hero getHero()
	{
		return hero;
	}

	public void setHero(final Hero hero)
	{
		this.hero = hero;
	}

}
