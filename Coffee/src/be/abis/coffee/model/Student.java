package be.abis.coffee.model;

public class Student extends Person {

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Cup makeCoffeeFor(Instructor i){
        System.out.println(this.getFirstName() + ": 'Sure, no problem.'");
        Cafeteria cafeteria = Cafeteria.getInstance();
        Cup cup = cafeteria.getCup();
        CoffeeMachine coffeeMachine = cafeteria.getCoffeeMachine();
        coffeeMachine.setCup(cup);
        return coffeeMachine.giveOutCupOfCoffee(i.getCoffeePreference());
    }
}
