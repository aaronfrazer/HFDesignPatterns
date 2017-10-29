package strategy.flyBehaviors;

import javafx.scene.image.Image;

public class FlyNoWay implements FlyBehavior
{
    public void fly()
    {
        System.out.println("I can't fly");
    }

    public Image getFlyingImage()
    {
        return null;
    }
}
