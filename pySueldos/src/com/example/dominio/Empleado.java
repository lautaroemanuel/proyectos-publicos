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
public class Empleado extends Trabajador {

    private int  hsExtra;

    public Empleado(int legajo, int sueldo, int hsExtra, String nombre, String fechaDeC, String puesto) {
        super(legajo, nombre, fechaDeC, puesto);
        this.hsExtra = hsExtra;
            setSueldo(70000);
    }

    public Empleado() {
        hsExtra = 0;
    }

    public int getHsExtra() {
        return hsExtra;
    }

    public void setHsExtra(int hsExtra) {
        this.hsExtra = hsExtra;
    }

    @Override
    public int calcularPaga() {
        setSueldo(getSueldo()+ (300 * hsExtra));
        return getSueldo();
    }

    @Override
    public String toString() {
        return super.toString() + " Hs extra totales del mes: " + hsExtra + " Sueldo final del mes: $" + getSueldo();
    }

}
