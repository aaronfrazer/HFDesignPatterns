package compound.ducks;

import compound.Main;

public class Goose
{
    public void honk()
    {
        Main.displayImage("Goose.png");
        Main.playSound("Honk.wav");
//        System.out.println("Honk");
    }

    public String toString()
    {
        return "Goose";
    }
}
