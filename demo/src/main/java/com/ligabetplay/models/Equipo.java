package com.ligabetplay.models;

public class Equipo {
    String nombre;
    int PJ;
    int PG;
    int PE;
    int PP;
    int GF;
    int GC;
    int TP;
    public Equipo(String nombre){
        this.nombre = nombre;
    }
    public Equipo(String nombre, int PJ, int PG, int PE, int PP, int GF, int GC, int TP) {
        this.nombre = nombre;
        this.PJ = PJ;
        this.PG = PG;
        this.PE = PE;
        this.PP = PP;
        this.GF = GF;
        this.GC = GC;
        this.TP = TP;            
    }
    public String getNombre() {
        return nombre;
    }
    public int getPJ() {
        return PJ;
    }
    public int getPG() {
        return PG;
    }
    public int getPE() {
        return PE;
    }
    public int getPP() {
        return PP;
    }
    public int getGF() {
        return GF;
    }
    public int getGC() {
        return GC;
    }
    public int getTP() {
        return TP;
    }
    public String toString() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPJ(int PJ){
        this.PJ = PJ;
    }
    public void setPG(int PG){
        this.PG = PG;
    }
    public void setPE(int PE){
        this.PE = PE;
    }
    public void setPP(int PP){
        this.PP = PP;
    }
    public void setGF(int GF){
        this.GF = GF;
    }
    public void setGC(int GC){
        this.GC = GC;
    }
    public void setTP(int TP){
        this.TP = TP;
    }


}