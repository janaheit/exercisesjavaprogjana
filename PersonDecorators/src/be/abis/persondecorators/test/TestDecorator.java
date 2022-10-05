package be.abis.persondecorators.test;

import be.abis.persondecorators.decorators.InstructorDecorator;
import be.abis.persondecorators.decorators.PersonDecorator;
import be.abis.persondecorators.decorators.StudentDecorator;
import be.abis.persondecorators.model.Person;

public class TestDecorator {

    public static void main(String[] args) {
        PersonDecorator pd = new InstructorDecorator(new Person("Jana", "Heitkemper"));
        pd.assemble();

        System.out.println("--------------");
        PersonDecorator pd2 = new StudentDecorator(new InstructorDecorator(new Person("Jana", "Heitkemper")));
        pd2.assemble();
    }
}
