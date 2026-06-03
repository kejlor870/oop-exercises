package com.example.FabrykaUrzadzenWeb.SpringBoot;

public class DevicesFactory {

    public Urzadzenie utworzUrzadzenie(double prad, double napiecie, String jakie){
        if (jakie.equals("zarowka")) return new Zarowka(prad, napiecie);
        if (jakie.equals("silnik")) return new Silnik(prad, napiecie);
        if (jakie.equals("grzejnik")) return new Grzejnik(prad, napiecie);

        return null;
    }

}
