package compound.ducks;

import compound.Main;
import compound.observer.Observable;
import compound.observer.Observer;
import compound.Quackable;

public class RubberDuck implements Quackable
{
    private Observable observable;

    public RubberDuck()
    {
        observable = new Observable(this);
    }

    public void quack()
    {
        Main.displayImage("RubberDuck.png");
        Main.playSound("Squeak.wav");
//        System.out.println("Squeak");
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
        return "Rubber Duck";
    }
}
