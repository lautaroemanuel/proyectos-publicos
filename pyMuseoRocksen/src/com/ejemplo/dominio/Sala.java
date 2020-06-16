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
public class Sala {

    private String nombre, ala;
    private int cantidad;
    private ObjetoExpuesto objetos[];
    private boolean capacidad = true;

    public Sala(String nombre, String ala, int cantidad) {
        this.nombre = nombre;
        this.ala = ala;
        this.cantidad = cantidad;
        this.objetos = new ObjetoExpuesto[cantidad];
    }

    public Sala() {
        nombre = "Sala ";
        ala = "";
        cantidad = 30;
        objetos = new ObjetoExpuesto[cantidad];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAla() {
        return ala;
    }

    public void setAla(String ala) {
        this.ala = ala;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isCapacidad() {
        return capacidad;
    }

    public boolean agregarObjeto(ObjetoExpuesto objeto) {

        for (int i = 0; i < cantidad; i++) {

            if (capacidad == true && objetos[i] == null) {
                objetos[i] = objeto;
                if (i + 1 == cantidad);
                capacidad = false;
                break;

            }
        }
        return capacidad;
    }

    public String mostrarDatos(int indice) {
        if (objetos[indice] != null) {
            return objetos[indice].toString();
        } else {
            return "Nada mas que mostrar";
        }
    }

    public String buscarObjeto(int antiguedad, int indice) {
        int antiguo = 0;
        ObjetoExpuesto objeto[] = new ObjetoExpuesto[1];
        Calendar cal = Calendar.getInstance();
        int yearact = cal.get(Calendar.YEAR);
        antiguo = yearact - antiguedad;
        if (objetos[indice] != null && objetos[indice].getAño() <= antiguo) {
            objeto[0] = objetos[indice];
            return objeto[0].toString();
        } else if (objetos[indice] != null && objetos[indice].getAño() > antiguo) {
            return "";
        } else {
            return "No se encuentran más objetos con la antigüedad ingresada";
        }
    }
}
