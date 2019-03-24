package proxy.remoteproxy;

public class GumballMachineReal implements GumballMachineInterface
{
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State winnerState;

    private State state = soldOutState;
    private int count;
    private String location;

    public GumballMachineReal(int numberGumballs)
    {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0)
        {
            state = noQuarterState;
        }
    }

    @Override
    public int getCount()
    {
        return count;
    }

    @Override
    public String getLocation()
    {
        return location;
    }

    @Override
    public State getState()
    {
        return state;
    }

    public void insertQuarter()
    {
        state.insertQuarter();
    }

    public void ejectQuarter()
    {
        state.ejectQuarter();
    }

    public void turnCrank()
    {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public void releaseBall()
    {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0)
        {
            count = count - 1;
        }
    }

    public void refill(int count)
    {
        this.count = count;
        System.out.println("The gumball machine was just refilled; it's new count is: " + this.count);
        state.refill();
    }

    public State getSoldOutState()
    {
        return soldOutState;
    }

    public State getNoQuarterState()
    {
        return noQuarterState;
    }

    public State getHasQuarterState()
    {
        return hasQuarterState;
    }

    public State getSoldState()
    {
        return soldState;
    }

    public State getWinnerState()
    {
        return winnerState;
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder("\nMighty Gumball, Inc." + "\nJava-enabled Standing Gumball Model #2004" + "\nInventory: " + count + " gumball");

        if (count != 1)
        {
            result.append("s");
        }

        result.append("\n" + "Machine is ").append(state).append("\n");

        return result.toString();
    }
}
