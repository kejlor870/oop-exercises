package com.example.kalkulatormzerowychfunkcjiobiektowo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class KalkulatorController {
    @FXML
    private TextField poleA;
    @FXML
    private TextField poleB;
    @FXML
    private TextField poleC;
    @FXML
    private Label labelWynik;

    @FXML
    public void oblicz(ActionEvent actionEvent) {
        try{
            Double a = Double.parseDouble(poleA.getText());
            Double b = Double.parseDouble(poleB.getText());
            Double c = Double.parseDouble(poleC.getText());

            if(a == 0){
                labelWynik.setText("To nie jest rownanie kwadratowe! (a = 0)");
                return;
            }

            WielomianKwadratowy wielomianKwadratowy = new WielomianKwadratowy(a, b, c);
            Wynik wynik = wielomianKwadratowy.obliczMiejscaZerowe();

            String tekst = wynik.getKomunikat() + "\nDelta: " + String.format("%.5f", wynik.getDelta());

            if(wynik.getX1() != null && wynik.getX2() == null){
                tekst += "\nx0: " + String.format("%.5f", wynik.getX1());
            } else if (wynik.getX1() != null ) {
                tekst += "\nx1: " + String.format("%.5f", wynik.getX1()) + " | x2: " + String.format("%.5f", wynik.getX2());
            }

            labelWynik.setText(tekst);

        }catch (NumberFormatException e){
            labelWynik.setText("Blad: wprowadz poprawne liczby!");
        }
    }
}
