package command.devices;

import command.Main;

public class GarageDoor
{
	String location;

	public GarageDoor(String location)
	{
		this.location = location;
	}

	public void up()
	{
		Main.openCloseGarageDoor(true);
		System.out.println(location + " garage Door is Up");
	}

	public void down()
	{
		Main.openCloseGarageDoor(false);
		System.out.println(location + " garage Door is Down");
	}

	public void stop()
	{
		System.out.println(location + " garage Door is Stopped");
	}

	public void lightOn()
	{
		System.out.println(location + " garage light is on");
	}

	public void lightOff()
	{
		System.out.println(location + " garage light is off");
	}
}
