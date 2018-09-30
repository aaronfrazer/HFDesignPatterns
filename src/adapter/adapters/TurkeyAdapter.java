package adapter.adapters;

import adapter.Main;
import adapter.ducks.Duck;
import adapter.ducks.Turkey;

public class TurkeyAdapter implements Duck
{
    private String imageFly = "TurkeyFlying.gif";
    private String imageLand = "Turkey.png";

    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey)
    {
        this.turkey = turkey;
    }

    @Override
    public void quack()
    {
        turkey.gobble();
    }

    @Override
    public void fly()
    {
        if (Main.buttonTurkeyAdapterFly.getText().equalsIgnoreCase("Fly"))
        {
            Main.displayTurkeyAdapterImage(imageFly);
            Main.buttonTurkeyAdapterFly.setText("Land");
        } else
        {
            Main.displayTurkeyAdapterImage(imageLand);
            Main.buttonTurkeyAdapterFly.setText("Fly");
        }
    }
}