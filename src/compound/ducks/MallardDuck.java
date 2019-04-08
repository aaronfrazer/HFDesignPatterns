package compound.ducks;

import compound.Main;
import compound.observer.Observable;
import compound.observer.Observer;
import compound.Quackable;

public class MallardDuck implements Quackable
{
    private Observable observable;

    public MallardDuck()
    {
        observable = new Observable(this);
    }

    public void quack()
    {
        Main.displayImage("MallardDuck.jpg");
        Main.playSound("Quack.wav");
//        System.out.println("Quack");
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
        return "Mallard Duck";
    }
}
