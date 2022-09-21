package be.abis.coffee.model;

public class Cafeteria {
    private static final Cafeteria cafeteria = new Cafeteria();
    private CoffeeMachine coffeeMachine;
    private int numOfCups=10;
    private Cup[] cups = new Cup[this.numOfCups];


    private Cafeteria(){
        this.coffeeMachine = new CoffeeMachine();
        for (int x=0; x<numOfCups; x++){
            cups[x] = new Cup();
        }
    }

    public Cup makeCupOfCoffee(MilkType preference){
        Cup cupOfCoffee = coffeeMachine.giveOutCupOfCoffee(preference);
        return cupOfCoffee;
    }

    public Cup getCup() {
        for (int x=0; x<numOfCups; x++){
            if (cups[x]!= null){
                Cup cup = cups[x];
                cups[x] = null;
                return cup;
            }
        }
        System.out.println("No cup left in Cafeteria.");
        return null;
    }

    public void returnCup(Cup cup){
        for (int x=0; x<numOfCups; x++){
            if (cups[x]== null){
                cups[x] = cup;
                return;
            }
        }
        System.out.println("Too many cups in the Cafeteria.");
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public  static Cafeteria getInstance(){
        return cafeteria;
    }

}
