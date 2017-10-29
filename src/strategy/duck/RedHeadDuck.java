package strategy.duck;

import strategy.Main;
import strategy.flyBehaviors.FlyWithWings;
import strategy.quackBehaviors.Quack;

public class RedHeadDuck extends Duck
{
    private String image = "RedHeadDuck.jpg";

    public RedHeadDuck()
    {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display()
    {
        Main.displayImage(image);
    }
}
