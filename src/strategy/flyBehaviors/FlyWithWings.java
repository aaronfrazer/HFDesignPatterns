package strategy.flyBehaviors;

import javafx.scene.image.Image;
import strategy.Main;

import java.io.File;

public class FlyWithWings implements FlyBehavior
{
    public static Image wingImage = new Image(new File(Main.imageDir + "MallardDuckFlying.png").toURI().toString());

    public void fly()
    {
        Main.addBackGroundImage(wingImage);
    }

    public Image getFlyingImage()
    {
        return wingImage;
    }
}
