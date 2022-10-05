package be.abis.persondecorators.decorators;


public abstract class BaseDecorator implements PersonDecorator{

    private PersonDecorator personDecorator;

    public BaseDecorator(PersonDecorator personDecorator) {
        this.personDecorator = personDecorator;
    }

    @Override
    public void assemble() {
        personDecorator.assemble();
    }

    public PersonDecorator getPersonDecorator() {
        return personDecorator;
    }
}
