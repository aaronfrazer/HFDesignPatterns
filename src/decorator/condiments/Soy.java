package decorator.condiments;

import decorator.beverages.Beverage;

public class Soy extends CondimentDecorator
{
    Beverage beverage;

    private final double baseCost = 0.15;
    private int quantity = 1;

    public Soy(Beverage beverage)
    {
        this.beverage = beverage;
    }

    public String getDescription()
    {
        return beverage.getDescription() + ", Soy";
    }

    public double getCost()
    {
        double cost = baseCost + beverage.getCost();
        return Math.round(cost * 100.0) / 100.0;
    }

    public int getQuantity()
    {
        return quantity;
    }
}