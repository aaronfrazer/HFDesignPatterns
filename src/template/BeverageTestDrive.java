package template;

import template.beverages.Coffee;
import template.beverages.Tea;

public class BeverageTestDrive
{
	public static void main(String[] args)
	{
		Tea teaHook = new Tea();
		Coffee coffeeHook = new Coffee();

		System.out.println("\nMaking tea...");
		teaHook.prepareRecipe(true);

		System.out.println("\nMaking coffee...");
		coffeeHook.prepareRecipe(true);
	}
}