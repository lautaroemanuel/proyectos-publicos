/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dominio;

import java.util.Calendar;

/**
 *
 * @author lautaro
 */
public abstract class ObjetoExpuesto {

    private int codigo, año;
    private String nombre, origen;

    public ObjetoExpuesto(int codigo, int año, String nombre, String origen) {
        this.codigo = codigo;
        this.año = año;
        this.nombre = nombre;
        this.origen = origen;

    }

    public ObjetoExpuesto() {

        codigo = 00;
        año = 0000;
        nombre = "S/D";
        origen = "S/D";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public abstract String mostrarNombre();

    @Override
    public abstract String toString();

    public String compareTo(int age1, int age2, String nombre1, String nombre2) {
              Calendar cal = Calendar.getInstance();
              int yearact = cal.get(Calendar.YEAR);
        return nombre1 + " Años de antigüedad" + (yearact - age1) + "/n" + nombre2 + " Años de antigüedad" + (yearact - age2);
    }

}
