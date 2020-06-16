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
public class Empresa {

    private String cuit, razonSocial;
    private Trabajador empleados[];

    public Empresa(String cuit, String razonSocial) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.empleados = new Trabajador[30];
    }

    public Empresa() {
        cuit = "23-48644943-3";
        razonSocial = "ChoriSoft-Entreprise-TeneHoraAmego";
        empleados = new Trabajador[30];

    }

    public boolean agregarEmpleado(Trabajador empleado) {
        boolean flag = false;

        for (int i = 0; i < 30; i++) {

            if (empleados[i] == null) {
                empleados[i] = empleado;
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean incrementarSueldo(int porc, String nombre) {
        boolean flag = false;
        Empleado e = null;
        int sueldo;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] instanceof Empleado && empleados[i].getNombre().equals(nombre)) {
                sueldo = empleados[i].getSueldo() * porc / 100;
                empleados[i].setSueldo(sueldo);
                flag = true;
                break;
            } else {
                flag = false;
            }

        }
        return flag;
    }

    public int presupustoMensual() {
        int presupuesto = 0;

        for (Trabajador empleado : empleados) {
            presupuesto += empleado.getSueldo();
        }

        return presupuesto;
    }

    public boolean setearHsConsultores(int hs, String nombre) {
        boolean flag = false;
        Consultor e = new Consultor();
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] instanceof Consultor && empleados[i].getNombre().equals(nombre)) {
                //hs = empleados[i]
                e = (Consultor) empleados[i];
                e.setCantHs(hs);
                empleados[i] = e;
                flag = true;
                break;
            } else {
                flag = false;
            }

        }
        return flag;

    }

    public boolean setearPrecioHs(int precio, String nombre) {
        boolean flag = false;
        Consultor e = new Consultor();
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] instanceof Consultor && empleados[i].getNombre().equals(nombre)) {
                //hs = empleados[i]
                e = (Consultor) empleados[i];
                e.setValorHs(precio);
                empleados[i] = e;
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }

}
