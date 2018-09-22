package adapter.ducks;

import adapter.Main;

public class WildTurkey implements Turkey
{
    private String imageFly = "TurkeyFlying.gif";
    private String imageLand = "Turkey.png";

    private String sound = "Gobble.wav";

    @Override
    public void gobble()
    {
        Main.playSound(sound);
    }

    @Override
    public void fly()
    {
        if (Main.buttonTurkeyFly.getText().equalsIgnoreCase("Fly"))
        {
            Main.displayTurkeyImage(imageFly);
            Main.buttonTurkeyFly.setText("Land");
        } else
        {
            Main.displayTurkeyImage(imageLand);
            Main.buttonTurkeyFly.setText("Fly");
        }
    }
}
