package com.example.FabrykaUrzadzenWeb.SpringBoot;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    private DevicesFactory devicesFactory = new DevicesFactory();
    private DevicesList devicesList = new DevicesList();

    @GetMapping("/zarowka")
    public String zarowka(@RequestParam(defaultValue = "5") double prad, @RequestParam(defaultValue = "230") double napiecie){
        devicesList.addNewDeviceToList(devicesFactory.utworzUrzadzenie(prad, napiecie,"zarowka"));

        return "Wyprodukowano żarówkę!";
    }

    @GetMapping("/silnik")
    public String silnik(@RequestParam(defaultValue = "4.5") double prad, @RequestParam(defaultValue = "400") double napiecie){
        devicesList.addNewDeviceToList(devicesFactory.utworzUrzadzenie(prad, napiecie,"silnik"));

        return "Wyprodukowano silnik!";
    }

    @GetMapping("/grzejnik")
    public String grzejnik(@RequestParam(defaultValue = "8.7") double prad, @RequestParam(defaultValue = "230") double napiecie){
        devicesList.addNewDeviceToList(devicesFactory.utworzUrzadzenie(prad, napiecie,"grzejnik"));

        return "Wyprodukowano grzejnik!";
    }

    @GetMapping("/lista")
    public DevicesList lista(){
        return devicesList;
    }

}
