/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.dominio.Historico;
import com.example.dominio.Obra;
import com.example.dominio.Sala;
import java.util.Scanner;

/**
 *
 * @author lautaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        int op = 0;
        int cantidad = 0;
        String nombre = "";
        String ala = "";
        int numSalas = 0;

        do {
            System.out.println("Cuantas salas desea añadir");
            numSalas = in.nextInt();
        } while (numSalas <= 0);
        Sala sala[] = new Sala[numSalas];
        for (int i = 0; i < numSalas; i++) {
            System.out.println("Escriba el nombre de la sala numero " + (i + 1));
            nombre = in2.nextLine();
            System.out.println("Escriba el ala a la que pertenece la sala");
            ala = in2.nextLine();
            do {
                System.out.println("¿Cuantos objetos desea añadir en la sala " + (i + 1) + "?");
                cantidad = in.nextInt();
            } while (cantidad <= 0);
            sala[i] = new Sala(nombre, ala, cantidad);
        }

        do {

            System.out.println("Bienvenido al sistema de control de exposiciones del museo Rocksen. Seleccione a continuacion lo que desea hacer");
            System.out.println("1) Agregar objeto");
            System.out.println("2) Mostrar todos los objetos que expuestos en una determinada sala");
            System.out.println("3) Buscar objetos por antigụedad");
            System.out.println("4) Salir");
            op = in.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Selecciona el tipo de objeto que deseas añadir");
                    System.out.println("1) Objeto historico");
                    System.out.println("2) Obra de arte");
                    int op2 = in.nextInt();

                    switch (op2) {

                        case 1:
                            int salaAct = 0;
                            do {

                                if (numSalas > 1) {
                                    do {
                                        System.out.println("¿En cual de las " + numSalas + " disponibles desea añadir el objeto? (inserte un numero del 1 al " + numSalas + ")");
                                        salaAct = in.nextInt() - 1;
                                    } while (salaAct <0 || salaAct >=numSalas);
                                } else {
                                    salaAct = 0;
                                }
                            } while (salaAct > numSalas);
                            if (sala[salaAct].isCapacidad() == false) {
                                System.out.println("La sala seleccionada esta llena");
                                break;
                            }
                            System.out.println("Ingrese el codigo del objeto");
                            int codigo = in.nextInt();
                            System.out.println("Ingrese el año de creacion del objeto");
                            int año = in.nextInt();
                            System.out.println("Ingrese el nombre del objeto historico");
                            String nombre1 = in2.nextLine();
                            System.out.println("Ingrese el origen del objeto");
                            String origen = in2.nextLine();
                            sala[salaAct].agregarObjeto(new Historico(codigo, año, nombre1, origen));

                            break;

                        case 2:
                            do {

                                if (numSalas > 1) {
                                    do {
                                        System.out.println("¿En cual de las " + numSalas + " disponibles desea añadir la obra? (inserte un numero del 1 al " + numSalas + ")");
                                        salaAct = in.nextInt() - 1;
                                    } while (salaAct <0 || salaAct >=numSalas);
                                } else {
                                    salaAct = 0;
                                }
                            } while (salaAct > numSalas);
                            if (sala[salaAct].isCapacidad() == false) {
                                System.out.println("La sala seleccionada esta llena");
                                break;
                            }
                            System.out.println("Ingrese el codigo de la obra");
                            codigo = in.nextInt();
                            System.out.println("Ingrese el año de creacion de la obra");
                            año = in.nextInt();
                            System.out.println("Ingrese el nombre de la obra");
                            nombre1 = in2.nextLine();
                            System.out.println("Ingrese el autor de la obra");
                            String autor = in2.nextLine();
                            System.out.println("Ingrese el lugar de origen de la obra");
                            origen = in2.nextLine();
                            sala[salaAct - 1].agregarObjeto(new Obra(codigo, año, origen, autor, nombre1));
                            break;
                        default:
                            System.out.println("Opcion no valida");

                    }
                    break;

                case 2:
                    int salaAct = 0;
                    do {

                        if (numSalas > 1) {
                            System.out.println("¿De cual de las " + numSalas + " disponibles desea mostrar los objetos? (inserte un numero del 1 al " + numSalas + ")");
                            salaAct = in.nextInt();
                        } else {
                            salaAct = 1;
                        }
                    } while (salaAct > numSalas);
                    int cant = sala[salaAct - 1].getCantidad();
                    for (int i = 0; i < cant; i++) {

                        System.out.println(sala[salaAct - 1].mostrarDatos(i));
                    }
                    break;
                case 3:
                    System.out.println("Ingresa la antiguedad por la que deseas filtrar los resultados (ej: 100, 200, 300, etc)");
                    int antiguedad = in.nextInt();
                    for (int i = 0; i < numSalas; i++) {
                        for (int j = 0; j < cantidad; j++) {
                            sala[i].buscarObjeto(antiguedad, i);
                            System.out.println(sala[i].buscarObjeto(antiguedad, j));
                        }
                    }

                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (op != 4);
    }

}
