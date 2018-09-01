package command;

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
        Main.displayImage(location, true);
        System.out.println(location + " Light is on");
    }

    public void off()
    {
        level = 0;
        Main.displayImage(location, false);
        System.out.println(location + " Light is off");
    }

    protected void dim(int level)
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

    protected int getLevel()
    {
        return level;
    }
}
