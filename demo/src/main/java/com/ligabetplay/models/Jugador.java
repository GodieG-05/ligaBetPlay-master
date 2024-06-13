package com.ligabetplay.models;
import java.util.Date;

public class Jugador extends Team {
    private int dorsal;
    private String posicion;
    private String nacionalidad;
    private Date fechaIngreso;
    private int golesAnotados;
    private int totalTA;
    private int totalTR;
    public Jugador(String nombre, int edad, int dorsal, String posicion, String nacionalidad, Date fechaIngreso,
            int golesAnotados, int totalTA, int totalTR) {
        super(nombre, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
        this.golesAnotados = golesAnotados;
        this.totalTA = totalTA;
        this.totalTR = totalTR;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public int getGolesAnotados() {
        return golesAnotados;
    }
    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    public int getTotalTA() {
        return totalTA;
    }
    public void setTotalTA(int totalTA) {
        this.totalTA = totalTA;
    }
    public int getTotalTR() {
        return totalTR;
    }
    public void setTotalTR(int totalTR) {
        this.totalTR = totalTR;
    }
    
}

