package com.ligabetplay.models;

public class Team {
    protected String nombre;
    protected int edad;
    protected char sexo;
    protected String rol;

    public Team(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Team (String nombre, int edad, char sexo, String rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.rol = rol;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
    
}
