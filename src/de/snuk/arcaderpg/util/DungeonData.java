package de.snuk.arcaderpg.util;

public class DungeonData
{

	private static DungeonData instance;

	private DungeonData()
	{

	}

	public static DungeonData getInstance()
	{
		if (instance == null)
		{
			instance = new DungeonData();
		}

		return instance;
	}

}
