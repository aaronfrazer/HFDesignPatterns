package templatePattern.beverages;

import templatePattern.caffineBeverage.CaffeineBeverage;

public class Tea extends CaffeineBeverage
{
	public void brew() {
		System.out.println("Steeping the tea");
	}
	public void addCondiments() {
		System.out.println("Adding Lemon");
	}
}
