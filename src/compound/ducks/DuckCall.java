package compound.ducks;

import compound.Main;
import compound.observer.Observable;
import compound.observer.Observer;
import compound.Quackable;

public class DuckCall implements Quackable
{
    private Observable observable;

    public DuckCall()
    {
        observable = new Observable(this);
    }

    public void quack()
    {
        Main.displayImage("DuckCall.png");
        Main.playSound("FakeQuack.wav");
//        System.out.println("Kwak");
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
        return "Duck Call";
    }
}
