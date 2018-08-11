package factory.pizzas;

import factory.factories.PizzaIngredientFactory;

public class VeggiePizza extends Pizza
{
    private PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory)
    {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare()
    {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
    }

//    public VeggiePizza()
//    {
//        name = "Veggie Pizza";
//        dough = "Crust";
//        sauce = "Marinara Sauce";
//        toppings.add("Shredded Mozzarella");
//        toppings.add("Grated Parmesan");
//        toppings.add("Diced Onion");
//        toppings.add("Sliced Mushrooms");
//        toppings.add("Sliced Red Pepper");
//        toppings.add("Sliced Black Olives");
//    }
}
