package factory.pizzaStores;

import factory.factories.SimplePizzaFactory;
import factory.pizzas.*;

public class ChicagoPizzaStore extends PizzaStore
{

    public ChicagoPizzaStore(SimplePizzaFactory factory)
    {
        super(factory);
    }

    protected Pizza createPizza(String item)
    {
        Pizza pizza = null;
        SimplePizzaFactory factory;

        if (item.equals("cheese"))
        {

            pizza = new CheesePizza();
//            pizza.setName("Chicago Style Cheese Pizza");

        } else if (item.equals("veggie"))
        {

            pizza = new VeggiePizza();
//            pizza.setName("Chicago Style Veggie Pizza");

        } else if (item.equals("clam"))
        {

            pizza = new ClamPizza();
//            pizza.setName("Chicago Style Clam Pizza");

        } else if (item.equals("pepperoni"))
        {

            pizza = new PepperoniPizza();
//            pizza.setName("Chicago Style Pepperoni Pizza");

        }
        return pizza;
    }
}
