package de.snuk.arcaderpg.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.snuk.arcaderpg.gameobjects.Hero;

public class GameData
{
	private static GameData instance;
	private Hero hero;

	private String currentDungeon;

	// private int dungeonsCompleted;

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

	public String getCurrentDungeon()
	{
		return currentDungeon;
	}

	public void setCurrentDungeon(final String currentDungeon)
	{
		this.currentDungeon = currentDungeon;
	}

	public void serializeHero()
	{
		try
		{
			final FileOutputStream fos = new FileOutputStream(
					"C:\\test\\savegame.dat");
			final ObjectOutputStream ous = new ObjectOutputStream(fos);
			ous.writeObject(hero);
			ous.close();
		} catch (final Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deserializeHero()
	{
		try
		{
			final FileInputStream fis = new FileInputStream(
					"C:\\test\\savegame.dat");

			final ObjectInputStream ois = new ObjectInputStream(fis);

			hero = (Hero) ois.readObject();

			fis.close();
		} catch (final IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
