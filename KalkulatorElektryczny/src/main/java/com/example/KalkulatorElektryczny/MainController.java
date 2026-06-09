package com.example.KalkulatorElektryczny;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainController {
    @FXML
    private ComboBox<String> typComboBox;

    @FXML
    private VBox inputSection1;
    @FXML
    private VBox inputSection2;
    @FXML
    private VBox inputSection3;

    @FXML
    private Label label1;
    @FXML
    private TextField pole1;

    @FXML
    private Label label2;
    @FXML
    private TextField pole2;

    @FXML
    private Label label3;
    @FXML
    private TextField pole3;

    @FXML
    private Label wynikLabel;

    private KalkulatorElektryczny kalkulator = new KalkulatorElektryczny();

    // Setting ComboBox options
    @FXML
    public void initialize(){
        typComboBox.getItems().addAll(
                "Wybierz typ obliczenia",
                "Prawo Ohma: Napięcie (U)",
                "Prawo Ohma: Natężenie (I)",
                "Prawo Ohma: Rezystancja (R)",
                "Rezystory szeregowo (2)",
                "Rezystory szeregowo (3)",
                "Rezystory równolegle (2)",
                "Rezystory równolegle (3)",
                "Moc elektryczna (P)",
                "Energia elektryczna (W)"
        );
    }

    // Show/hide inputs and configure Labels
    private void inputConfig(boolean visibilityF1, String label1Text, boolean visibilityF2, String label2Text, boolean visibilityF3, String label3Text){
        pole1.setVisible(visibilityF1); inputSection1.setVisible(visibilityF1); inputSection1.setManaged(visibilityF1); label1.setText(label1Text);
        pole2.setVisible(visibilityF2); inputSection2.setVisible(visibilityF2); inputSection2.setManaged(visibilityF2); label2.setText(label2Text);
        pole3.setVisible(visibilityF3); inputSection3.setVisible(visibilityF3); inputSection3.setManaged(visibilityF3); label3.setText(label3Text);
    }

    @FXML
    public void onTypObliczeniaChanged(){
        String choosed = typComboBox.getValue();

        if(choosed == null) return;

        pole1.clear();
        pole2.clear();
        pole3.clear();

        wynikLabel.setText("Wprowadź dane i kliknij Oblicz");

        switch (choosed) {
            case "Wybierz typ obliczenia":
                inputConfig(true, "Pole 1", true, "Pole 2", true, "Pole 3");
                break;
            case "Prawo Ohma: Napięcie (U)":
                inputConfig(true, "Natężenie I [A]", true, "Opór R", false, "");
                break;
            case "Prawo Ohma: Natężenie (I)":
                inputConfig(true, "Natężenie U [V]", true, "Opór R", false, "");
                break;
            case "Prawo Ohma: Rezystancja (R)":
                inputConfig(true, "Natężenie U [V]", true, "Opór I [A]", false, "");
                break;
            case "Rezystory szeregowo (2)":
                inputConfig(true, "Rezystor R1", true, "Rezystor R2", false, "");
                break;
            case "Rezystory szeregowo (3)":
                inputConfig(true, "Rezystor R1", true, "Rezystor R2", true, "Rezystor R3");
                break;
            case "Rezystory równolegle (2)":
                inputConfig(true, "Rezystor R1", true, "Rezystor R2", false, "");
                break;
            case "Rezystory równolegle (3)":
                inputConfig(true, "Rezystor R1", true, "Rezystor R2", true, "Rezystor R3");
                break;
            case "Moc elektryczna (P)":
                inputConfig(true, "Napięcie U [V]", true, "Natężenie I [A]", false, "");
                break;
            case "Energia elektryczna (W)":
                inputConfig(true, "Napięcie U [V]", true, "Natężenie I [A]", true, "Czas t [s]");
                break;
        }
    }

    @FXML
    public void onObliczClick(){
        String choosed = typComboBox.getValue();

        if(choosed == null || choosed.equals("Wybierz typ obliczenia")){
            wynikLabel.setText("Błąd: Wybierz najpierw operację!");
            return;
        }

        try{
            double p1 = 0;
            double p2 = 0;
            double p3 = 0;

            if(inputSection1.isVisible()) p1 = checkInput(pole1);
            if(inputSection2.isVisible()) p2 = checkInput(pole2);
            if(inputSection3.isVisible()) p3 = checkInput(pole3);

            String resultLetter = "";
            double result = 0;
            String unit = "";

            switch (choosed) {
                case "Prawo Ohma: Napięcie (U)":
                    resultLetter = "U = ";
                    result = kalkulator.obliczNapiecie(p1, p2);
                    unit = "V";
                    break;
                case "Prawo Ohma: Natężenie (I)":
                    resultLetter = "I = ";
                    result = kalkulator.obliczNatezenie(p1, p2);
                    unit = "A";
                    break;
                case "Prawo Ohma: Rezystancja (R)":
                    resultLetter = "R = ";
                    result = kalkulator.obliczOpor(p1, p2);
                    unit = "Ω";
                    break;
                case "Rezystory szeregowo (2)":
                    resultLetter = "R = ";
                    result = kalkulator.szeregowo(p1, p2);
                    unit = "Ω";
                    break;
                case "Rezystory szeregowo (3)":
                    resultLetter = "R = ";
                    result = kalkulator.szeregowo(p1, p2, p3);
                    unit = "Ω";
                    break;
                case "Rezystory równolegle (2)":
                    resultLetter = "R = ";
                    result = kalkulator.rownolegle(p1, p2);
                    unit = "Ω";
                    break;
                case "Rezystory równolegle (3)":
                    resultLetter = "R = ";
                    result = kalkulator.rownolegle(p1, p2, p3);
                    unit = "Ω";
                    break;
                case "Moc elektryczna (P)":
                    resultLetter = "P = ";
                    result = kalkulator.obliczMoc(p1, p2);
                    unit = "W";
                    break;
                case "Energia elektryczna (W)":
                    resultLetter = "W = ";
                    result = kalkulator.obliczMoc(p1, p2, p3);
                    unit = "J";
                    break;
            }

            wynikLabel.setText("Wynik: " + resultLetter + result + " " + unit);

        }catch(NumberFormatException e){
            wynikLabel.setText(e.getMessage());
        }
    }

    // Validation field input
    public double checkInput(TextField field){
        String text = field.getText().trim().replace(",", ".");

        // Prevent empty input
        if(text.isEmpty()){
            throw new NumberFormatException("Błąd: Pola nie mogą być puste!");
        }

        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Błąd: Wartość musi być liczbą!");
        }
    }

}
