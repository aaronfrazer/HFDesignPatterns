package composite.menus;

import composite.Main;
import composite.iterators.CompositeIterator;
import javafx.scene.control.TreeItem;

import java.util.Iterator;
import java.util.ArrayList;

import static composite.Main.makeBranch;

public class Menu extends MenuComponent
{
    private Iterator<MenuComponent> iterator = null;
    private ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent)
    {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent)
    {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i)
    {
        return menuComponents.get(i);
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public Iterator<MenuComponent> createIterator()
    {
        if (iterator == null)
        {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }

    public void print(TreeItem<String> parentItem)
    {
        TreeItem<String> parent = makeBranch(getName(), Main.rootItem);
        Iterator<MenuComponent> iterator = menuComponents.iterator();

        for (; iterator.hasNext(); )
        {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print(parent);
        }
    }
}