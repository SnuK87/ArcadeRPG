package de.snuk.arcaderpg.gameobjects.model;

import java.io.Serializable;

public class Attributes implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5835013999181818541L;
	private int hp;
	private int mp;
	private int strength;
	private int intelligence;
	private int dexterity;
	private int vitality;

	private int crit_damage;
	private double crit_chance;

	public Attributes()
	{

	}

	public int getHp()
	{
		return hp;
	}

	public void setHp(final int hp)
	{
		this.hp = hp;
	}

	public int getMp()
	{
		return mp;
	}

	public void setMp(final int mp)
	{
		this.mp = mp;
	}

	public int getStrength()
	{
		return strength;
	}

	public void setStrength(final int strength)
	{
		this.strength = strength;
	}

	public int getIntelligence()
	{
		return intelligence;
	}

	public void setIntelligence(final int intelligence)
	{
		this.intelligence = intelligence;
	}

	public int getDexterity()
	{
		return dexterity;
	}

	public void setDexterity(final int dexterity)
	{
		this.dexterity = dexterity;
	}

	public int getVitality()
	{
		return vitality;
	}

	public void setVitality(final int vitality)
	{
		this.vitality = vitality;
	}

	public int getCrit_damage()
	{
		return crit_damage;
	}

	public void setCrit_damage(final int crit_damage)
	{
		this.crit_damage = crit_damage;
	}

	public double getCrit_chance()
	{
		return crit_chance;
	}

	public void setCrit_chance(final double crit_chance)
	{
		this.crit_chance = crit_chance;
	}
}
