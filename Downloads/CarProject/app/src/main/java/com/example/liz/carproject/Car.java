package com.example.liz.carproject;

/**
 * Created by liz on 11/20/2016.
 */

public class Car {
private String color, make;
private double horse_power, engine_size;
public static int count;
    public Car(){
        String color = "Black";
        String make = "Huyndai";
        double horse_power = 85;
        double engine_size = 75;
        count ++;
    }
    public Car(String color, double horse_power, double engine_size, String make){
        this.color = color;
        this.make = make;
        this.horse_power = horse_power;
        this.engine_size = engine_size;
        count ++;
    }
    public String toString(){
        return "This car is a " + color + "\t" + make + "\t" + "with the horse power of " + horse_power + " and the engine size " + engine_size;
    }
    public String getColor(){
        return color;
    }
    public String getMake(){
        return make;
    }
    public double getHorse_power(){
        return horse_power;
    }
    public double getEngine_size(){
        return engine_size;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setMake(String make){
        this.make = make;
    }
    public void setHorse_power(double horse_power){
        this.horse_power = horse_power;
    }
    public void setEngine_size(double engine_size){
        this.engine_size = engine_size;
    }
    public boolean equal(Car car) {
        boolean result = false;
        result = this.color.equals(car.getColor()) && (this.engine_size == car.getEngine_size()) && (this.horse_power == car.getHorse_power()) && (this.make.equals(car.getMake()));
           return result;
        }

    public static int getCount(){
        return count;
    }

}
