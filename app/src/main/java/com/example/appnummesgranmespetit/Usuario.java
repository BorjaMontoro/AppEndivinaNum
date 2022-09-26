package com.example.appnummesgranmespetit;

public class Usuario {
    String nombre;
    int intentos;
    Usuario(String nombre,int intentos){
        this.nombre=nombre;
        this.intentos=intentos;
    }

    @Override
    public String toString() {
        return nombre+"     "+intentos;
    }
}
