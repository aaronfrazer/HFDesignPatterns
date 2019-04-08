package compound.observer;

import java.util.Iterator;
import java.util.ArrayList;

public class Observable implements QuackObservable
{
    private ArrayList<Observer> observers = new ArrayList<>();
    private QuackObservable duck;

    public Observable(QuackObservable duck)
    {
        this.duck = duck;
    }

    public void registerObserver(Observer o)
    {
        observers.add(o);
    }

    public void removeObserver(Observer o)
    {
        observers.remove(o);
    }

    public void notifyObservers()
    {
        for (Observer observer : observers)
            observer.update(duck);
    }

    public Iterator<Observer> getObservers()
    {
        return observers.iterator();
    }
}
