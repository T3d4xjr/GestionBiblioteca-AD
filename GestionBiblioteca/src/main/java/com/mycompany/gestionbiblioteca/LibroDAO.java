/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tedax
 */
public class LibroDAO {

    public static ArrayList<Libro> listarLibros() {
        ArrayList<Libro> Libros = new ArrayList<>();

        String sql = "SELECT * FROM libro";

        try {
            PreparedStatement stmt = Conexion.getPreparedStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Libro l = new Libro(rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("fecha_publicacion"),
                        rs.getString("genero"),
                        rs.getString("isbn"),
                        rs.getString("editorial"),
                        rs.getInt("id_autor"));

                Libros.add(l);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Libros;
    }

    public static void añadirLibro(String titulo, String fecha_publicacion, String genero, String isbn, String editorial, int id_autor) {

        String sql = "INSERT INTO libro(titulo,fecha_publicacion,genero,isbn,editorial,id_autor) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = Conexion.getPreparedStatement(sql);

            stmt.setString(1, titulo);
            stmt.setString(2, fecha_publicacion);
            stmt.setString(3, genero);
            stmt.setString(4, isbn);
            stmt.setString(5, editorial);
            stmt.setInt(6, id_autor);

            int row = stmt.executeUpdate();

            if (row == 0) {
                System.err.println("Error al añadir el libro");
            } else {
                System.out.println("libro añadido correctamente");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void modificarLibro(int id, String titulo, String fecha_publicacion, String genero, String isbn, String editorial, int id_autor) {

        String sql = "UPDATE libro SET titulo = ? ,fecha_publicacion= ? ,genero= ? ,isbn= ?,editorial = ?,id_autor = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Conexion.getPreparedStatement(sql);

            stmt.setString(1, titulo);
            stmt.setString(2, fecha_publicacion);
            stmt.setString(3, genero);
            stmt.setString(4, isbn);
            stmt.setString(5, editorial);
            stmt.setInt(6, id_autor);
            stmt.setInt(7, id);
            int row = stmt.executeUpdate();

            if (row == 0) {
                System.err.println("Error al modificar el libro");
            } else {
                System.out.println("libro modificado correctamente");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarLibro(int id) {
        String sql = "DELETE FROM libro WHERE id = ?";

        try {

            PreparedStatement stmt = Conexion.getPreparedStatement(sql);

            stmt.setInt(1, id);

            int row = stmt.executeUpdate();

            if (row == 0) {
                System.err.println("Error al eliminar el libro");
            } else {
                System.out.println("Libro eliminado correctamente");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
