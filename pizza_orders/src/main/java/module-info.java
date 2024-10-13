module com.example.project_2_1212585_s1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.pizza_orders to javafx.fxml;
    exports com.example.pizza_orders;
}