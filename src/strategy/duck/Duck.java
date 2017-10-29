package strategy.duck;

import strategy.Main;
import strategy.flyBehaviors.FlyBehavior;
import strategy.flyBehaviors.FlyRocketPowered;
import strategy.quackBehaviors.QuackBehavior;

public abstract class Duck
{
    // TODO: Implement flying (similar to water)
    boolean isFlying;
    boolean isSwimming;
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck()
    {
        isFlying = false;
        isSwimming = false;
    }

    public void setFlyBehavior(FlyBehavior fb)
    {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb)
    {
        quackBehavior = qb;
    }

    @SuppressWarnings("unused")
    public abstract void display();

    public void performFly()
    {
        if (!isFlying)
        {
            flyBehavior.fly();
            Main.addBackGroundImage(flyBehavior.getFlyingImage());
            isFlying = true;
        } else
        {
            Main.removeBackgroundImage();
            isFlying = false;
        }
    }

    public void performQuack()
    {
        quackBehavior.quack();
    }

    public void swim()
    {
        if (!isSwimming)
        {
            Main.addBackGroundImage(Main.waterImage);
            isSwimming = true;
        } else
        {
            Main.removeBackgroundImage();
            isSwimming = false;
        }
    }
}
