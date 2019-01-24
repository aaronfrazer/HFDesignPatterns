package template.beverages;

import static template.Main.*;

public abstract class CaffeineBeverage
{
	public final void prepareRecipe(String beverageName, boolean condiments)
	{
		System.out.println("--- Preparing " + beverageName + " Recipe ---");
		boilWater();
		brew();
		pourInCup();
		if (condiments)
		{
			addCondiments();
		}
	}

	protected abstract void brew();

	protected abstract void addCondiments();

	public abstract String toString();

	private void boilWater()
	{
		// Play boiling water animation
		boilTimeline.play();
	}

	private void pourInCup()
	{
		// Play pour animation
		pourTimeline.play();
	}
}