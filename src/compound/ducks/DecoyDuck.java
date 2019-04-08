package compound.ducks;

import compound.Main;
import compound.observer.Observable;
import compound.observer.Observer;
import compound.Quackable;

public class DecoyDuck implements Quackable
{
    private Observable observable;

    public DecoyDuck()
    {
        observable = new Observable(this);
    }

    public void quack()
    {
        Main.displayImage("DecoyDuck.png");
        System.out.println("<< Silence >>");
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
        return "Decoy Duck";
    }
}
