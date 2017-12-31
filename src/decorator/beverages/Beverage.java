package decorator.beverages;

public abstract class Beverage
{
    public enum Size {
        TALL("Tall", 0.10),
        GRANDE("Grande", 0.15),
        VENTI("Venti", 0.20);
        private String name;
        private double cost;
        Size(String name, double cost) { this.cost = cost; this.name = name; }
        public double getCost() { return cost; }
        public String getName() { return name; }
    }

    private Size size;

    /**
     * A beverage has a default size of TALL.
     */
    public Beverage()
    {
        if (getSize() == null)
            setSize("TALL");
    }

    public abstract double getCost();

    public abstract String getDescription();

    public abstract int getQuantity();

    public Size getSize()
    {
        return size;
    }

    /**
     * Sets the size of this beverage.
     * @param sizeName String of new size
     */
    public void setSize(String sizeName)
    {
        if (sizeName.equalsIgnoreCase("TALL"))
            size = Size.TALL;
        else if (sizeName.equalsIgnoreCase("GRANDE"))
            size = Size.GRANDE;
        else if (sizeName.equalsIgnoreCase("VENTI"))
            size = Size.VENTI;
    }
}