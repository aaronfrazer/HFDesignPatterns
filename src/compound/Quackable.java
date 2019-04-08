package compound;

import compound.observer.QuackObservable;

public interface Quackable extends QuackObservable
{
    void quack();
}
