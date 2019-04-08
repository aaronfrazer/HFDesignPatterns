package compound.adapter;

import compound.ducks.Goose;
import compound.observer.Observable;
import compound.observer.Observer;
import compound.Quackable;

public class GooseAdapter implements Quackable
{
    private Goose goose;
    private Observable observable;

    public GooseAdapter(Goose goose)
    {
        this.goose = goose;
        observable = new Observable(this);
    }

    public void quack()
    {
        goose.honk();
        notifyObservers();
    }

    public void registerObserver(Observer observer)
    {
        observable.registerObserver(observer);
    }

    public void removeObserver(Observer observer)
    {
        observable.removeObserver(observer);
    }

    public void notifyObservers()
    {
        observable.notifyObservers();
    }

    public String toString()
    {
        return "Goose pretending to be a Duck";
    }
}
