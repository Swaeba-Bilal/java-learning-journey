
package com.company;
import com.codewithswaeba.shape.*;
public class Main8{
public static void main(String[]args){
Rectangle rect =new Rectangle(5,8);
Square sq= new Square(5);
Circle circle = new Circle(7);
Cylinder cy = new Cylinder(6,9);
Sphere sphere = new Sphere(5);
System.out.println("Initial Values:");
        System.out.println("Rectangle Surface Area: " + rect.getSurfaceArea());
        System.out.println("Square Surface Area: " + sq.getSurfaceArea());
        System.out.println("Circle Surface Area: " + circle.getSurfaceArea());
        System.out.println("Cylinder Surface Area: " + cy.getSurfaceArea());
        System.out.println("Sphere Surface Area: " + sphere.getSurfaceArea());
}
}