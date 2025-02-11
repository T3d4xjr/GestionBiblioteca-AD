/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author DAM1
 */
public class Menu {

    private static final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private static final ProyectoDAO proyectoDAO = new ProyectoDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Despedir empleado");
            System.out.println("4. Listar empleados activos");
            System.out.println("5. Listar empleados despedidos");
            System.out.println("6. Añadir proyecto");
            System.out.println("7. Añadir proyecto con empleados");
            System.out.println("8. Modificar proyecto");
            System.out.println("9. Añadir empleado a proyecto");
            System.out.println("10. Añadir varios empleados a un proyecto");
            System.out.println("11. Eliminar empleado de un proyecto");
            System.out.println("12. Listar todos los proyectos futuros");
            System.out.println("13. Listar todos los proyectos pasados");
            System.out.println("14. Listar todos los proyectos activos");
            System.out.println("15. Listar los detalles de un proyecto");
            System.out.println("16. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            try {
                switch (opcion) {
                    case 1:
                        anadirEmpleado();
                        break;
                    case 2:
                        modificarEmpleado();
                        break;
                    case 3:
                        despedirEmpleado();
                        break;
                    case 4:
                        listarEmpleadosActivos();
                        break;
                    case 5:
                        listarEmpleadosDespedidos();
                        break;
                    case 6:
                        anadirProyecto();
                        break;
                    case 7:
                        anadirProyectoConEmpleados();
                        break;
                    case 8:
                        modificarProyecto();
                        break;
                    case 9:
                        anadirEmpleadoAProyecto();
                        break;
                    case 10:
                        anadirVariosEmpleadosAProyecto();
                        break;
                    case 11:
                        eliminarEmpleadoDeProyecto();
                        break;
                    case 12:
                        listarProyectosFuturos();
                        break;
                    case 13:
                        listarProyectosPasados();
                        break;
                    case 14:
                        listarProyectosActivos();
                        break;
                    case 15:
                        listarDetallesProyecto();
                        break;
                    case 16:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida, intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void anadirEmpleado() {
        System.out.println("Nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.println("DNI del empleado: ");
        String dni = scanner.nextLine();
        System.out.println("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.println("Sueldo: ");
        float sueldo = scanner.nextFloat();
        scanner.nextLine(); // Limpiar buffer
        System.out.println("Fecha de contratación (YYYY-MM-DD): ");
        String fechaContratacionStr = scanner.nextLine();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaContratacion = format.parse(fechaContratacionStr);
            empleadoDAO.añadirOActualizarEmpleado(nombre, dni, departamento, sueldo, fechaContratacion);
            
        } catch (ParseException e) {
            System.out.println("Error en la fecha de contratación.");
        }
    }

    // --- Modificar empleado ---
    private static void modificarEmpleado() {
        System.out.println("ID del empleado a modificar: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
        System.out.println("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Nuevo departamento: ");
        String departamento = scanner.nextLine();
        System.out.println("Nuevo sueldo: ");
        float sueldo = scanner.nextFloat();

        empleadoDAO.modificarEmpleado(idEmpleado, nombre, departamento, sueldo);
    }

    // --- Despedir empleado ---
    private static void despedirEmpleado() {
        System.out.println("ID del empleado a despedir: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.println("Fecha de despido (YYYY-MM-DD): ");
        String fechaDespidoStr = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaDespido = format.parse(fechaDespidoStr);
            empleadoDAO.despedirEmpleado(idEmpleado, fechaDespido);
        } catch (ParseException e) {
            System.out.println("Error en la fecha de despido.");
        }
    }

    // --- Listar empleados activos ---
    private static void listarEmpleadosActivos() {
        List<Empleado> empleadosActivos = empleadoDAO.listarEmpleadosActivos();
        System.out.println("Empleados activos:");
        for (Empleado empleado : empleadosActivos) {
            System.out.println(empleado);
        }
    }

    // --- Listar empleados despedidos ---
    private static void listarEmpleadosDespedidos() {
        List<Empleado> empleadosDespedidos = empleadoDAO.listarEmpleadosDespedidos();
        System.out.println("Empleados despedidos:");
        for (Empleado empleado : empleadosDespedidos) {
            System.out.println(empleado);
        }
    }

    // --- Añadir proyecto ---
    private static void anadirProyecto() {
        System.out.println("Nombre del proyecto: ");
        String nombre = scanner.nextLine();
        System.out.println("Fecha de inicio (YYYY-MM-DD): ");
        String fechaInicioStr = scanner.nextLine();
        System.out.println("Fecha de finalización (YYYY-MM-DD): ");
        String fechaFinStr = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicio = format.parse(fechaInicioStr);
            Date fechaFin = format.parse(fechaFinStr);
            if (fechaFin.after(fechaInicio)) {
                proyectoDAO.añadirProyecto(nombre, fechaInicio, fechaFin);
            } else {
                System.out.println("La fecha de finalización debe ser posterior a la fecha de inicio.");
            }
        } catch (ParseException e) {
            System.out.println("Error en las fechas.");
        }
    }

    // --- Añadir proyecto con empleados ---
    private static void anadirProyectoConEmpleados() {
        System.out.println("Nombre del proyecto: ");
        String nombre = scanner.nextLine();
        System.out.println("Fecha de inicio (YYYY-MM-DD): ");
        String fechaInicioStr = scanner.nextLine();
        System.out.println("Fecha de finalización (YYYY-MM-DD): ");
        String fechaFinStr = scanner.nextLine();
        System.out.println("IDs de empleados (separados por espacios): ");
        String[] idsEmpleadoStr = scanner.nextLine().split(" ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicio = format.parse(fechaInicioStr);
            Date fechaFin = format.parse(fechaFinStr);
            if (fechaFin.after(fechaInicio)) {
                List<Empleado> empleados = new ArrayList<>();
                for (String idStr : idsEmpleadoStr) {
                    int idEmpleado = Integer.parseInt(idStr);
                    Empleado empleado =new Empleado();
                    empleado.setId(idEmpleado);
                    empleados.add(empleado);
                }
                proyectoDAO.añadirProyectoConEmpleados(nombre, fechaInicio, fechaFin, empleados);
            } else {
                System.out.println("La fecha de finalización debe ser posterior a la fecha de inicio.");
            }
        } catch (ParseException e) {
            System.out.println("Error en las fechas.");
        }
    }

    // --- Modificar proyecto ---
    private static void modificarProyecto() {
        System.out.println("ID del proyecto a modificar: ");
        int idProyecto = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
        System.out.println("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Nueva fecha de inicio (YYYY-MM-DD): ");
        String fechaInicioStr = scanner.nextLine();
        System.out.println("Nueva fecha de finalización (YYYY-MM-DD): ");
        String fechaFinStr = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicio = format.parse(fechaInicioStr);
            Date fechaFin = format.parse(fechaFinStr);
            if (fechaFin.after(fechaInicio)) {
                if (proyectoDAO.modificarProyecto(idProyecto, nombre, fechaInicio, fechaFin)) {
                    System.out.println("Proyecto modificado exitosamente.");
                } else {
                    System.out.println("Proyecto no encontrado.");
                }
            } else {
                System.out.println("La fecha de finalización debe ser posterior a la fecha de inicio.");
            }
        } catch (ParseException e) {
            System.out.println("Error en las fechas.");
        }
    }

    // --- Añadir empleado a un proyecto ---
    private static void anadirEmpleadoAProyecto() {
        System.out.println("ID del proyecto: ");
        int idProyecto = scanner.nextInt();
        System.out.println("ID del empleado: ");
        int idEmpleado = scanner.nextInt();

        if (proyectoDAO.anadirEmpleadoAProyecto(idProyecto, idEmpleado)) {
            System.out.println("Empleado añadido al proyecto.");
        } else {
            System.out.println("Error al añadir el empleado al proyecto.");
        }
    }

    // --- Añadir varios empleados a un proyecto ---
    private static void anadirVariosEmpleadosAProyecto() {
        System.out.println("ID del proyecto: ");
        int idProyecto = scanner.nextInt();
        System.out.println("IDs de empleados (separados por espacios): ");
        scanner.nextLine(); // Limpiar buffer
        String[] idsEmpleadoStr = scanner.nextLine().split(" ");

        List<Integer> empleadosIds = new ArrayList<>();
        for (String idStr : idsEmpleadoStr) {
            empleadosIds.add(Integer.parseInt(idStr));
        }

        if (proyectoDAO.anadirVariosEmpleadosAProyecto(idProyecto, empleadosIds)) {
            System.out.println("Empleados añadidos al proyecto.");
        } else {
            System.out.println("Error al añadir los empleados al proyecto.");
        }
    }

    // --- Eliminar empleado de un proyecto ---
    private static void eliminarEmpleadoDeProyecto() {
        System.out.println("ID del proyecto: ");
        int idProyecto = scanner.nextInt();
        System.out.println("ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        
        proyectoDAO.eliminarEmpleadoDeProyecto(idProyecto, idEmpleado);
        System.out.println("Empleado eliminado del proyecto.");
    }

    // --- Listar proyectos futuros ---
    private static void listarProyectosFuturos() {
        List<Proyecto> proyectosFuturos = proyectoDAO.listarProyectosFuturos();
        System.out.println("Proyectos futuros:");
        for (Proyecto proyecto : proyectosFuturos) {
            System.out.println(proyecto);
        }
    }

    // --- Listar proyectos pasados ---
    private static void listarProyectosPasados() {
        List<Proyecto> proyectosPasados = proyectoDAO.listarProyectosPasados();
        System.out.println("Proyectos pasados:");
        for (Proyecto proyecto : proyectosPasados) {
            System.out.println(proyecto);
        }
    }

    // --- Listar proyectos activos ---
    private static void listarProyectosActivos() {
        List<Proyecto> proyectosActivos = proyectoDAO.listarProyectosActivos();
        System.out.println("Proyectos activos:");
        for (Proyecto proyecto : proyectosActivos) {
            System.out.println(proyecto);
        }
    }

    // --- Listar detalles de un proyecto ---
    private static void listarDetallesProyecto() {
        System.out.print("ID del proyecto: ");
        int idProyecto = scanner.nextInt();

        List<Empleado> empleados = proyectoDAO.listarDetallesProyecto(idProyecto);

        System.out.println("Lista de empleados asociados al proyecto:");
        for (Empleado empleado : empleados) {
            System.out.println("ID empleado: " + empleado.getId());
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("DNI: " + empleado.getDni());
            System.out.println("Departamento: " + empleado.getDepartamento());

            String estado = "";
                if (empleado.getFechaFinalizacion() == null) {
                    estado = "activo";
                } else {
                    estado = "despedido";
                }
                System.out.println("Estado: " + estado);
            System.out.println("--------------------------------");
        }
    }

}
