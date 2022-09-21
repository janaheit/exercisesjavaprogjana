package be.abis.shapes.test;

import be.abis.shapes.enums.Color;
import be.abis.shapes.model.Circle;
import be.abis.shapes.model.Rectangle;
import be.abis.shapes.model.Shape;
import be.abis.shapes.model.Triangle;

public class Test {

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(Color.BLUE, 30), new Rectangle(Color.ORANGE, 5, 20),
                             new Triangle(Color.GREEN, 3, 4)};

        for (Shape s: shapes){
            System.out.println(s);
            System.out.println(s.area());
        }
    }
}
