package singleton.chocolate;

public class ChocolateBoiler
{
    private boolean empty;
    private boolean boiled;
    private int numChocolateBoiled;
    private static ChocolateBoiler uniqueInstance;

    private ChocolateBoiler()
    {
        empty = true;
        boiled = false;
        numChocolateBoiled = 0;
    }

    public static ChocolateBoiler getInstance()
    {
        if (uniqueInstance == null)
            uniqueInstance = new ChocolateBoiler();

        return uniqueInstance;
    }

    /**
     * Fills the boiler with a milk/chocolate mixture.
     */
    public void fill()
    {
        if (isEmpty())
            empty = false;
            boiled = false;
    }

    /**
     * Drains the boiled milk and chocolate.
     */
    public void drain()
    {
        if (!isEmpty())
        {
            empty = true;

            if (isBoiled())
                numChocolateBoiled++;

            boiled = false;
        }
    }

    /**
     * Boils milk/chocolate mixture.
     */
    public void boil()
    {
        if (!isEmpty() && !isBoiled())
            boiled = true;
    }

    public boolean isEmpty()
    {
        return empty;
    }

    public boolean isBoiled()
    {
        return boiled;
    }

    public int getNumChocolateBoiled()
    {
        return numChocolateBoiled;
    }

    public void addNumChocolateBoiled()
    {
        numChocolateBoiled++;
    }
}