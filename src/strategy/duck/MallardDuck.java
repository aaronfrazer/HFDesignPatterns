package strategy.duck;

import strategy.Main;
import strategy.flyBehaviors.FlyWithWings;
import strategy.quackBehaviors.Quack;

public class MallardDuck extends Duck
{
    private String image = "MallardDuck.jpg";

    public MallardDuck()
    {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display()
    {
        Main.displayImage(image);
    }
}
