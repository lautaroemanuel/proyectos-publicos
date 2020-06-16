package com.example.dominio;

/**
 *
 * @author lautaro
 */
public class Historico extends ObjetoExpuesto {

    public Historico(int codigo, int año, String nombre, String origen) {
        super(codigo, año, nombre, origen);
    }

    public Historico() {
        super();
    }

    @Override
    public String mostrarNombre() {
        return getNombre() + "(" + getOrigen() + ")";
    }

    @Override
    public String compareTo(int age1, int age2, String nombre1, String nombre2) {
        return super.compareTo(age1, age2, nombre1, nombre2);
    }

    @Override
    public String toString() {
        return "Codigo del objeto " + getCodigo() + " Nombre del objeto: " + getNombre() + " Año aproximado de creaciòn: " + getAño() + "/n"
                + " Zona de origen: " + getOrigen();
    }

}
