package mvc.beatMachine;

import javafx.scene.control.ProgressBar;

public class FXBeatBar extends ProgressBar implements Runnable
{
    private Thread thread;

    FXBeatBar()
    {
        thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        System.out.println("Progress bar set to run");
        do
        {
            double value;
            value = getProgress();
            value = value * .75;
            setProgress(value);
            try
            {
                Thread.sleep(15);
            } catch (Exception ignored)
            {
            }
        } while (true);
    }
}
