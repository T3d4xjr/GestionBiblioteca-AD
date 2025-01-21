/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaHybernate;

import jakarta.persistence.*;
import java.lang.annotation.Target;

/**
 *
 * @author DAM1
 */
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha_publicacion")
    private String fecha_publicacion;
    @Column(name = "genero")
    private String genero;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "editorial")
    private String editorial;
    
    @Column(name = "id_autor")
    private int id_autor;

    public Libro() {
    }

    public Libro(String titulo, String fecha_publicacion, String genero, String isbn, String editorial, int id_autor) {
        this.titulo = titulo;
        this.fecha_publicacion = fecha_publicacion;
        this.genero = genero;
        this.isbn = isbn;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", fecha_publicacion=" + fecha_publicacion + ", genero=" + genero + ", isbn=" + isbn + ", editorial=" + editorial + ", id_autor=" + id_autor + '}';
    }

}
