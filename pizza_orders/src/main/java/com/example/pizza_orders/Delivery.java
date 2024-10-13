package com.example.pizza_orders;

// Delivery class for delivery orders
// extend is for inheretence
public class Delivery extends PizzaOrder{
    //attributes
    private int zone ;
    private double tripRate;

// default constor
    public Delivery (){

    }
    //non default constructor
    public Delivery(String customerName,int pizzaSize,int numberOfTuppings,double toppingPrice,double tripRate,int zone){
       super(customerName,pizzaSize,numberOfTuppings,toppingPrice);
       this.tripRate=tripRate;
       this.zone=zone;
    }
    // setters and getters for private attributes
    public int getZone() {
        return zone;
    }
    public void setZone(int zone) {
        this.zone = zone;
    }
    public double getTripRate() {
        return tripRate;
    }
    public void setTripRate(double tripRate) {
        this.tripRate = tripRate;
    }
    // tostring method that return a String representation of the object
    @Override
    public String toString() {
        return super.toString()+" \ntripRate=" + tripRate+
        "\nzone= " + zone+
        "\nOrder price= "+calculateOrderPrice();
    } 
    
     // method to calculate the price of pizza order 
    public double calculateOrderPrice(){
     return   super.calculateOrderPrice()+(tripRate/100*super.calculateOrderPrice()*zone);
    }
}
