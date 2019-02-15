package composite.waitress;

import composite.Main;
import composite.menus.MenuComponent;
import javafx.scene.control.TreeItem;

import java.util.Iterator;

import static composite.Main.makeBranch;

public class Waitress
{
    private MenuComponent allMenus;

    public Waitress(MenuComponent allMenus)
    {
        this.allMenus = allMenus;
    }

    public void printMenu()
    {
        allMenus.print(null);
    }

    public void printVegetarianMenu()
    {
        Iterator<MenuComponent> iterator = allMenus.createIterator();

        TreeItem<String> vegetarianMenu;
        vegetarianMenu = makeBranch("VEGETARIAN MENU", Main.rootItem);
        vegetarianMenu.setExpanded(true);
        while (iterator.hasNext())
        {
            MenuComponent menuComponent = iterator.next();
            try
            {
                if (menuComponent.isVegetarian())
                {
                    String branchTitle = menuComponent.getName() + ", " + menuComponent.getPrice() + " -- " + menuComponent.getDescription();
                    makeBranch(branchTitle, vegetarianMenu);
                }
            } catch (UnsupportedOperationException e)
            {
//                throw new UnsupportedOperationException();
            }
        }
    }
}
