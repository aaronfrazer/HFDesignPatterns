package decorator.condiments;

import decorator.beverages.Beverage;

public class Soy extends CondimentDecorator
{
    private Beverage beverage;

    private final double cost = 0.15;

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
        double cost = this.cost + beverage.getCost();
        return Math.round(cost * 100.0) / 100.0;
    }
}