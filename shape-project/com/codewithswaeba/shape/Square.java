package com.codewithswaeba.shape;
public class Square extends Shape{
private double side;
public Square(double side){
this.side=side;
}
public double getside(double side){
return side;
}
public void setside(){
this.side=side;
}

@Override
public double getSurfaceArea(){
return side*side;
}
}