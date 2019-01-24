package template.beverages;

import static template.Main.brewTimeline;
import static template.Main.condimentsTimeline;

public class Coffee extends CaffeineBeverage
{
	private String beverageName = "Coffee";

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