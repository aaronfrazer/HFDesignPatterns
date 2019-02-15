package iterator.waitress;

import iterator.Main;
import iterator.menus.Menu;
import iterator.menus.MenuItem;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.Iterator;

import static iterator.Main.makeBranch;

public class Waitress
{
	private Menu pancakeHouseMenu;
	private Menu dinerMenu;
	private Menu cafeMenu;

	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu)
	{
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	public void printMenu()
	{
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();

		TreeItem<String> breakfastMenu, dinerMenu, cafeMenu;
		breakfastMenu = makeBranch("Pancake House Menu", Main.rootItem);
		breakfastMenu.setExpanded(true);
		dinerMenu = makeBranch("Diner Menu", Main.rootItem);
		dinerMenu.setExpanded(true);
		cafeMenu = makeBranch("Cafe Menu", Main.rootItem);
		cafeMenu.setExpanded(true);

		printMenu(pancakeIterator, breakfastMenu);
		printMenu(dinerIterator, dinerMenu);
		printMenu(cafeIterator, cafeMenu);
	}

	private void printMenu(Iterator<MenuItem> iterator, TreeItem<String> menu)
	{
		while (iterator.hasNext())
		{
			MenuItem menuItem = iterator.next();
			String branchTitle = menuItem.getName() + ", " + menuItem.getPrice() + " -- " + menuItem.getDescription();
			makeBranch(branchTitle, menu);
		}
	}

	public void printVegetarianMenu()
	{
		TreeItem<String> vegetarianMenu;
		vegetarianMenu = makeBranch("Vegetarian Menu", Main.rootItem);
		vegetarianMenu.setExpanded(true);

		printVegetarianMenu(pancakeHouseMenu.createIterator(), vegetarianMenu);
		printVegetarianMenu(dinerMenu.createIterator(), vegetarianMenu);
		printVegetarianMenu(cafeMenu.createIterator(), vegetarianMenu);
	}

	public ArrayList<String> getMenuItemNames()
	{
		ArrayList<String> items = new ArrayList<>();

		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();

		while (pancakeIterator.hasNext())
			items.add(pancakeIterator.next().getName());

		while (dinerIterator.hasNext())
			items.add(dinerIterator.next().getName());

		while (cafeIterator.hasNext())
			items.add(cafeIterator.next().getName());

		return items;
	}

	public boolean isItemVegetarian(String name)
	{
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		if (isVegetarian(name, pancakeIterator))
		{
			return true;
		}
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		if (isVegetarian(name, dinerIterator))
		{
			return true;
		}
		Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();

		return isVegetarian(name, cafeIterator);
	}

	private void printVegetarianMenu(Iterator<MenuItem> iterator, TreeItem<String> menu)
	{
		while (iterator.hasNext())
		{
			MenuItem menuItem = iterator.next();
			if (menuItem.isVegetarian())
			{
				String branchTitle = menuItem.getName() + ", " + menuItem.getPrice() + " -- " + menuItem.getDescription();

				makeBranch(branchTitle, menu);
			}
		}
	}

	private boolean isVegetarian(String name, Iterator<MenuItem> iterator)
	{
		while (iterator.hasNext())
		{
			MenuItem menuItem = iterator.next();
			if (menuItem.getName().equals(name))
			{
				if (menuItem.isVegetarian())
				{
					return true;
				}
			}
		}
		return false;
	}
}

