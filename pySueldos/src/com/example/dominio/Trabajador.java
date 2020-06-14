/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dominio;

/**
 *
 * @author lautaro
 */
public abstract class Trabajador {
    private int legajo, sueldo;
    private String nombre, fechaDeC,puesto;

    public Trabajador(int legajo, String nombre, String fechaDeC, String puesto) {
        this.legajo = legajo;
        this.sueldo = sueldo;
        this.nombre = nombre;
        this.fechaDeC = fechaDeC;
        this.puesto = puesto;
    }

    public Trabajador() {
        
      legajo = 00;
      sueldo = 0;
      nombre = "S/D";
      fechaDeC = "00/00/0000";
      puesto ="S/D";
    }
    
    
  
    
    public abstract int calcularPaga();

    @Override
    public String toString() {
        return "Nombre del empleado: "+nombre+" Legajo:  "+legajo+" Fecha de contrato: "+ fechaDeC + " Puesto: " + puesto;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDeC() {
        return fechaDeC;
    }

    public void setFechaDeC(String fechaDeC) {
        this.fechaDeC = fechaDeC;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
   
    
}
