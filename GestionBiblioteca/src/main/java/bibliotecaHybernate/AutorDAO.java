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
public class AutorDAO {

    public void selectALL() {
        Session session = Conexion.getSession();

        List<Autor> autors = session.createQuery("FROM Autor", Autor.class).getResultList();

        for (Autor autor : autors) {
            System.out.println(autor);
        }
    }

    public void insertAutor(String nombre, String fecha, String nacionalidad, int n_obras, String biografia) {
        Session session = Conexion.getSession();
        Transaction transaction = Conexion.startTransaction();
        try {
            Autor autor = new Autor(nombre, fecha, nacionalidad, n_obras, biografia);
            session.persist(autor);

            System.out.println("Cliente creado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

    }

    public void updateAutor(int id, String nombre, String fecha, String nacionalidad, int n_obras, String biografia) {
        Session session = Conexion.getSession();
        Transaction transaction = Conexion.startTransaction();
        try {
            Autor autor = new Autor(nombre, fecha, nacionalidad, n_obras, biografia);
            autor.setId(id);
            session.update(autor);
            System.out.println("Cliente actualizado correctamente");

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
            
            Autor autor = new Autor();
            autor.setId(id);
            session.delete(autor);
            
            System.out.println("Cliente eliminado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
    public void selectPorIdAutor(int idCliente) {
        Session session = Conexion.getSession();

        Autor autor = session.createQuery("FROM Autor WHERE id = :idCliente", Autor.class)
                .setParameter("idCliente", idCliente).getSingleResult();

            System.out.println(autor);
        
    }
    public void selectPorFragmentoNombre(String nombre) {
        Session session = Conexion.getSession();

        Autor autor = session.createQuery("FROM Autor WHERE nombre LIKE :nombre", Autor.class)
                .setParameter("nombre", "%"+nombre+"%").getSingleResult();

            System.out.println(autor);
        
    }

}
