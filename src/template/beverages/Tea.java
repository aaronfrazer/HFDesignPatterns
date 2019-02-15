package template.beverages;

import static template.Main.brewTimeline;
import static template.Main.condimentsTimeline;

public class Tea extends CaffeineBeverage
{
    private String beverageName = "Tea";

    public void brew()
    {
        brewTimeline.play();
    }

    public void addCondiments()
    {
        condimentsTimeline.play();
    }

    public String toString()
    {
        return beverageName;
    }
}