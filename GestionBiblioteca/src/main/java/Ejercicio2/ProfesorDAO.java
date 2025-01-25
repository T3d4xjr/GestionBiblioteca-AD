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
public class ProfesorDAO {

    public void añadirProfesor(String nombre, String departamento) {
        Session session = Conexion.getSession();

        Transaction transaction = Conexion.startTransaction();
        try {
            Profesor profesor = new Profesor(nombre, departamento);
            session.persist(profesor);

            System.out.println("Profesor creado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void actualizarProfesor(int id, String nombre, String departamento) {
        Session session = Conexion.getSession();

        Transaction transaction = Conexion.startTransaction();
        try {
            Profesor profesor = new Profesor(nombre, departamento);
            profesor.setId(id);
            session.merge(profesor);

            System.out.println("Profesor actualizado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void eliminarProfesor(int id) {
        Session session = Conexion.getSession();
        Transaction transaction =Conexion.startTransaction();
        try {

            Profesor profesor = new Profesor();
            profesor.setId(id);
            session.remove(profesor);

            System.out.println("Profesor eliminado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            
        } finally {
            session.close();
        }
    }

    public void consultarProfesor() {
        Session session =Conexion.getSession();

        List<Profesor> profesores = session.createQuery("FROM Profesor", Profesor.class).getResultList();

        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }

    public void consultarProfesorId(int idProfesor) {
        Session session = Conexion.getSession();

        Profesor profesor = session.createQuery("FROM Profesor WHERE id = :idProfesor", Profesor.class)
                .setParameter("idProfesor", idProfesor)
                .uniqueResult();

        if (profesor != null) {

            System.out.println("Nombre: " + profesor.getNombre());
            System.out.println("Departamento: " + profesor.getDepartamento());

            List<Asignatura> asignaturas = session.createQuery("FROM Asignatura WHERE profesor.id = :idProfesor", Asignatura.class)
                    .setParameter("idProfesor", idProfesor)
                    .getResultList();

            for (Asignatura asignatura : asignaturas) {
                System.out.println("Asignatura: " + asignatura.getNombre());
                System.out.println("Curso: " + asignatura.getCurso());
                System.out.println("Grupo: " + asignatura.getGrupo());
            }
        } else {
            System.out.println("No se encontró el profesor con ID: " + idProfesor);
        }

    }

}
