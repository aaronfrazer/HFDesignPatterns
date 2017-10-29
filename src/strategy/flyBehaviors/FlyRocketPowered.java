package strategy.flyBehaviors;

import javafx.scene.image.Image;
import strategy.Main;

import java.io.File;

public class FlyRocketPowered implements FlyBehavior
{
    public static Image rocketImage = new Image(new File(Main.imageDir + "Rocket.png").toURI().toString());

    public void fly()
    {
        Main.addBackGroundImage(rocketImage);
    }

    public Image getFlyingImage()
    {
        return rocketImage;
    }
}
