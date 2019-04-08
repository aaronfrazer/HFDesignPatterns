package compound.factory;

import compound.ducks.DuckCall;
import compound.ducks.MallardDuck;
import compound.ducks.RedheadDuck;
import compound.ducks.RubberDuck;
import compound.Quackable;

public class DuckFactory extends AbstractDuckFactory
{

    public Quackable createMallardDuck()
    {
        return new MallardDuck();
    }

    public Quackable createRedheadDuck()
    {
        return new RedheadDuck();
    }

    public Quackable createDuckCall()
    {
        return new DuckCall();
    }

    public Quackable createRubberDuck()
    {
        return new RubberDuck();
    }
}
