package be.abis.coffee.model;

public class Coffee implements Liquid {
    private MilkType milk;

    public Coffee(MilkType milk) {
        this.milk = milk;
    }

    public MilkType getMilk() {
        return milk;
    }

    @Override
    public void pourInto(Cup cup) {
        cup.fill(this);
    }
}
