package decorator.condiments;

import decorator.beverages.Beverage;

public class Milk extends CondimentDecorator
{
    private Beverage beverage;

    private final double cost = 0.10;

    public Milk(Beverage beverage)
    {
        this.beverage = beverage;
    }

    public String getDescription()
    {
        return beverage.getDescription() + ", Milk";
    }

    public double getCost()
    {
        double cost = this.cost + beverage.getCost();
        return Math.round(cost * 100.0) / 100.0;
    }
}