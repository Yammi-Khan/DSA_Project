package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class Car {
    private String model;
    private String color;
    private String engineType;
    private int numberOfSeats;
    private String airConditioning;
    private double price;
    private String companyName;

    public Car(String model, String color, String engineType, int numberOfSeats, String airConditioning,
               double price, String companyName) {
        this.model = model;
        this.color = color;
        this.engineType = engineType;
        this.numberOfSeats = numberOfSeats;
        this.airConditioning = airConditioning;
        this.price = price;
        this.companyName = companyName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(String airConditioning) {
        this.airConditioning = airConditioning;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engineType='" + engineType + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", airConditioning='" + airConditioning + '\'' +
                ", price=" + price +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}

