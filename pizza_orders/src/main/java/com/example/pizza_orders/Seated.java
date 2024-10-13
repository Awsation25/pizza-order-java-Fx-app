package com.example.pizza_orders;

public class Seated extends PizzaOrder {
    // attributes of class Seated
    private double serviceCharge;
    private int numberOfPeople;
    // default constructor 
    public Seated() {
    }
    //non default constructor
    public Seated(String customerName, int pizzaSize, int numberOfTuppings, double toppingPrice, double serviceCharge,
            int numberOfPeople) {
        super(customerName, pizzaSize, numberOfTuppings, toppingPrice);
        this.serviceCharge = serviceCharge;
        this.numberOfPeople = numberOfPeople;
    }
    // tostring method that return a String representation of the object
    @Override
    public String toString() {
        return super.toString()+"\nserviceCharge=" + serviceCharge +
        "\nnumberOfPeople= " + numberOfPeople + "";
    }
    //method to calculate order price 
    @Override
    public double calculateOrderPrice() {
        
        return super.calculateOrderPrice()+(serviceCharge*numberOfPeople);
    }
    
}
