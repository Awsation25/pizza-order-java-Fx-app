package com.example.pizza_orders;
import java.util.*;

public class PizzaOrder implements Comparable<PizzaOrder>
{
    //attributes of class pizza order
    private String customerName;
   private Date dateOrdered;
    final static int SMALL =1;
    final static int MEDIUM =2;
   final static int LARGE =3;
   private int pizzaSize;
   private int numberOfTuppings;
   private double toppingPrice;
   //default constructor
   public PizzaOrder(){

   }
// non default constuctor
public PizzaOrder(String customerName,int pizzaSize,int numberOfTuppings,double toppingPrice){
this.customerName=customerName;
dateOrdered=new Date();
this.numberOfTuppings=numberOfTuppings;
this.pizzaSize=pizzaSize;
this.toppingPrice=toppingPrice;
}
//setters and getters for private attributes
public String getCustomerName() {
    return customerName;
}
public void setCustomerName(String customerName) {
    this.customerName = customerName;
}
public Date getDateOrdered() {
    return dateOrdered;
}
public void setDateOrdered(Date dateOrdered) {
    this.dateOrdered = dateOrdered;
}
public int getPizzaSize() {
    return pizzaSize;
}
public void setPizzaSize(int pizzaSize) {
    this.pizzaSize = pizzaSize;
}
public int getNumberOfTuppings() {
    return numberOfTuppings;
}
public void setNumberOfTuppings(int numberOfTuppings) {
    this.numberOfTuppings = numberOfTuppings;
}
public double getToppingPrice() {
    return toppingPrice;
}
public void setToppingPrice(double toppingPrice) {
    this.toppingPrice = toppingPrice;
}

// tostring method that return a String representation of the object
   @Override
public String toString() {

     String s=new String();
    if (pizzaSize==1)
    s="Small";
    else if (pizzaSize==2)
    s="Medium";
    else 
    s="Large";
    
    return "customerName= " + customerName+
    " \ndateOrdered= " + dateOrdered+
    "\npizzaSize= "+s+
    "\n numberOfTuppings= " + numberOfTuppings+
    "\ntoppingPrice= " + toppingPrice;

}
// method to calculate and return the order price 
public  double calculateOrderPrice(){
    double orderPrice;
    orderPrice =(numberOfTuppings*toppingPrice)*pizzaSize;
    return  orderPrice;
   } 
   // method to print customer name and the order price 
public String printOrderInfo(){
    System.out.println(customerName+"\t"+calculateOrderPrice());
    return customerName +"\t"+calculateOrderPrice();
}
// compareto method to compare between the prices in the array list 
@Override
public int compareTo(PizzaOrder o) {
    if(calculateOrderPrice()>o.calculateOrderPrice())
     return 1;
     else if(calculateOrderPrice()< o.calculateOrderPrice())
             return -1;
             else return 0;
  
}
    }




