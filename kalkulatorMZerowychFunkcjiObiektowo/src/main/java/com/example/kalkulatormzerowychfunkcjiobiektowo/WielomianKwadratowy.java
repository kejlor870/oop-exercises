package com.example.kalkulatormzerowychfunkcjiobiektowo;

public class WielomianKwadratowy {
    private Double a;
    private Double b;
    private Double c;

    public WielomianKwadratowy(Double a, Double b, Double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private Double obliczDelte(){
        return b*b - 4*a*c;
    }

    public Wynik obliczMiejscaZerowe(){
        Double delta = obliczDelte();

        if(delta < 0){
            return new Wynik(delta, null, null, "Brak miejsc zerowych");
        }else if(delta == 0){
            double x = -b/(2*a);
            return new Wynik(delta, x, null, "Jest jedno miejsce zerowe");
        }else{
            double x1 = (-b - Math.sqrt(delta))/(2*a);
            double x2 = (-b + Math.sqrt(delta))/(2*a);
            return new Wynik(delta, x1, x2, "Sa dwa miejsca zerowe");
        }
    }
}
