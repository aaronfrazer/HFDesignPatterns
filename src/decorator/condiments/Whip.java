package decorator.condiments;

import decorator.beverages.Beverage;

public class Whip extends CondimentDecorator
{
    private Beverage beverage;

    private final double cost = 0.10;

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
        double cost = this.cost + beverage.getCost();
        return Math.round(cost * 100.0) / 100.0;
    }

}
