package com.example.FabrykaUrzadzenWeb.SpringBoot;


import java.util.ArrayList;
import java.util.List;


public class DevicesList {

    private List<Urzadzenie> listaUrzadzen = new ArrayList<>();

    public void addNewDeviceToList(Urzadzenie urzadzenie){
        listaUrzadzen.add(urzadzenie);
    }

    public List getListaUrzadzen(){
        return listaUrzadzen;
    }

}
