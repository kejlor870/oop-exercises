package com.example.KalkulatorElektryczny;

public class KalkulatorElektryczny {
    // Prawo Ohma
    public double obliczNapiecie(double I, double R){
        return I * R;
    }
    public double obliczNatezenie(double U, double R){
        if (R == 0) throw new ArithmeticException("Dzielenie przez zero! Rezystancja nie może wynosić 0.");
        return U / R;
    }

    public double obliczOpor(double U, double I){
        if (I == 0) throw new ArithmeticException("Dzielenie przez zero! Natężenie nie może wynosić 0 A.");
        return U / I;
    }

    // Rezystory szeregowo
    public double szeregowo(double R1, double R2){
        return R1 + R2;
    }
    public double szeregowo(double R1, double R2, double R3){
        return R1 + R2 + R3;
    }

    // Rezystory równolegle
    double rownolegle(double R1, double R2){
        if (R1 == 0 || R2 == 0) throw new ArithmeticException("Rezystancja w połączeniu równoległym nie może wynosić 0.");
        return 1 / (1/R1 + 1/R2);
    }
    double rownolegle(double R1, double R2, double R3){
        if (R1 == 0 || R2 == 0 || R3 == 0) throw new ArithmeticException("Rezystancja w połączeniu równoległym nie może wynosić 0.");
        return 1 / (1/R1 + 1/R2 + 1/R3);
    }

    // Moc i energia
    double obliczMoc(double U, double I){
        return U * I;
    }
    double obliczMoc(double U, double I, double t){
        return U * I * t;
    }
}
