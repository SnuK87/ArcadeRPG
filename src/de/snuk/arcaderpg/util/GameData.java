package de.snuk.arcaderpg.util;

import java.util.ArrayList;
import java.util.List;

import de.snuk.arcaderpg.gameobjects.Hero;

public class GameData
{
	private static GameData instance;
	private Hero hero;

	private List<String> classes;
	
	private GameData()
	{
		initClasses();
	}

	public static GameData getInstance()
	{
		if (instance == null)
		{
			instance = new GameData();
		}

		return instance;
	}
	
	private void initClasses(){
		classes = new ArrayList<String>();
		classes.add("Warrior");
		classes.add("Mage");
		classes.add("Rogue");
	}

	public List<String> getClasses(){
		return classes;
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
