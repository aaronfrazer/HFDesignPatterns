package template.beverages;

public abstract class CaffeineBeverageWithHook
{
	public final void prepareRecipe(boolean condiments)
	{
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
		System.out.println("Boiling water");
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