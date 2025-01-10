/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

/**
 *
 * @author DAM1
 */
public class Autor {
    private int id;
    private String nombre;
    private String fecha_nacimiento;
    private String nacionalidad;
    private int n_obras;
    private String biografia;

    public Autor(int id, String nombre, String fecha_nacimiento, String nacionalidad, int n_obras, String biografia) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.n_obras = n_obras;
        this.biografia = biografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getN_obras() {
        return n_obras;
    }

    public void setN_obras(int n_obras) {
        this.n_obras = n_obras;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento + ", nacionalidad=" + nacionalidad + ", n_obras=" + n_obras + ", biografia=" + biografia + '}';
    }
    
}
