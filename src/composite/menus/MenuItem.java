package composite.menus;

import composite.iterators.NullIterator;
import javafx.scene.control.TreeItem;

import java.util.Iterator;

import static composite.Main.makeBranch;

public class MenuItem extends MenuComponent
{
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price)
    {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public double getPrice()
    {
        return price;
    }

    public boolean isVegetarian()
    {
        return vegetarian;
    }

    public Iterator<MenuComponent> createIterator()
    {
        return new NullIterator();
    }

    public void print(TreeItem<String> parentItem)
    {
        String itemName = " " + getName();
        if (isVegetarian())
            itemName += "(v)";
        itemName += ", " + getPrice() + "     -- " + getDescription();
        makeBranch(itemName, parentItem);
    }
}

