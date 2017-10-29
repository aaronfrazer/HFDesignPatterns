package strategy.quackBehaviors;

import strategy.Main;

public class Quack implements QuackBehavior
{
    String sound = "Quack.wav";

    public void quack()
    {
        Main.playSound(sound);
    }
}
