/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tedax
 */
public class AsignaturaDAO {

    public void añadirAsignatura(String nombre, String curso, String grupo, int id_profesor) {
        Session session = Conexion.getSession();

        Transaction transaction = Conexion.startTransaction();
        try {
            Profesor profesor = session.get(Profesor.class, id_profesor);
            Asignatura asignatura = new Asignatura(nombre, curso, grupo, profesor);
            session.persist(asignatura);

            System.out.println("Asignatura creado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void actualizarAsignatura(int id, String nombre, String curso, String grupo, int id_profesor) {
        Session session = Conexion.getSession();

        Transaction transaction = Conexion.startTransaction();
        try {
            Profesor profesor = session.get(Profesor.class, id_profesor);
            Asignatura asignatura = new Asignatura(nombre, curso, grupo, profesor);
            asignatura.setId(id);
            session.merge(asignatura);

            System.out.println("Asignatura actualizado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void eliminarAsignatura(int id) {
        Session session =Conexion.getSession();
        Transaction transaction = Conexion.startTransaction();
        try {

            Asignatura asignatura =new Asignatura();
            asignatura.setId(id);
            session.remove(asignatura);

            System.out.println("Asignatura eliminado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void consultarAsignatura() {
        Session session =Conexion.getSession();

        List<Asignatura> asignaturas = session.createQuery("FROM Asignatura", Asignatura.class).getResultList();

        for (Asignatura asignatura : asignaturas) {
            System.out.println(asignatura);
        }
    }

    public void consultarAsignaturaId(int idAsignatura) {
        Session session = Conexion.getSession();

        Asignatura asignatura = session.createQuery("FROM Asignatura WHERE id = :idAsignatura", Asignatura.class)
                .setParameter("idAsignatura", idAsignatura)
                .uniqueResult();

        if (asignatura != null) {
            System.out.println("Asignatura: " + asignatura.getNombre());
            System.out.println("Curso: " + asignatura.getCurso());
            System.out.println("Grupo: " + asignatura.getGrupo());

            Profesor profesor = asignatura.getProfesor();
            if (profesor != null) {
                System.out.println("Profesor: " + profesor.getNombre());
                System.out.println("Departamento: " + profesor.getDepartamento());
            } else {
                System.out.println("No hay profesor asignado a esta asignatura.");
            }
        } else {
            System.out.println("No se encontró la asignatura con ID: " + idAsignatura);
        }

    }
}
