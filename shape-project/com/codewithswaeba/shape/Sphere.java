package com.codewithswaeba.shape;
public class Sphere extends Shape{
private double radius;
public Sphere(double radius){
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
return 4* Math.PI * radius * radius;
}
}