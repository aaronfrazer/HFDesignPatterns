package decorator.beverages;

public enum Size
{
    TALL("Tall", 0.10),
    GRANDE("Grande", 0.15),
    VENTI("Venti", 0.20);

    private String name;

    private double cost;

    Size(String name, double cost)
    {
        this.cost = cost;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public double getCost()
    {
        return cost;
    }
}