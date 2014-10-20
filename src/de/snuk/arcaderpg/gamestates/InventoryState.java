package de.snuk.arcaderpg.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.snuk.arcaderpg.gameobjects.Hero;
import de.snuk.arcaderpg.gameobjects.model.Attributes;
import de.snuk.arcaderpg.gameobjects.model.Item;
import de.snuk.arcaderpg.gui.elements.Button;
import de.snuk.arcaderpg.util.Constants;
import de.snuk.arcaderpg.util.GameData;

public class InventoryState extends BasicGameState
{

	private final GameData gameData = GameData.getInstance();

	private Button btnBack;

	@Override
	public void init(final GameContainer container, final StateBasedGame game)
			throws SlickException
	{
		btnBack = new Button("Back", 400, 700, 120, 40);
	}

	@Override
	public void render(final GameContainer container, final StateBasedGame sbg,
			final Graphics g) throws SlickException
	{
		g.drawString("Invetory", 400, 50);
		final Hero hero = gameData.getHero();
		final Attributes stats = hero.getStats();

		// draw stats
		g.drawString("Name: " + hero.getName(), 200, 150);
		g.drawString("Class: " + hero.getClazz(), 200, 175);
		g.drawString("Level: " + hero.getLevel(), 200, 200);
		g.drawString("EXP: " + hero.getExperience(), 200, 225);
		g.drawString("HP: " + stats.getHp(), 200, 250);
		g.drawString("MP: " + stats.getMp(), 200, 275);
		g.drawString("Strength: " + stats.getStrength(), 200, 300);
		g.drawString("Dexterity: " + stats.getDexterity(), 200, 325);
		g.drawString("Intelligence: " + stats.getIntelligence(), 200, 350);
		g.drawString("Vitality: " + stats.getVitality(), 200, 375);
		g.drawString("Crit. Chance: " + stats.getCrit_chance() + " %", 200, 400);
		g.drawString("Crit. Damage: " + stats.getCrit_damage() + " %", 200, 425);

		// draw inventory
		g.drawString("Weapon: " + hero.getInventory().getWeapon(), 450, 150);

		int k = 150;

		for (final Item i : hero.getInventory().getItems())
		{
			k += 25;
			g.drawString("Item: " + i.getName(), 450, k);
		}

		// draw backpack
		g.drawString("Gold: " + hero.getBackPack().getGold(), 800, 150);

		btnBack.render(g);
	}

	@Override
	public void update(final GameContainer container, final StateBasedGame sbg,
			final int delta) throws SlickException
	{

		final Input input = container.getInput();
		final int mouseX = input.getMouseX();
		final int mouseY = input.getMouseY();

		if (input.isMousePressed(0))
		{
			if (btnBack.isClicked(mouseX, mouseY))
			{
				sbg.enterState(Constants.STATE_WORLD);
			}
		}

	}

	@Override
	public int getID()
	{
		return 6;
	}

}
