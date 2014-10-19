package de.snuk.arcaderpg.gameobjects.model;

import de.snuk.arcaderpg.gameobjects.model.items.Weapon;

public class Inventory
{

	private Weapon weapon;

	public Inventory()
	{
		weapon = new Weapon(2, 4);
	}

	public Weapon getWeapon()
	{
		return weapon;
	}

	public void setWeapon(final Weapon weapon)
	{
		this.weapon = weapon;
	}
}
