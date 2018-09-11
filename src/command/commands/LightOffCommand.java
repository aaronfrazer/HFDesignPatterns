package command.commands;

import command.devices.Light;

public class LightOffCommand implements Command
{
    Light light;
    int level;

    public LightOffCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute()
    {
        level = light.getLevel();
        light.off();
    }

    @Override
    public void undo()
    {
        light.on();
        light.dim(level);
    }
}