package de.snuk.arcaderpg.gameobjects.model;

public class Helmet extends Item
{

	public Helmet(final String name)
	{
		super(name);

	}

	@Override
	public String toString()
	{
		return getName();
	}

}
