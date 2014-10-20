package de.snuk.arcaderpg.gameobjects.model;

import java.util.ArrayList;
import java.util.List;

import de.snuk.arcaderpg.gameobjects.model.items.Weapon;

public class Inventory
{

	private Weapon weapon;
	private final List<Item> items;

	public Inventory()
	{
		weapon = new Weapon("Sword", 2, 4);
		items = new ArrayList<>();
		final Helmet helmet = new Helmet("Helmet");
		items.add(helmet);

	}

	public Weapon getWeapon()
	{
		return weapon;
	}

	public void setWeapon(final Weapon weapon)
	{
		this.weapon = weapon;
	}

	public List<Item> getItems()
	{
		return items;
	}
}
