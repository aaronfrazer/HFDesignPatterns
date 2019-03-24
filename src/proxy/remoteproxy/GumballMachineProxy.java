package proxy.remoteproxy;

public class GumballMachineProxy implements GumballMachineInterface
{
    private GumballMachineReal gumballMachine;

    protected GumballMachineProxy(GumballMachineReal gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public int getCount()
    {
        return gumballMachine.getCount();
    }

    @Override
    public String getLocation()
    {
        return gumballMachine.getLocation();
    }

    @Override
    public State getState()
    {
        return gumballMachine.getState();
    }
}
