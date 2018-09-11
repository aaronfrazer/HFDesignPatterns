package command.commands;

import command.devices.Light;

public class LightOnCommand implements Command
{
    Light light;
    int level;

    public LightOnCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute()
    {
        level = light.getLevel();
        light.on();
    }

    @Override
    public void undo()
    {
        light.off();
        light.dim(level);
    }
}
