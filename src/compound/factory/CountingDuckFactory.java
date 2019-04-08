package compound.factory;

import compound.ducks.DuckCall;
import compound.ducks.MallardDuck;
import compound.ducks.RedheadDuck;
import compound.ducks.RubberDuck;
import compound.decorator.QuackCounter;
import compound.Quackable;

public class CountingDuckFactory extends AbstractDuckFactory
{
    public Quackable createMallardDuck()
    {
        return new QuackCounter(new MallardDuck());
    }

    public Quackable createRedheadDuck()
    {
        return new QuackCounter(new RedheadDuck());
    }

    public Quackable createDuckCall()
    {
        return new QuackCounter(new DuckCall());
    }

    public Quackable createRubberDuck()
    {
        return new QuackCounter(new RubberDuck());
    }
}
