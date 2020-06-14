/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.dominio.Consultor;
import com.example.dominio.Empleado;
import com.example.dominio.Empresa;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Empresa empresa1 = new Empresa();
        int op = 0;
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        do {

            System.out.println("Bienvenido al programa de Control de Sueldos de la Empresa. Seleccione lo que desea hacer: ");
            System.out.println("");
            System.out.println("1) Agregar empleado");
            System.out.println("2) Incrementar sueldo");
            System.out.println("3) Agregar hs trabajadas mensuales a un consultor");
            System.out.println("4) Incrementar el valor de hs de un consultor");
            System.out.println("5) Mostrar presupuesto mensual");
            System.out.println("6) Salir");
            op = in.nextInt();
            switch (op) {

                case 1:
                    int op2 = 0,
                     cantidad = 0;
                    System.out.println("Ingrese la cantidad de trabajadores que desea añadir: ");
                    cantidad = in.nextInt();
                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("Seleccione el tipo de Trabajador que desea añadir");
                        System.out.println("1) Empleado fijo ");
                        System.out.println("2) Consultor");
                        op2 = in.nextInt();
                        switch (op2) {
                            case 1:
                                System.out.println("Ingrese el nombre del empleado");
                                String nombre = in2.nextLine();
                                System.out.println("Introduzca el número de legajo");
                                int legajo = in.nextInt();
                                System.out.println("Incerte el sueldo base del empleado");
                                int sueldo = in.nextInt();
                                SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/YYYY");
                                String fechaDeC = fecha.format(new Date());
                                System.out.println("Inserte el puesto que ocupa");
                                String puesto = in2.nextLine();

                                empresa1.agregarEmpleado(new Empleado(legajo, sueldo, 0, nombre, fechaDeC, puesto));
                                break;

                            case 2:
                                System.out.println("Ingrese el nombre del consultor");
                                nombre = in2.nextLine();
                                System.out.println("Introduzca el número de legajo");
                                legajo = in.nextInt();
                                System.out.println("Incerte el valor de hora base");
                                int valorHs = in.nextInt();
                                SimpleDateFormat fecha1 = new SimpleDateFormat("dd/MM/YYYY");
                                fechaDeC = fecha1.format(new Date());
                                System.out.println("Inserte el puesto que ocupa");
                                puesto = in2.nextLine();
                                empresa1.agregarEmpleado(new Consultor(legajo, 0, 0, valorHs, nombre, fechaDeC, puesto));

                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del empleado");
                    String nombre = in2.nextLine();
                    System.out.println("Ingrese el porcentaje que desea aumentar");
                    int porcentaje = in.nextInt();
                    empresa1.incrementarSueldo(porcentaje, nombre);
                    if(empresa1.incrementarSueldo(porcentaje, nombre)==true){
                        System.out.println("Sueldo incrementado correctamente");
                    }else{
                        System.out.println("El trabajador que ha ingresado no existe o pertenece al area de consultores");
                    }
                    break;
                    
                case 3:
                        System.out.println("Ingrese el nombre del consultor");
                         nombre = in2.nextLine();
                         System.out.println("Ingrese la cantidad de horas que trabajo el consultor este mes");
                         int hs = in.nextInt();
                         empresa1.setearHsConsultores(hs, nombre);
                         if(empresa1.setearHsConsultores(hs, nombre)==true){
                             System.out.println("Hs añadidas correctamente");
                         }else{
                             System.out.println("El trabajador ingresado no existe o pertenece al area de empleados");
                         }
                    break;
                    
                case 4:
                         System.out.println("Ingrese el nombre del consultor");
                         nombre = in2.nextLine();
                         System.out.println("Ingrese el valor de las hs");
                         int valorHs = in.nextInt();
                         empresa1.setearPrecioHs(valorHs, nombre);
                         
                         if(empresa1.setearPrecioHs(valorHs, nombre)==true){
                             System.out.println("Valor de hs actualizado correctamente");
                         }else{
                             System.out.println("El nombre del trabajador ingresado no existe o pertenece al area de empleados");
                         }
                    break;
                    
                case 5:
                    System.out.println(empresa1.presupustoMensual());
                    break;
                
                default:
                    System.out.println("La opcion ingresada no existe");
            }
        } while (op != 6);

    }
}
