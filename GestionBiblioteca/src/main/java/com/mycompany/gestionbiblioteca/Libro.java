/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

/**
 *
 * @author DAM1
 */
public class Libro {
    private int id;
    private String titulo;
    private String fecha_publicacion;
    private String genero;
    private String isdbn;
    private String editorial;
    private String id_autor;

    public Libro(int id, String titulo, String fecha_publicacion, String genero, String isdbn, String editorial, String id_autor) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_publicacion = fecha_publicacion;
        this.genero = genero;
        this.isdbn = isdbn;
        this.editorial = editorial;
        this.id_autor = id_autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsdbn() {
        return isdbn;
    }

    public void setIsdbn(String isdbn) {
        this.isdbn = isdbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getId_autor() {
        return id_autor;
    }

    public void setId_autor(String id_autor) {
        this.id_autor = id_autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", fecha_publicacion=" + fecha_publicacion + ", genero=" + genero + ", isdbn=" + isdbn + ", editorial=" + editorial + ", id_autor=" + id_autor + '}';
    }
    
}
