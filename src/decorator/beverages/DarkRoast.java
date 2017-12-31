package decorator.beverages;

public class DarkRoast extends Beverage
{
    private String description = "Dark Roast Coffee";
    private final double baseCost = 0.99;
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