package template;

import template.beverages.CoffeeWithHook;
import template.beverages.TeaWithHook;

public class BeverageTestDrive
{
	public static void main(String[] args)
	{
		TeaWithHook teaHook = new TeaWithHook();
		CoffeeWithHook coffeeHook = new CoffeeWithHook();

		System.out.println("\nMaking tea...");
		teaHook.prepareRecipe(true);

		System.out.println("\nMaking coffee...");
		coffeeHook.prepareRecipe(true);
	}
}