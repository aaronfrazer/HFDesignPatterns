package strategy.duck;

import strategy.Main;
import strategy.flyBehaviors.FlyNoWay;
import strategy.quackBehaviors.Quack;

public class ModelDuck extends Duck
{
    private String image = "ModelDuck.png";

    public ModelDuck()
    {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display()
    {
        Main.displayImage(image);
    }
}
