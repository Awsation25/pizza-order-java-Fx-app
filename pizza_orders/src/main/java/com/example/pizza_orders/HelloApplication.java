package com.example.pizza_orders;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.String;
public class HelloApplication extends Application {
    // define array list of pizza order named orders
    // we moved it here so we  can use  it in hte whole class
     private static ArrayList<PizzaOrder> orders=new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        // define border pane to deal with the GUI
        BorderPane bp = new BorderPane();
        //Design the GUI using textlabels,textfields,radio buttuns,check buttuns,combo box
        Label toplapel = new Label("Pizza Order");
        toplapel.setFont(new Font(20));
        bp.setTop(toplapel);
        bp.setAlignment(toplapel, Pos.TOP_CENTER);

        GridPane gp = new GridPane();
        gp.setVgap(20);
        Label customerName = new Label("customerName");
        gp.add(customerName,0,0);
       gp.setAlignment(Pos.CENTER);
        customerName.setFont(new Font(15));
        TextField name = new TextField();
        name.setMaxSize(100,10);
        gp.add(name,1,0);
        gp.setHgap(20);
        Label ordertype1 = new Label("Order Type");
        ordertype1.setFont(new Font(15));
        gp.add(ordertype1,0,1);
        //define 3 radio buttuns
        RadioButton toGo = new RadioButton("ToGo");
        RadioButton Delivery = new RadioButton("Delivery");
        TextField tripratetext = new TextField();
        TextField zonetext = new TextField();
        RadioButton Seated = new RadioButton("Seated");
        TextField num = new TextField();
        TextField service = new TextField();

        //set togo buttun default selected
        toGo.setSelected(true);
        ToggleGroup tg = new ToggleGroup();
        toGo.setToggleGroup(tg);
        Delivery.setToggleGroup(tg);
        Seated.setToggleGroup(tg);
        //define horizantal box
        HBox ordertype = new HBox(toGo,Delivery,Seated);
        ordertype.setSpacing(20);
        gp.add(ordertype,1,1);
        Label pizzaorder = new Label("Pizza Size");
        pizzaorder.setFont(new Font(15));
        gp.add(pizzaorder,0,2);
        //define combobox
        ComboBox<String> pizzasize = new ComboBox<>();
        pizzasize.getItems().addAll("LARGE","MEDIUM","SMALL");
        pizzasize.getSelectionModel().select(2);
        gp.add(pizzasize,1,2);
        Label Listoftoppings=new Label("List of toppings");
        Listoftoppings.setFont(new Font(15));
        gp.add(Listoftoppings,0,3);
        //define 4 check boxes
        CheckBox Onion = new CheckBox("Onion");
        CheckBox Olives = new CheckBox("Olives");
        CheckBox Greenpeppers = new CheckBox("Greenpeppers");
        CheckBox tomatos = new CheckBox("Tomatos");
        VBox listoftoppings = new VBox(Onion,Olives,Greenpeppers,tomatos);
        gp.add(listoftoppings,1,3);
        Label Toppingprice = new Label("Topping Price");
        Toppingprice.setFont(new Font(15));
        gp.add(Toppingprice,0,4);
        // define text field with default value "10"
        TextField topiingprice = new TextField("10");
        topiingprice.setMaxSize(100,10);
        gp.add(topiingprice,1,4);
        Label Pizzaorder = new Label("Order Price");
        Pizzaorder.setFont(new Font(15));
        gp.add(Pizzaorder,0,5);
        // define text field with default value "0.0"
        TextField Price = new TextField("0.0");
        Price.setMaxSize(100,10);
        gp.add(Price,1,5);
        bp.setCenter(gp);
        //create 3 buttuns and set them in the bottom
        Button processorder = new Button("ProcessOrder");
        bp.setBottom(processorder);
        bp.setAlignment(processorder,Pos.BASELINE_LEFT);
        Button printorders = new Button("PrintOrders");
        bp.setBottom(printorders);

