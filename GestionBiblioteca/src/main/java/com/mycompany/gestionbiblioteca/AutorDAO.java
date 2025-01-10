/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DAM1
 */
public class AutorDAO {
    public  static ArrayList<Autor> listarAutores(){
        ArrayList<Autor> Autores =new ArrayList<>();
        
        String sql ="SELECT * FROM autor";
        
        try {
            PreparedStatement stmt =Conexion.getPreparedStatement(sql);ResultSet rs =stmt.executeQuery();
            
            while (rs.next()) {
            Autor a =new Autor(rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("fecha_nacimiento"), 
                    rs.getString("nacionalidad"), 
                    rs.getInt("numero_obras"), 
                    rs.getString("biografia"));
            
            Autores.add(a);
                    
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Autores;
    }
    public static void añadirAutor(String nombre,String fecha_nacimiento,String nacionalidad,int numero_obras,String biografia){
    
        String sql ="INSERT INTO autor(nombre,fecha_nacimiento,nacionalidad,numero_obras,biografia) VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement stmt =Conexion.getPreparedStatement(sql);
            
            stmt.setString(1, nombre);
            stmt.setString(2, fecha_nacimiento);
            stmt.setString(3, nacionalidad);
            stmt.setInt(4, numero_obras);
            stmt.setString(5, biografia);
            
            int row=stmt.executeUpdate();
            
            if(row == 0){
                System.err.println("Error al añadir el autor");
            }else{
                System.out.println("Autor añadido correctamente");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }
    public static void modificarAutor(int id,String nombre,String fecha_nacimiento,String nacionalidad,int numero_obras,String biografia){
        
        String sql ="UPDATE autor SET nombre = ? ,fecha_nacimiento= ? ,nacionalidad= ? ,numero_obras= ?,biografia = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt =Conexion.getPreparedStatement(sql);
            
            stmt.setString(1, nombre);
            stmt.setString(2, fecha_nacimiento);
            stmt.setString(3, nacionalidad);
            stmt.setInt(4, numero_obras);
            stmt.setString(5, biografia);
            stmt.setInt(6, id);
            int row=stmt.executeUpdate();
            
            if(row == 0){
                System.err.println("Error al modifciar el autor");
            }else{
                System.out.println("Autor modificado correctamente");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
