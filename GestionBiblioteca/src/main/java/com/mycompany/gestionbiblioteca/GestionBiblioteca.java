/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionbiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM1
 */
public class GestionBiblioteca {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
        System.out.println("\nIntroduce una opción:");
        System.out.println("1. Listar autores");
        System.out.println("2. Añadir autor");
        System.out.println("3. Actualizar autor");
        System.out.println("4. Borrar autor");
        System.out.println("5. Listar libros");
        System.out.println("6. Añadir libro");
        System.out.println("7. Actualizar libro");
        System.out.println("8. Eliminar libro");
        System.out.println("9. Salir");
       int opcion =sc.nextInt();
       
        switch (opcion) {
            case 1:
                listarAutores();
                break;
            case 2:
                añadirAutor(sc);
                break;
            case 3:
                modificarAutor(sc);
                break;
            case 4:
                eliminarAutor(sc);
                break;
            case 5:
                listarLibros();
                break;
            case 6:
                añadirLibro();
                break;
            case 7:
                modificarLibro();
                break;
            case 8:
                eliminarLibro();
                break;
            case 9:
                System.out.println("Saliendo....");
                break;
            default:
                throw new AssertionError();
        }
    }
    private  static void listarAutores(){
        ArrayList<Autor> autores =AutorDAO.listarAutores();
        System.out.println(autores.size());
        for (Autor autore : autores) {
            System.out.println(autore.getId()+","
                    +autore.getNombre()+","
                    +autore.getFecha_nacimiento()+","
                    +autore.getNacionalidad()+","
                    +autore.getN_obras()+","
                    +autore.getBiografia());
        }
    }
    private  static void añadirAutor(Scanner sc){
        sc.nextLine();
        System.out.println("Indica el nombre del autor");
        String nombre=sc.nextLine();
        System.out.println("Indica la fecha en formato YYYY-MM-DD:");
        String fecha=sc.nextLine();
        System.out.println("Indique su nacionalidad");
        String nacionalidad =sc.nextLine();
        System.out.println("Indique el numero de obras del autor");
        int n_obras=sc.nextInt();
        sc.nextLine(); 
       System.out.println("Indique su biografia");
        String biografia=sc.nextLine();
        
        AutorDAO.añadirAutor(nombre, fecha, nacionalidad, n_obras, biografia);
        
    }
    private  static void modificarAutor(Scanner sc){
        sc.nextLine();
        System.out.println("Indica el id a modificar");
        int id =sc.nextInt();
        sc.nextLine();
        System.out.println("Indica el nombre del autor");
        String nombre=sc.nextLine();
        System.out.println("Indica la fecha en formato YYYY-MM-DD:");
        String fecha=sc.nextLine();
        System.out.println("Indique su nacionalidad");
        String nacionalidad =sc.nextLine();
        System.out.println("Indique el numero de obras del autor");
        int n_obras=sc.nextInt();
        sc.nextLine(); 
       System.out.println("Indique su biografia");
        String biografia=sc.nextLine();
        AutorDAO.modificarAutor(id, nombre, fecha, nacionalidad, n_obras, biografia);
    }
    private  static void eliminarAutor(Scanner sc){
        sc.nextLine();
        System.out.println("Indica el id a eliminar");
        int id =sc.nextInt();
        
        AutorDAO.eliminarAutor(id);
    }
    private  static void listarLibros(){
    
    }
    private  static void añadirLibro(){
    
    }
    private  static void modificarLibro(){
    
    }
    private  static void eliminarLibro(){
    
    }
    
    
    
}
