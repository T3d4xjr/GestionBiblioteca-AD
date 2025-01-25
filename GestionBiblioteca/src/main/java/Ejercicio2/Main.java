/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Main {

    private static AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
    private static ProfesorDAO profesor = new ProfesorDAO();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1.Añadir profesor");
        System.out.println("2.Actualizar profesor");
        System.out.println("3.Eliminar profesor");
        System.out.println("4.Añadir asignatura");
        System.out.println("5.Actualizar asignatura");
        System.out.println("6.Eliminar asignatura");
        System.out.println("7.Consultar profesores");
        System.out.println("8.Consultar asignaturas");
        System.out.println("9.Consultar profesor por id");
        System.out.println("10.Consultar asignatura por id");
        System.out.println("11.Salir");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                añadirProfesor(sc);
                break;
            case 2:
                actualizarProfesor(sc);
                break;
            case 3:
                eliminarProfesor(sc);
                break;
            case 4:
                añadirAsignatura(sc);
                break;
            case 5:
                actualizarAsignatura(sc);
                break;
            case 6:
                eliminarAsignatura(sc);
                break;
            case 7:
                consultarProfesores();
                break;
            case 8:
                consultarAsignaturas();
                break;
            case 9:
                consultarProfesorPorId(sc);
                break;
            case 10:
                consultarAsignaturaPorId(sc);
                break;
            case 11:
                System.out.println("Saliendo del programa...");
                break;
            default:
                throw new AssertionError();
        }
    }

    private static void añadirProfesor(Scanner sc) {
        System.out.println("Añadir nombre");
        String nombre = sc.nextLine();
        sc.nextLine();
        System.out.println("Añadir departamento");
        String departamento = sc.nextLine();
        profesor.añadirProfesor(nombre, departamento);
    }

    private static void actualizarProfesor(Scanner sc) {
        sc.nextLine();
        System.out.println("Id para actualizar");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Actualizar nombre");
        String nombre = sc.nextLine();
        System.out.println("Actualizar departamento");
        String departamento = sc.nextLine();
        profesor.actualizarProfesor(id, nombre, departamento);
    }

    private static void eliminarProfesor(Scanner sc) {
        sc.nextLine();
        System.out.println("Id para actualizar");
        int id = sc.nextInt();
        profesor.eliminarProfesor(id);
    }

    private static void añadirAsignatura(Scanner sc) {
        System.out.println("Añadir nombre");
        String nombre = sc.nextLine();
        sc.nextLine();
        System.out.println("Añadir curso");
        String curso = sc.nextLine();
        System.out.println("Añadir Grupo");
        String grupo = sc.nextLine();
        System.out.println("Añadir id_profesor");
        int id_profesor = sc.nextInt();
        asignaturaDAO.añadirAsignatura(nombre, curso, grupo, id_profesor);
    }

    private static void actualizarAsignatura(Scanner sc) {
        sc.nextLine();
        System.out.println("Id para actualizar");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Añadir nombre");
        String nombre = sc.nextLine();
        System.out.println("Añadir curso");
        String curso = sc.nextLine();
        System.out.println("Añadir Grupo");
        String grupo = sc.nextLine();
        System.out.println("Añadir id_profesor");
        int id_profesor = sc.nextInt();
        asignaturaDAO.actualizarAsignatura(id, nombre, curso, grupo, id_profesor);
    }

    private static void eliminarAsignatura(Scanner sc) {
        sc.nextLine();
        System.out.println("Id para actualizar");
        int id = sc.nextInt();
        asignaturaDAO.eliminarAsignatura(id);
    }

    private static void consultarProfesores() {
        profesor.consultarProfesor();
    }

    private static void consultarAsignaturas() {
        asignaturaDAO.consultarAsignatura();
    }

    private static void consultarProfesorPorId(Scanner sc) {
        System.out.println("Id del profesor");
        int id = sc.nextInt();
        profesor.consultarProfesorId(id);
    }

    private static void consultarAsignaturaPorId(Scanner sc) {
        System.out.println("Id de la asignatura");
        int id = sc.nextInt();
        asignaturaDAO.consultarAsignaturaId(id);
    }
}