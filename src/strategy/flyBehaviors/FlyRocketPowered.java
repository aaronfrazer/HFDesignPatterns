package strategy.flyBehaviors;

import javafx.scene.image.Image;
import strategy.Main;

import java.io.File;

public class FlyRocketPowered implements FlyBehavior
{
    public void fly()
    {
        Main.addBackGroundImage(Main.rocketImage);
    }

    public Image getFlyingImage()
    {
        return Main.rocketImage;
    }
}
