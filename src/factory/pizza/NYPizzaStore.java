package factory.pizza;

public class NYPizzaStore extends PizzaStore
{
    public NYPizzaStore(SimplePizzaFactory factory)
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
//            pizza.setName("New York Style Cheese Pizza");

        } else if (item.equals("veggie"))
        {

            pizza = new VeggiePizza();
//            pizza.setName("New York Style Veggie Pizza");

        } else if (item.equals("clam"))
        {

            pizza = new ClamPizza();
//            pizza.setName("New York Style Clam Pizza");

        } else if (item.equals("pepperoni"))
        {

            pizza = new PepperoniPizza();
//            pizza.setName("New York Style Pepperoni Pizza");

        }

        return pizza;
    }

}
