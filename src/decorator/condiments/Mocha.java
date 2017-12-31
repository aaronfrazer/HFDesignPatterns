package decorator.condiments;

import decorator.beverages.Beverage;

public class Mocha extends CondimentDecorator
{
    Beverage beverage;

    private final double baseCost = 0.20;
    private int quantity = 1;

    public Mocha(Beverage beverage)
    {
        this.beverage = beverage;
    }

    public String getDescription()
    {
        return beverage.getDescription() + ", Mocha";
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
