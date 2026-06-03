package com.example.FabrykaUrzadzenWeb.SpringBoot;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"nazwa", "prad", "napiecie", "moc"})
public class Silnik implements Urzadzenie {
    private double napiecie = 0;
    private double prad = 0;
    private String nazwa = "Silnik";

    @Override
    public double obliczMoc(){
        return napiecie * prad;
    };

    public Silnik(double napiecie,double prad){
        this.napiecie = napiecie;
        this.prad = prad;
    }

    public double getNapiecie() {
        return napiecie;
    }

    public double getPrad() {
        return prad;
    }

    public double getMoc() {
        return obliczMoc();
    }

    public String getNazwa(){
        return nazwa;
    }

}