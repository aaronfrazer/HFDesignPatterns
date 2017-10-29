package strategy.duck;

import strategy.Main;
import strategy.flyBehaviors.FlyNoWay;
import strategy.quackBehaviors.MuteQuack;

public class DecoyDuck extends Duck
{
    private String image = "DecoyDuck.png";

    public DecoyDuck()
    {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    public void display()
    {
        Main.displayImage(image);
    }
}
