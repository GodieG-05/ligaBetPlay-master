package com.ligabetplay.models;

public class Emparejamiento {
    Equipo equipo1;
    Equipo equipo2;

    public Emparejamiento (Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }
    public Equipo getEquipo1(){
        return equipo1;
    }
    public Equipo getEquipo2(){
        return equipo2;
    }
    public String toString(){
        return equipo1.getNombre() + " vs " + equipo2.getNombre();
    }
    
}


