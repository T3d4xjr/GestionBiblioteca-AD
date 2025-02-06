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
public class PedidoDAO {
    public void listarPedidos() {
        Session session = Conexion.getSession();

        List<Pedido> pedidos = session.createQuery("FROM Pedido", Pedido.class).getResultList();

        System.out.println("Pedidos (ID, fecha, cliente):");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
            
        }
    }
    
}
