/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DAM1
 */
public class EmpleadoDAO {

    public List<Empleado> listarEmpleadosActivos() {

        Session session = Conexion.getSession();
        List<Empleado> empleados = new ArrayList<>();

        try {
            String query = "FROM Empleado WHERE fechaFinalizacion IS NULL";
            empleados = session.createQuery(query, Empleado.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return empleados;

    }

    public void añadirOActualizarEmpleado(String nombre, String dni, String departamento, float sueldo, Date fechaContratacion) {
        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();

        try {

            Empleado empleado = session.createQuery("FROM Empleado e WHERE e.dni = :dni", Empleado.class)
                                   .setParameter("dni", dni)
                                   .uniqueResult();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String fecha_Contratacion = sdf.format(fechaContratacion);
            if (empleado == null) {
                Empleado nuevoEmpleado = new Empleado(nombre, dni, departamento, sueldo, fecha_Contratacion);
                session.persist(nuevoEmpleado);
                System.out.println("Empleado añadido exitosamente.");
            } else {
                empleado.setNombre(nombre);
                empleado.setDepartamento(departamento);
                empleado.setSueldo(sueldo);
                empleado.setFechaContratacion(fecha_Contratacion);
                session.merge(empleado);
                System.out.println("Empleado actualizado exitosamente.");
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void modificarEmpleado(int idEmpleado, String nombre, String departamento, float sueldo) {

        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();

        try {

            Empleado empleado = session.get(Empleado.class, idEmpleado);
            empleado.setNombre(nombre);
            empleado.setDepartamento(departamento);
            empleado.setSueldo(sueldo);
            session.merge(empleado);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void despedirEmpleado(int idEmpleado, Date fechaDespido) {
        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha_despido = sdf.format(fechaDespido);
            Empleado empleado = session.get(Empleado.class, idEmpleado);
            empleado.setFechaFinalizacion(fecha_despido);
            session.merge(empleado);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public List<Empleado> listarEmpleadosDespedidos() {
        Session session = Conexion.getSession();
        List<Empleado> empleados = new ArrayList<>();

        try {
            String query = "FROM Empleado WHERE fechaFinalizacion IS NOT NULL";
            empleados = session.createQuery(query, Empleado.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return empleados;
    }

}
