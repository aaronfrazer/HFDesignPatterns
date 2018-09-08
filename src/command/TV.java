package command;

public class TV
{
	String location;
	int channel;

	public TV(String location)
	{
		this.location = location;
	}

	public void on()
	{
		Main.turnOnOffTV(true);
		System.out.println(location + " TV is on");
	}

	public void off()
	{
		Main.turnOnOffTV(false);
		System.out.println(location + " TV is off");
	}

	public void setInputChannel()
	{
		this.channel = 3;
		System.out.println(location + " TV channel is set for DVD");
	}
}
