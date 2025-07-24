package com.codewithswaeba.shape;
public class Rectangle extends Shape{
private double length,width;
public Rectangle(double length, double width){
this.length=length;
this.width=width;
}
public double getLength(double length){
return length;
}
public void setLength(){
this.length=length;
}
public double getWidth(double width){
return width;
}
public void setwidth(){
this. width= width;
}
@Override
public double getSurfaceArea(){
return length*width;
}
}