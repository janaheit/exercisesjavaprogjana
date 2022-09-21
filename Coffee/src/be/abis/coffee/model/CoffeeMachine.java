package be.abis.coffee.model;

public class CoffeeMachine {

    private Cup cup;

    public CoffeeMachine() {
    }

    public Cup giveOutCupOfCoffee(MilkType milk){
        if (cup != null) {
            Coffee coffee = new Coffee(milk);
            coffee.pourInto(cup);
            return cup;
        }
        System.out.println("Error> no cup in coffee machine");
        return null;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }
}
