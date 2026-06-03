package com.example.FabrykaUrzadzenWeb.SpringBoot;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"nazwa", "prad", "napiecie", "moc"})
public class Zarowka implements Urzadzenie {
    private double napiecie = 0;
    private double prad = 0;
    private String nazwa = "Zarowka";

    @Override
    public double obliczMoc(){
       return napiecie * prad;
    };

    public Zarowka(double napiecie,double prad){
        this.napiecie = napiecie;
        this.prad = prad;
    }

    public String getNazwa(){
        return nazwa;
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
}
