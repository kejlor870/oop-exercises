module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.KalkulatorElektryczny to javafx.fxml;
    exports com.example.KalkulatorElektryczny;
}