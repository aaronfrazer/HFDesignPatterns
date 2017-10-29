package observer.subject;

import observer.observers.Observer;

public interface Subject
{
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
