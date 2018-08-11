package factory.pizzas;

import factory.factories.PizzaIngredientFactory;

public class ClamPizza extends Pizza
{
    private PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory)
    {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare()
    {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }

//    public ClamPizza()
//    {
//        name = "Clam Pizza";
//        dough = "Thin Crust";
//        sauce = "White Garlic Sauce";
//        toppings.add("Clams");
//        toppings.add("Grated Parmesan Cheese");
//    }
}
