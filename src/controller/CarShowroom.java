package controller;


import controller.Node;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
public class CarShowroom {
    
    Node head;
    
    public CarShowroom(){
        this.head= null;
    }

    public void addCar(Car car) {
        Node newNode = new Node(car);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void deleteCar(String model) {
        if (head == null) {
            return;
        }

        if (head.car.getModel().equals(model)) {
            head = head.next;
            return;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null && !curr.car.getModel().equals(model)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
        }
    }

    public void updateCar(String model, String color, String engineType, int numberOfSeats,
                   String airConditioning, double price, String companyName) {
        if (head == null) {
            return;
        }

        Node curr = head;

        while (curr != null && !curr.car.getModel().equals(model)) {
            curr = curr.next;
        }

        if (curr != null) {
            curr.car.setColor(color);
            curr.car.setEngineType(engineType);
            curr.car.setNumberOfSeats(numberOfSeats);
            curr.car.setAirConditioning(airConditioning);
            curr.car.setPrice(price);
            curr.car.setCompanyName(companyName);
        }
    }

    public Car searchCarByModel(String model) {
        if (head == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.car.getModel().equalsIgnoreCase(model)) {
                return curr.car;
            }
            curr = curr.next;
        }

        return null;
    }

    public Car searchCarByCompanyName(String companyName) {
        if (head == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.car.getCompanyName().equalsIgnoreCase(companyName)) {
                return curr.car;
            }
            curr = curr.next;
        }

        return null;
    }

    public Car[] getAllCars() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        Car[] cars = new Car[count];
        curr = head;
        int index = 0;
        while (curr != null) {
            cars[index] = curr.car;
            index++;
            curr = curr.next;
        }

        return cars;
    }
}