module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.javadoc;


    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
}