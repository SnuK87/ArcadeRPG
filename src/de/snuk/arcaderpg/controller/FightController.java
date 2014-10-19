package de.snuk.arcaderpg.controller;

import de.snuk.arcaderpg.gameobjects.Enemy;
import de.snuk.arcaderpg.gameobjects.Hero;

public class FightController
{

	private final Hero hero;
	private final Enemy enemy;

	private boolean myTurn = true;

	private int lastDmg;

	public FightController(final Hero hero, final Enemy enemy)
	{
		this.hero = hero;
		this.enemy = enemy;
	}

	public void attackEnemy(/* target */)
	{
		// berechne phsys. angriffskraft
		lastDmg = (hero.getStats().getStrength() / 10)
				* hero.getInventory().getWeapon().getMidDmg();

		// ziehe enemy leben ab
		enemy.setCurrentHp(enemy.getCurrentHp() - lastDmg);
	}

	public void attackHero(/* target */)
	{
		lastDmg = enemy.getPhysicalDamange();

		hero.setCurrentHp(hero.getCurrentHp() - lastDmg);
	}

	public int getLastDmg()
	{
		return lastDmg;
	}

	public boolean isMyTurn()
	{
		return myTurn;
	}

	public void setMyTurn(final boolean myTurn)
	{
		this.myTurn = myTurn;
	}

	public boolean isHeroAlive()
	{
		boolean alive = true;

		if (hero.getCurrentHp() <= 0)
		{
			alive = false;
		}

		return alive;
	}

	public boolean isEnemyAlive()
	{
		boolean alive = true;

		if (enemy.getCurrentHp() <= 0)
		{
			alive = false;
		}

		return alive;
	}

	public void win()
	{
		// give hero loot
		hero.getBackPack().setGold(
				hero.getBackPack().getGold() + enemy.getGoldLoot());
	}

}
