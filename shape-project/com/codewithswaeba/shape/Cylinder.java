package com.codewithswaeba.shape;
public class Cylinder extends Shape{
private double radius,height;
public Cylinder(double radius,double height){
this.radius=radius;
this.height=height;
}
public double getradius(double radius){
return radius;
}
public void setradius(){
this.radius=radius;
}
public double getheight(double height){
return height;
}
public void setheight(){
this.height=height;
}

@Override
public double getSurfaceArea(){
return 2 * Math.PI * radius * (radius + height);
}
}