package de.snuk.arcaderpg.setup;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class StartUp
{
	public static void main(final String[] args)
	{
		try
		{
			final AppGameContainer app = new AppGameContainer(new StateManager(
					"ArcadeRPG"));
			app.setDisplayMode(1024, 768, true);
			app.setAlwaysRender(true);
			app.setTargetFrameRate(90);
			// app.setVSync(true);
			app.start();
		} catch (final SlickException e)
		{
			e.printStackTrace();
		}
	}
}
