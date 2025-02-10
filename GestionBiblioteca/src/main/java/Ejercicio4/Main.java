/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ProductoDAO productoDAO = new ProductoDAO();
    private static final PedidoDAO pedidoDAO = new PedidoDAO();
    private static final  DetallePedidoDAO detallePedidoDAO=new DetallePedidoDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Listar productos por stock");
            System.out.println("4. Añadir pedido");
            System.out.println("5. Listar pedidos");
            System.out.println("6. Listar detalles de un pedido");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    anadirProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    listarProductosPorStock();
                    break;
                case 4:
                    anadirPedido();
                    break;
                case 5:
                    listarPedidos();
                    break;
                case 6:
                    listarDetallesPedido();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private static void anadirProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        
        productoDAO.añadirProducto(nombre, stock, precio);
    }
    
    private static void listarProductos() {
        productoDAO.listarProductos();

    }
    
    private static void listarProductosPorStock() {
        System.out.print("Ingrese el stock máximo: ");
        int stockMaximo = scanner.nextInt();
        scanner.nextLine();
        
        productoDAO.listarProductosStock(stockMaximo);
    }
    
private static void anadirPedido() {
        System.out.print("Fecha del pedido: ");
        String fecha = scanner.nextLine();
        System.out.print("Cliente del pedido: ");
        String cliente = scanner.nextLine();
        
        List<DetallePedido> detallesPedido = new ArrayList<>();
        
        while (true) {
            System.out.print("ID del producto (o 0 para terminar): ");
            int idProducto = scanner.nextInt();
            if (idProducto == 0) break;

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); 

            pedidoDAO.procesarPedido(fecha, cliente, idProducto, cantidad, detallesPedido);
            
        }
    }
    
    private static void listarPedidos() {
        pedidoDAO.listarPedidos();

    }
    
    private static void listarDetallesPedido() {
        System.out.print("Ingrese el ID del pedido: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();
        
        detallePedidoDAO.listarDetallePedido(idPedido);
    }
}
