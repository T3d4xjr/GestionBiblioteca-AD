/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tedax
 */
public class PedidoDAO {
    public void listarPedidos() {
        Session session = Conexion.getSession();

        List<Pedido> pedidos = session.createQuery("FROM Pedido", Pedido.class).getResultList();

        System.out.println("Pedidos (ID, fecha, cliente):");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
            
        }
    }
    public void procesarPedido(String fecha, String cliente, int idProducto, int cantidad, List<DetallePedido> detallesPedido) {
        Session session = Conexion.getSession();
        Transaction transaction = Conexion.startTransaction();
        
        try {
            Producto producto = session.get(Producto.class, idProducto);
            if (producto == null) {
                System.out.println("Producto no encontrado.");
            }
            if (cantidad > producto.getStock()) {
                System.out.println("Stock insuficiente para el producto: " + producto.getNombre());
            }
            Pedido pedido = new Pedido(fecha, cliente);
            session.persist(pedido);
            session.flush();
            
            DetallePedido detalle = new DetallePedido();
            detalle.setIdPedido(pedido);
            detalle.setIdProducto(producto);
            detalle.setCantidad(cantidad);
            detalle.setSubtotal(cantidad * producto.getPrecio());
            detallesPedido.add(detalle);
            session.persist(detalle);
            
            producto.setStock(producto.getStock() - cantidad);
            session.merge(producto);
            
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
}

