package command.devices;

import command.Main;

public class Light
{
    private String location;
    private int level;

    public Light(String location)
    {
        this.location = location;
    }

    public void on()
    {
        level = 100;
        Main.displayLightImage(location, true);
        System.out.println(location + " Light is on");
    }

    public void off()
    {
        level = 0;
        Main.displayLightImage(location, false);
        System.out.println(location + " Light is off");
    }

    public void dim(int level)
    {
        this.level = level;
        if (level == 0)
        {
            off();
        } else
        {
            System.out.println("Light is dimmed to " + level + "%");
        }
    }

    public int getLevel()
    {
        return level;
    }
}
