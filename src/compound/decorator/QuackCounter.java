package compound.decorator;

import compound.observer.Observer;
import compound.Quackable;

public class QuackCounter implements Quackable
{
    private Quackable duck;
    private static int numberOfQuacks;

    public QuackCounter(Quackable duck)
    {
        this.duck = duck;
    }

    public void quack()
    {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getQuacks()
    {
        return numberOfQuacks;
    }

    public void registerObserver(Observer observer)
    {
        duck.registerObserver(observer);
    }

    public void removeObserver(Observer observer)
    {
        duck.removeObserver(observer);
    }

    public void notifyObservers()
    {
        duck.notifyObservers();
    }

    public String toString()
    {
        return duck.toString();
    }
}
