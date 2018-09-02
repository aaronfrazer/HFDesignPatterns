package command;

public class Stereo
{
	private String location;

	public Stereo(String location)
	{
		this.location = location;
	}

	public void on()
	{
		Main.turnOnOffStereo(true);
		System.out.println(location + " stereo is on");
	}

	public void off()
	{
		Main.turnOnOffStereo(false);
		System.out.println(location + " stereo is off");
	}

	public void setCD()
	{
		System.out.println(location + " stereo is set for CD input");
	}

	public void setDVD()
	{
		System.out.println(location + " stereo is set for DVD input");
	}

	public void setRadio()
	{
		System.out.println(location + " stereo is set for Radio");
	}

	public void setVolume(int volume)
	{
		// code to set the volume
		// valid range: 1-11 (after all 11 is better than 10, right?)
		System.out.println(location + " Stereo volume set to " + volume);
	}
}
