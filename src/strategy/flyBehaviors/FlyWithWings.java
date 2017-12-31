package strategy.flyBehaviors;

import javafx.scene.image.Image;
import strategy.Main;

public class FlyWithWings implements FlyBehavior
{
    public void fly()
    {
        Main.addBackGroundImage(Main.wingImage);
    }

    public Image getFlyingImage()
    {
        return Main.wingImage;
    }
}
