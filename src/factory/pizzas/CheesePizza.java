package factory.pizzas;

import factory.factories.PizzaIngredientFactory;

public class CheesePizza extends Pizza
{
    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory)
    {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare()
    {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }

    public String getName()
    {
        return name;
    }

//    public CheesePizza()
//    {
//        name = "Cheese Pizza";
//        dough = "Regular Crust";
//        sauce = "Marinara Pizza Sauce";
//        toppings.add("Fresh Mozzarella");
//        toppings.add("Parmesan");
//    }
}
