package strategy.duck;

import strategy.Main;
import strategy.flyBehaviors.FlyNoWay;
import strategy.quackBehaviors.Squeak;

public class RubberDuck extends Duck
{
    private String image = "RubberDuck.png";

    public RubberDuck()
    {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    public void display()
    {
        Main.displayImage(image);
    }
}
