package decorator.beverages;

public class HouseBlend extends Beverage
{
    private final double cost = 0.89;

    private String description = "House Blend Coffee";

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