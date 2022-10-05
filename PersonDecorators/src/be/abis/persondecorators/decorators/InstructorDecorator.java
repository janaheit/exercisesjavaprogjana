package be.abis.persondecorators.decorators;


import be.abis.persondecorators.model.Course;

public class InstructorDecorator extends BaseDecorator {

    public InstructorDecorator(PersonDecorator personDecorator) {
        super(personDecorator);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("is teaching.");
    }
}
