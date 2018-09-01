package command;

public class CeilingFanHighCommand implements Command
{
	private CeilingFan ceilingFan;
	private int prevSpeed;

	CeilingFanHighCommand(CeilingFan ceilingFan)
	{
		this.ceilingFan = ceilingFan;
	}

	public void execute()
	{
		prevSpeed = ceilingFan.getSpeed();
		ceilingFan.high();
	}

	public void undo()
	{
		if (prevSpeed == CeilingFan.HIGH)
		{
			ceilingFan.high();
		} else if (prevSpeed == CeilingFan.MEDIUM)
		{
			ceilingFan.medium();
		} else if (prevSpeed == CeilingFan.LOW)
		{
			ceilingFan.low();
		} else if (prevSpeed == CeilingFan.OFF)
		{
			ceilingFan.off();
		}
	}
}
