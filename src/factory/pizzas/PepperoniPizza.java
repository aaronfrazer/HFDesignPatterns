package factory.pizzas;

import factory.factories.PizzaIngredientFactory;

public class PepperoniPizza extends Pizza
{
    private PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory)
    {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare()
    {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();
    }

//    public PepperoniPizza()
//    {
//        name = "Pepperoni Pizza";
//        dough = "Crust";
//        sauce = "Marinara Sauce";
//        toppings.add("Sliced Pepperoni");
//        toppings.add("Sliced Onion");
//        toppings.add("Grated Parmesan Cheese");
//    }
}
