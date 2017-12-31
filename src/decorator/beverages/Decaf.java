package decorator.beverages;

public class Decaf extends Beverage
{
    private final double cost = 1.05;

    private String description = "Decaf Coffee";

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