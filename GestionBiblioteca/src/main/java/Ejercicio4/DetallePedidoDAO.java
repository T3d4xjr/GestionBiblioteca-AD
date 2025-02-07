/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author tedax
 */
public class DetallePedidoDAO {

    public void listarDetallePedido(int id_pedido) {
        Session session = Conexion.getSession();

        Pedido pedido = session.get(Pedido.class, id_pedido);
        System.out.println("------------------------------");
        System.out.println("Detalles del pedido:" + pedido.getId());
        System.out.println("Fecha:" + pedido.getFecha());
        System.out.println("Cliente:" + pedido.getCliente());

        System.out.println("Productos (nombre, cantidad, subtotal):");

        List<DetallePedido> detallePedidos = pedido.getDetallePedidoList();
        for (DetallePedido detallePedido : detallePedidos) {

            System.out.println(detallePedido.getIdProducto()
                    .getNombre() + "," + detallePedido
                            .getCantidad()+ "," + detallePedido.getSubtotal());

        }
    }
}
