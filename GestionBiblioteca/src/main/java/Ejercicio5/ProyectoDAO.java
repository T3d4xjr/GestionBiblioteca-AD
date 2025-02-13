/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DAM1
 */
public class ProyectoDAO {

    public void añadirProyecto(String nombre, Date fechaInicio, Date fechaFin) {
        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha_inicio = sdf.format(fechaInicio);
            String fecha_fin = sdf.format(fechaFin);

            Proyecto proyecto = new Proyecto(nombre, fecha_inicio, fecha_fin);
            session.persist(proyecto);
            
            System.out.println("Proyecto id: " + proyecto.getId());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void añadirProyectoConEmpleados(String nombre, Date fechaInicio, Date fechaFin, List<Integer> idsEmpleados) {
        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha_inicio = sdf.format(fechaInicio);
            String fecha_fin = sdf.format(fechaFin);

            Proyecto proyecto = new Proyecto(nombre, fecha_inicio, fecha_fin);
            
            for (Integer idEmpleado : idsEmpleados) {
                Empleado empleado = session.get(Empleado.class, idEmpleado);

                empleado.getProyectoList().add(proyecto);
            }
                
            
            session.persist(proyecto);
            

            System.out.println("Proyecto id: " + proyecto.getId());
            
            

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public boolean modificarProyecto(int idProyecto, String nombre, Date fechaInicio, Date fechaFin) {

        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha_inicio = sdf.format(fechaInicio);
            String fecha_fin = sdf.format(fechaFin);

            Proyecto proyecto = new Proyecto(nombre, fecha_inicio, fecha_fin);
            proyecto.setId(idProyecto);
            session.merge(proyecto);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false;

    }

    public boolean anadirEmpleadoAProyecto(int idProyecto, int idEmpleado) {
        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Proyecto proyecto = session.get(Proyecto.class, idProyecto);

            Empleado empleado = session.get(Empleado.class, idEmpleado);

            proyecto.getEmpleadoList().add(empleado);
            empleado.getProyectoList().add(proyecto);

            session.merge(proyecto);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }

    public boolean anadirVariosEmpleadosAProyecto(int idProyecto, List<Integer> empleadosIds) {
        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Proyecto proyecto = session.get(Proyecto.class, idProyecto);

            for (int idEmpleado : empleadosIds) {
                Empleado empleado = session.get(Empleado.class, idEmpleado);

                proyecto.getEmpleadoList().add(empleado);
                empleado.getProyectoList().add(proyecto);
            }

            session.merge(proyecto);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }

    public boolean eliminarEmpleadoDeProyecto(int idProyecto, int idEmpleado) {
        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Proyecto proyecto = session.get(Proyecto.class, idProyecto);
            if (proyecto == null) {
                System.out.println("El proyecto con ID " + idProyecto + " no existe.");
                return false;
            }

            Empleado empleado = session.get(Empleado.class, idEmpleado);
            if (empleado == null) {
                System.out.println("El empleado con ID " + idEmpleado + " no existe.");
                return false;
            }

            // Eliminar solo la relación entre el empleado y el proyecto
            proyecto.getEmpleadoList().remove(empleado);
            empleado.getProyectoList().remove(proyecto);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return false;

    }

    public List<Proyecto> listarProyectosFuturos() {
        Session session = Conexion.getSession();
        List<Proyecto> proyectos = new ArrayList<>();

        try {
            String query = "FROM Proyecto WHERE fechaFin >: fechaActual";
            String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            proyectos = session.createQuery(query, Proyecto.class)
                    .setParameter("fechaActual", fechaActual)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return proyectos;
    }

    public List<Proyecto> listarProyectosPasados() {
        Session session = Conexion.getSession();
        List<Proyecto> proyectos = new ArrayList<>();

        try {
            String query = "FROM Proyecto WHERE fechaFin <: fechaActual";
            String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            proyectos = session.createQuery(query, Proyecto.class)
                    .setParameter("fechaActual", fechaActual)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return proyectos;
    }

    public List<Proyecto> listarProyectosActivos() {
        Session session = Conexion.getSession();
        List<Proyecto> proyectos = new ArrayList<>();

        try {
            String query = "FROM Proyecto WHERE :fechaActual BETWEEN fechaInicio AND fechaFin";
            String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            proyectos = session.createQuery(query, Proyecto.class)
                    .setParameter("fechaActual", fechaActual)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return proyectos;
    }

    public List<Empleado> listarDetallesProyecto(int idProyecto) {
        List<Empleado> empleados = new ArrayList<>();
        Session session = Conexion.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Proyecto proyecto = session.get(Proyecto.class, idProyecto);
            if (proyecto != null) {
                System.out.println("Detalles del proyecto: ");
                System.out.println("Nombre: " + proyecto.getNombre());
                System.out.println("Fecha Inicio: " + proyecto.getFechaInicio());
                System.out.println("Fecha Fin: " + proyecto.getFechaFin());
                System.out.println("--------------------------------");

                empleados.addAll(proyecto.getEmpleadoList());
            } else {
                System.out.println("No se encontró un proyecto con ID: " + idProyecto);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return empleados; // Devolvemos la lista de empleados
    }

}
