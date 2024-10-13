package com.example.pizza_orders;
public class ToGo extends PizzaOrder{
    // default constructor 
    public ToGo() {
    }
    //non default constructor
    public ToGo(String customerName, int pizzaSize, int numberOfTuppings, double toppingPrice) {
        super(customerName, pizzaSize, numberOfTuppings, toppingPrice);
    }  
}
