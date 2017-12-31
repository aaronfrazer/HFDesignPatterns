package decorator.condiments;

import decorator.beverages.Beverage;

public abstract class CondimentDecorator extends Beverage
{
    public abstract String getDescription();
}
