package be.abis.coffee.model;

public class Instructor extends Person {

    private MilkType coffeePreference;
    private int numOfCoffees;

    public Instructor(String firstName, String lastName) {
        super(firstName, lastName);
        this.coffeePreference = MilkType.NONE;
    }

    public void askForCoffeeFromFor(Student student, Instructor i){
        System.out.println(this.getFirstName() + ": 'Could you, " + student.getFirstName() + " make me a coffee with " +
                coffeePreference.getDescription() + " milk?'");
        Cup cupOfCoffee = student.makeCoffeeFor(i);
        System.out.println(this.getFirstName() + ": 'Thanks, I got a coffee with " + ((Coffee)cupOfCoffee.getLiquid()).getMilk().getDescription()
                + ". Exactly what I needed to get energy to teach.'");
        drinkCoffee(cupOfCoffee);
    }

    private void drinkCoffee(Cup cupOfCoffee){
        numOfCoffees = numOfCoffees +1;
        cupOfCoffee.empty();                                    // Cup is now empty
        System.out.println("This is coffee number " + numOfCoffees);
    }

    public void setCoffeePreference(MilkType coffeePreference) {
        this.coffeePreference = coffeePreference;
    }

    public MilkType getCoffeePreference() {
        return coffeePreference;
    }
}
