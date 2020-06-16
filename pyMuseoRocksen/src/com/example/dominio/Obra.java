package com.example.dominio;

/**
 *
 * @author lautaro
 */
public class Obra extends ObjetoExpuesto {

    String autor = "";

    public Obra() {
        super();
        autor = "S/D";
    }

    public Obra(int codigo, int año, String nombre, String autor, String origen) {
        super(codigo, año, nombre, origen);
        this.autor = autor;
    }

    @Override
    public String mostrarNombre() {
        return getNombre() + "(" + autor + ")";
    }

    @Override
    public String toString() {

        return "Codigo de la obra " + getCodigo() + " Nombre de la obra: " + getNombre() + " Año en el que fue realizada la obra: " + getAño() + "/n"
                + " Autor de la obra: " + autor + " Paiz de origen de la obra: " + getOrigen();
    }

    @Override
    public String compareTo(int age1, int age2, String nombre1, String nombre2) {
        return super.compareTo(age1, age2, nombre1, nombre2);
    }

}
