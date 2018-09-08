package command;

//
// This is the invoker
//
public class RemoteControlWithUndo
{
	private Command[] onCommands;
	private Command[] offCommands;
	private Command undoCommand;

	RemoteControlWithUndo()
	{
		onCommands = new Command[9];
		offCommands = new Command[9];

		Command noCommand = new NoCommand();
		for (int i = 0; i < 9; i++)
		{
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		undoCommand = noCommand;
	}

	public void setCommand(int slot, Command onCommand, Command offCommand)
	{
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot)
	{
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}

	public void offButtonWasPushed(int slot)
	{
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}

	public void undoButtonWasPushed()
	{
		undoCommand.undo();
	}

	public String toString()
	{
		StringBuilder stringBuff = new StringBuilder();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++)
		{
			stringBuff.append("[slot ").append(i).append("] ").append(onCommands[i].getClass().getName()).append("    ").append(offCommands[i].getClass().getName()).append("\n");
		}
		stringBuff.append("[undo] ").append(undoCommand.getClass().getName()).append("\n");
		return stringBuff.toString();
	}
}
