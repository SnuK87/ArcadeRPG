package de.snuk.arcaderpg.util;

import java.util.ArrayList;
import java.util.List;

import de.snuk.arcaderpg.gameobjects.Dungeon;
import de.snuk.arcaderpg.gameobjects.Enemy;
import de.snuk.arcaderpg.gameobjects.model.Attributes;

public class StaticGameData
{
	private List<String> classes;
	private static StaticGameData instance;

	private static List<Dungeon> dungeons;

	private StaticGameData()
	{
		initClasses();
		initDungeons();
	}

	public static StaticGameData getInstance()
	{
		if (instance == null)
		{
			instance = new StaticGameData();
		}

		return instance;
	}

	public Dungeon getDungeon(final String name)
	{

		Dungeon dungeon = null;

		for (final Dungeon d : dungeons)
		{
			if (d.getId().equals(name))
			{
				dungeon = d;
			}
		}

		return dungeon;
	}

	public static List<Dungeon> getDungeons()
	{

		return dungeons;
	}

	private void initDungeons()
	{
		dungeons = new ArrayList<Dungeon>();

		final Attributes stats = new Attributes();
		stats.setHp(100);
		stats.setMp(0);
		stats.setStrength(25);
		stats.setIntelligence(10);
		stats.setDexterity(10);
		stats.setVitality(20);
		stats.setCrit_chance(0);
		stats.setCrit_damage(0);

		final Enemy boss = new Enemy("Klaus", stats, 10);
		final Dungeon dungeon = new Dungeon(boss, "level1");
		dungeons.add(dungeon);

		final Enemy boss2 = new Enemy("Gerd", stats, 12);
		final Dungeon dungeon2 = new Dungeon(boss2, "level2");
		dungeons.add(dungeon2);

		final Enemy boss3 = new Enemy("Peter", stats, 15);
		final Dungeon dungeon3 = new Dungeon(boss3, "level3");
		dungeons.add(dungeon3);
	}

	private void initClasses()
	{
		classes = new ArrayList<String>();
		classes.add("Warrior");
		classes.add("Mage");
		classes.add("Rogue");
	}

	public List<String> getClasses()
	{
		return classes;
	}

	public Attributes getStatsForClass(final String clazz)
	{
		final Attributes stats = new Attributes();

		switch (clazz)
		{
		case "Warrior":
			stats.setHp(100);
			stats.setMp(10);
			stats.setStrength(20);
			stats.setIntelligence(5);
			stats.setDexterity(5);
			stats.setVitality(15);
			stats.setCrit_chance(5.0);
			stats.setCrit_damage(50);
			break;

		case "Mage":
			break;

		case "Rogue":
			break;
		}

		return stats;
	}

	public Attributes getStatsForBoss()
	{

		return null;
	}

}
