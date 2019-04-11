package mvc.beatMachine;

public class FXController implements ControllerInterface
{
    private BeatModelInterface model;
    private Main view;

    FXController(BeatModelInterface model, Main view)
    {
        this.model = model;
        this.view = view;
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.initialize();
    }

    public void start()
    {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    public void stop()
    {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    public void increaseBPM()
    {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
    }

    public void decreaseBPM()
    {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

    public void setBPM(int bpm)
    {
        model.setBPM(bpm);
    }

}
