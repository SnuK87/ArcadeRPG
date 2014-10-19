package de.snuk.arcaderpg.gameobjects.model;

import java.io.Serializable;

public class BackPack implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1988164756095207699L;
	private int gold;

	public BackPack()
	{
		gold = 0;
	}

	public int getGold()
	{
		return gold;
	}

	public void setGold(final int gold)
	{
		this.gold = gold;
	}
}
