package factory.pizza;

import factory.Main;

import java.util.concurrent.TimeUnit;

public class PizzaThreadRunner implements Runnable
{
    private volatile boolean running = true;

    @Override
    public void run()
    {
//        Main.factory = new SimplePizzaFactory();
//        Main.store = new PizzaStore(Main.factory);
//
//        while (running)
//        {
//            try {
//                TimeUnit.SrECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Main.pizza = Main.store.orderPizza("Cheese");
//        }
    }

    public void terminate()
    {
        running = false;
    }
}
