package decorator.beverages;

public abstract class Beverage
{
    private Size size;

    public Beverage()
    {
        if (getSize() == null)
            setSize("TALL");
    }

    public abstract double getCost();

    public abstract String getDescription();

    public Size getSize()
    {
        return size;
    }

    /**
     * Sets the size of this beverage.
     *
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