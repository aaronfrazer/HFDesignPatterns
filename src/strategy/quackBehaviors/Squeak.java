package strategy.quackBehaviors;

import strategy.Main;

public class Squeak implements QuackBehavior
{
    String sound = "Squeak.wav";

    public void quack()
    {
        Main.playSound(sound);
    }
}
