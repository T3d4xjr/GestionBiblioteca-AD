/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaHybernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DAM1
 */
public class LibroDAO {
    public void selectALL(){
        Session session=Conexion.getSession();
        
        List<Libro> libros=session.createQuery("FROM Libro",Libro.class).getResultList();
        
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
    public void insertLibro(String titulo, String fecha, 
            String genero, String isbn,String editorial,int id_autor){
        
        Session session = Conexion.getSession();
        Transaction transaction = Conexion.startTransaction();
        try {
            Autor autor=session.get(Autor.class, id_autor);
            Libro libro=new Libro(titulo, fecha, genero, isbn, editorial, autor);
            session.persist(libro);

            System.out.println("Libro creado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

    }
    public void updateLibro(int id,String titulo, String fecha, 
            String genero, String isbn,String editorial,int id_autor){
        
        Session session = Conexion.getSession();
        Transaction transaction = Conexion.startTransaction();
        try {
             Autor autor=session.get(Autor.class, id_autor);
            Libro libro=new Libro(titulo, fecha, genero, isbn, editorial, autor);
            libro.setId(id);
            session.merge(libro);

            System.out.println("Libro actualizado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

    }
    public void deleteAutor(int id) {
        Session session = Conexion.getSession();
        Transaction transaction = Conexion.startTransaction();
        try {
            
            Libro libro=new Libro();
            libro.setId(id);
            session.remove(libro);
            
            System.out.println("Libro eliminado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
    public void selectPorIdLibro(int idLibro) {
        Session session = Conexion.getSession();

        Libro libro = session.createQuery("FROM Libro WHERE id = :idLibro", Libro.class)
                .setParameter("idLibro", idLibro).getSingleResult();

            System.out.println(libro);
        
    }
    public void selectPorFragmentoTitulo(String titulo) {
        Session session = Conexion.getSession();

        Libro libro = session.createQuery("FROM Libro WHERE titulo LIKE :titulo", Libro.class)
                .setParameter("nombre", "%"+titulo+"%").getSingleResult();

            System.out.println(libro);
        
    }
    public void listarLibrosIdAutor(int idAutor){
        Session session=Conexion.getSession();
        
        List<Libro> libros=session.createQuery("FROM Libro WHERE autor.id = :idAutor",Libro.class)
                .setParameter("idAutor", idAutor).getResultList();
        
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    
    }
    
}
