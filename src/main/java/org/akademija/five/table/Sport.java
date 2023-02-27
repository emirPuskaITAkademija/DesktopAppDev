package org.akademija.five.table;

public enum Sport {
    ODBOJKA("Odbojka"),
    ŠAH("Šah"),
    KOŠARKA("Košarka"),
    SKIJANJE("Skijanje");

    private String name;

    Sport(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
