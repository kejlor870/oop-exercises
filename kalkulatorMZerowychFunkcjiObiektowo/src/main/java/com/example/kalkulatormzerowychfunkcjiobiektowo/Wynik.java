package com.example.kalkulatormzerowychfunkcjiobiektowo;

public class Wynik {
    private Double delta;
    private Double x1;
    private Double x2;
    private String komunikat;

    public Wynik(double delta, Double x1, Double x2, String komunikat){
        this.delta = delta;
        this.x1 = x1;
        this.x2 = x2;
        this.komunikat = komunikat;
    }

    public double getDelta(){
        return delta;
    }

    public Double getX1(){
        return x1;
    }

    public Double getX2(){
        return x2;
    }

    public String getKomunikat(){
        return komunikat;
    }
}
