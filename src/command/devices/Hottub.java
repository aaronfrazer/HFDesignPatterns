package command.devices;

import command.Main;

public class Hottub
{
	boolean on;
	private int temperature;

	public Hottub()
	{
	}

	public void on()
	{
		on = true;
		Main.turnOnOffHuttub(on);
	}

	public void off()
	{
		on = false;
		Main.turnOnOffHuttub(on);
	}

	public void circulate()
	{
		if (on)
		{
			System.out.println("Hottub is bubbling!");
		}
	}

	public void jetsOn()
	{
		if (on)
		{
			System.out.println("Hottub jets are on");
		}
	}

	public void jetsOff()
	{
		if (on)
		{
			System.out.println("Hottub jets are off");
		}
	}

	public void setTemperature(int temperature)
	{
		if (temperature > this.temperature)
		{
			System.out.println("Hottub is heating to a steaming " + temperature + " degrees");
		} else
		{
			System.out.println("Hottub is cooling to " + temperature + " degrees");
		}
		this.temperature = temperature;
	}
}
