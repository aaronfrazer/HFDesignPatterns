package template.beverages;

import static template.Main.*;

public abstract class CaffeineBeverage
{
	public final void prepareRecipe(boolean condiments)
	{
		System.out.println("Preparing recipe");
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

	void boilWater()
	{
		// Play boiling water animation
		System.out.println("Boiling Water...");
		boilWaterImageView.setVisible(true);
		numBeveragesBeingBoiled++;
		beverageBoilAmount.setText("x" + numBeveragesBeingBoiled);
	}

	void pourInCup()
	{
		System.out.println("Pouring into cup");
	}

	boolean customerWantsCondiments()
	{
		return true;
	}
}