        bp.setAlignment(printorders,Pos.BASELINE_CENTER);
        Button reset = new Button("Reset");
        bp.setBottom(reset);
        bp.setAlignment(reset,Pos.BASELINE_RIGHT);
        HBox bottons = new HBox(processorder,printorders,reset);
        bottons.setSpacing(20);
         bp.setBottom(bottons);
        gp.add(bottons,1,7);
        bottons.setSpacing(10);
        Scene scene =new Scene(bp,600,600);
        stage.setTitle("Pizza order");
        stage.setScene(scene);
        stage.show();
        // if togo isselcted cleare the index 2 of boarder pane
        toGo.setOnAction(e->{
            bp.getChildren().remove(2);
        });
        // if Delivery is selcted this actions to do
        Delivery.setOnAction(e-> {
                    Label tripratelabel = new Label("Trip Rate");
                    HBox triprate = new HBox(tripratelabel, tripratetext);
                    tripratetext.setMaxSize(60, 10);
                    triprate.setSpacing(20);
                    Label zone = new Label("Zone");
                    zonetext.setMaxSize(60, 10);
                    HBox zonebox = new HBox(zone, zonetext);
                    zonebox.setSpacing(20);
                    zonebox.setLayoutX(100);
                    VBox delivery = new VBox(triprate, zonebox);
                    delivery.setSpacing(15);
                    bp.setRight(delivery);
                    delivery.setAlignment(Pos.CENTER);
                    Scene deliveryscene = new Scene(bp, 400, 400);
                    stage.setScene(deliveryscene);
                });
        // if Seated is selcted this actions to do
            Seated.setOnAction(a->{
                Label numofpeople = new Label("number of people");
            num.setMaxSize(50,10);
             HBox numberofpeople = new HBox(numofpeople,num);
            numberofpeople.setSpacing(15);
            Label serviceCharge = new Label("Service Charge");
            service.setMaxSize(50,10);
            HBox serivcecharge = new HBox(serviceCharge,service);
            serivcecharge.setSpacing(15);
            VBox  seated = new VBox(numberofpeople,serivcecharge);
            seated.setSpacing(15);
            bp.setRight(seated);
            seated.setAlignment(Pos.CENTER);
            Scene seatedscene = new Scene(bp,400,400);
            stage.setScene(seatedscene);

        });
        // if reset is selcted this actions to do
        reset.setOnAction(actionEvent->{
            // the reset buttun return everything thing in theGUI to its default value
            name.clear();
            toGo.setSelected(true);
            pizzasize.getSelectionModel().select(2);
            Olives.setSelected(false);
            Onion.setSelected(false);
            Greenpeppers.setSelected(false);
            tomatos.setSelected(false);
            topiingprice.setText("10");
            Price.setText("0.0");
            tripratetext.setText("");
            service.setText("");
            zonetext.setText("");
            num.setText("");
            orders.clear();
             bp.getChildren().remove(2);
        });

        //if processorder is selected this actions to do
        processorder.setOnAction(e->{
            int x=0;

            if (Onion.isSelected())
                x++;
             if (Olives.isSelected())
                x++;
             if (Greenpeppers.isSelected())
                x++;
             if(tomatos.isSelected())
                 x++;

            int size=0 ;
            if(pizzasize.getValue().equals("SMALL"))
                size = PizzaOrder.SMALL;
            else if (pizzasize.getValue().equals("MEDIUM"))
                size = PizzaOrder.MEDIUM;
            else if (pizzasize.getValue().equals("LARGE"))
                size = PizzaOrder.LARGE;
            //create objects of PizzaOrder
            PizzaOrder togo;
            PizzaOrder delivery;
            PizzaOrder seated;
            // fill the new objects ,and fill the array list
            if(toGo.isSelected()) {
                togo = new ToGo(name.getText(), size, x, Double.parseDouble(topiingprice.getText()));
                orders.add(togo);
                Price.setText(""+togo.calculateOrderPrice());
            }
               if(Delivery.isSelected()) {
                   delivery = new Delivery(name.getText(), size, x, Double.parseDouble(topiingprice.getText()), Double.parseDouble(tripratetext.getText()), Integer.parseInt(zonetext.getText()));
                    orders.add(delivery);
                    Price.setText(""+delivery.calculateOrderPrice());
               }
            if(Seated.isSelected()) {
                seated = new Seated(name.getText(), size, x, Double.parseDouble(topiingprice.getText()), Double.parseDouble(service.getText()), Integer.parseInt(num.getText()));
                orders.add(seated);
                Price.setText(""+seated.calculateOrderPrice());
            }

        });

        // if printorders clicked thenit will print the orders info in the array list orders
        printorders.setOnAction(e->{
            SortOrder(orders);
            Stage printstage = new Stage();
            TextArea print = new TextArea();
            print.setFont(new Font(20));
            String orderinfo ="";

            for(int i=0;i<orders.size();i++)
               orderinfo +=orders.get(i).printOrderInfo()+"\n";

            print.setText(orderinfo);
            Scene printscene = new Scene(print,400,400);
            printstage.setScene(printscene);
            printstage.setTitle("print orders info");
            printstage.show();
        });


        }

    public static void main(String[] args) {
        launch(args);

    }
    //method to calculate the totalorder price and it takes array list as an argument
    public static double calculateTotalOrdersPrice(ArrayList<PizzaOrder>arr){
        double sum=0 ;
        for (int i =0;i<arr.size();i++)
            sum+= arr.get(i).calculateOrderPrice();
        return sum;
    }
    //method to sort the orders in the array list depends on totalprice and it takes array list as argument
    public static void SortOrder(ArrayList<PizzaOrder>arr_list){
        Collections.sort(arr_list);
    }

}