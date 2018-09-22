package adapter.ducks;

import adapter.Main;

public class MallardDuck implements Duck
{
    private String imageFly = "MallardDuckFlying.gif";
    private String imageLand = "MallardDuck.jpg";
    private String sound = "Quack.wav";

    public void quack()
    {
        Main.playSound(sound);
    }

    public void fly()
    {
        if (Main.buttonDuckFly.getText().equalsIgnoreCase("Fly"))
        {
            Main.displayDuckImage(imageFly);
            Main.buttonDuckFly.setText("Land");
        } else
        {
            Main.displayDuckImage(imageLand);
            Main.buttonDuckFly.setText("Fly");
        }
    }
}