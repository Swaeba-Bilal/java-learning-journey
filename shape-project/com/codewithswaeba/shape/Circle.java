package com.codewithswaeba.shape;
public class Circle extends Shape{
private double radius;
public Circle(double radius){
this.radius=radius;
}
public double getradius(double radius){
return radius;
}
public void setradius(){
this.radius=radius;
}

@Override
public double getSurfaceArea(){
return Math.PI*radius*radius;
}
}