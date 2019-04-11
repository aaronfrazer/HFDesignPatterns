package mvc.heart;

import mvc.beatMachine.ControllerInterface;

public class Main
{
    public static void main(String[] args)
    {
        HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
    }
}
