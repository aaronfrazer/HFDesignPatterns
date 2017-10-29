package strategy.quackBehaviors;

import strategy.Main;

public class FakeQuack implements QuackBehavior
{
    String sound = "FakeQuack.wav";

    public void quack()
    {
        Main.playSound(sound);
    }
}
