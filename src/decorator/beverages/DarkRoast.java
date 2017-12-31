package decorator.beverages;

public class DarkRoast extends Beverage
{
    private final double cost = 0.99;

    private String description = "Dark Roast Coffee";

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