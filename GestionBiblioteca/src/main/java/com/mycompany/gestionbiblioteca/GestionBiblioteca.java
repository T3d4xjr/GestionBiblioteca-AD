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
                añadirLibro(sc);
                break;
            case 7:
                modificarLibro(sc);
                break;
            case 8:
                eliminarLibro(sc);
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
        ArrayList<Libro> libros =LibroDAO.listarLibros();
        for (Libro libro : libros) {
            System.out.println(libro.getId()+","
                    +libro.getTitulo()+","
                    +libro.getFecha_publicacion()+","
                    +libro.getGenero()+","
                    +libro.getIsbn()+","
                    +libro.getEditorial()+","
                    +libro.getId_autor());
        }
    }
    private  static void añadirLibro(Scanner sc){
        sc.nextLine();
        System.out.println("Indica el titulo del libro");
        String titulo=sc.nextLine();
        System.out.println("Indica la fecha en formato YYYY-MM-DD:");
        String fecha=sc.nextLine();
        System.out.println("Indique su genero");
        String genero =sc.nextLine();
        System.out.println("Indique el isbn");
        String isbn=sc.nextLine();
        System.out.println("Indique su editorial");
        String editorial=sc.nextLine();
        System.out.println("Indique el id del autor");
        int id_autor=sc.nextInt();
        
        LibroDAO.añadirLibro(titulo, fecha, genero, isbn, editorial,id_autor);
    }
    private  static void modificarLibro(Scanner sc){
        sc.nextLine();
        System.out.println("Indica el id a modificar");
        int id =sc.nextInt();
        sc.nextLine();
        System.out.println("Indica el titulo del libro");
        String titulo=sc.nextLine();
        System.out.println("Indica la fecha en formato YYYY-MM-DD:");
        String fecha=sc.nextLine();
        System.out.println("Indique su genero");
        String genero =sc.nextLine();
        System.out.println("Indique el isbn");
        String isbn=sc.nextLine();
        System.out.println("Indique su editorial");
        String editorial=sc.nextLine();
        System.out.println("Indique el id del autor");
        int id_autor=sc.nextInt();
        
        LibroDAO.modificarLibro(id, titulo, fecha, genero, isbn, editorial, id_autor);
    }
    private  static void eliminarLibro(Scanner sc){
        sc.nextLine();
        System.out.println("Indica el id a eliminar");
        int id =sc.nextInt();
        
        LibroDAO.eliminarLibro(id);
    }
    
    
    
}
