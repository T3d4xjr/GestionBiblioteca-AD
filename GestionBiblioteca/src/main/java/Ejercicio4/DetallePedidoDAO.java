/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import org.hibernate.Session;

/**
 *
 * @author tedax
 */
public class DetallePedidoDAO {

    public void listarDetallePedido(int id_pedido) {
        try (Session session = Conexion.getSession()) {
            String query = "SELECT p FROM Pedido p "
                    + "JOIN FETCH p.DetallePedido dp "
                    + "JOIN FETCH dp.producto pr "
                    + "WHERE p.idPedido = :idPedido";
            
            Pedido pedido = session.createQuery(query, Pedido.class).setParameter("id_pedido", id_pedido).getSingleResult();
            
            System.out.println("Detalles del Pedido " + pedido.getId() + ":");
            System.out.println("Fecha: " + pedido.getFecha());
            System.out.println("Cliente: " + pedido.getCliente());
            
            System.out.println("Productos (nombre, cantidad, subtotal):");
            
            for (DetallePedido dp : pedido.getDetallePedidoList()) {
                Producto producto = dp.getIdProducto();
                int cantidad = dp.getCantidad();
                double subtotal = dp.getSubtotal();
                
                // Mostrar detalles de cada producto
                System.out.println(producto.getNombre() + ", Cantidad: " + cantidad + ", Subtotal: " + subtotal + "€");
            }
        }
    }
}
