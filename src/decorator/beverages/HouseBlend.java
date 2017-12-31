package decorator.beverages;

public class HouseBlend extends Beverage
{
    private String description = "House Blend Coffee";
    private final double baseCost = 0.89;
    private int quantity = 1;

    public String getDescription()
    {
        return getSize().getName() + " " + description;
    }

    public double getCost()
    {
        double cost = baseCost + getSize().getCost();
        return Math.round(cost * 100.0) / 100.0;
    }

    public int getQuantity()
    {
        return quantity;
    }
}