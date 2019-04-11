package mvc.beatMachine;

import javax.swing.*;

public class BeatBar extends JProgressBar implements Runnable
{
    private Thread thread;

    BeatBar()
    {
        thread = new Thread(this);
        setMaximum(100);
        thread.start();
    }

    public void run()
    {
        do {
            int value = getValue();
            value = (int) (value * .75);
            setValue(value);
            try
            {
                Thread.sleep(50);
            } catch (Exception ignored)
            {
            }
        } while (true);
    }
}
