module com.example.kalkulatormzerowychfunkcjiobiektowo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kalkulatormzerowychfunkcjiobiektowo to javafx.fxml;
    exports com.example.kalkulatormzerowychfunkcjiobiektowo;
}