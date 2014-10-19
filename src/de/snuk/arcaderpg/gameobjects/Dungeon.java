package de.snuk.arcaderpg.gameobjects;


public class Dungeon
{
	private final Enemy enemy;

	private final String id;

	public Dungeon(final Enemy enemy, final String id)
	{
		this.id = id;

		this.enemy = enemy;
	}

	public Enemy getEnemy()
	{
		return enemy;
	}

	public String getId()
	{
		return id;
	}

}
