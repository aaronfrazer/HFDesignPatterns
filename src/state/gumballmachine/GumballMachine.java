package state.gumballmachine;

import state.states.*;

public class GumballMachine
{
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count;

    public GumballMachine(int numberGumballs)
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

    public int getCount()
    {
        return count;
    }

    public void refill(int count)
    {
        this.count = count;
        System.out.println("The gumball machine was just refilled; it's new count is: " + this.count);
        state.refill();
    }

    public State getState()
    {
        return state;
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

        result.append("\n" + "Machine is " + state + "\n");

        return result.toString();
    }
}
