package decorator.condiments;

import decorator.beverages.Beverage;

public class Whip extends CondimentDecorator
{
    Beverage beverage;

    private final double baseCost = 0.10;
    private int quantity = 1;

    public Whip(Beverage beverage)
    {
        this.beverage = beverage;
    }

    public String getDescription()
    {
        return beverage.getDescription() + ", Whip";
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
