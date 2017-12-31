package decorator.beverages;

public class Espresso extends Beverage
{
    private final double cost = 1.99;

    private String description = "Espresso";

    public String getDescription()
    {
        return getSize().getName() + " " + description;
    }

    public double getCost()
    {
        double cost = this.cost + getSize().getCost();
        return Math.round(cost * 100.0) / 100.0;
    }

}