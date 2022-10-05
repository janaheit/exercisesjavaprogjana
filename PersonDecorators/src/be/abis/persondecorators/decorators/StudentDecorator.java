package be.abis.persondecorators.decorators;

public class StudentDecorator extends BaseDecorator {

    public StudentDecorator(PersonDecorator personDecorator) {
        super(personDecorator);
    }

    @Override
    public void assemble() {
        super.assemble();

        System.out.println("is studying. ");
    }
}
