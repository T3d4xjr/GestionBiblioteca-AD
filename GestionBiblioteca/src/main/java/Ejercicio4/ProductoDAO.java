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
public class ProductoDAO {
    public void añadirProducto(String nombre, int stock , double precio) {
        Session session = Conexion.getSession();
        Transaction transaction = Conexion.startTransaction();
        try {
            Producto producto=new Producto(nombre, stock, stock);
            session.persist(producto);

            System.out.println("Producto creado correctamente");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

    }
    public void listarProductos() {
        Session session = Conexion.getSession();

        List<Producto> productos = session.createQuery("FROM Producto", Producto.class).getResultList();

        System.out.println("Productos (ID, nombre, stock, precio): ");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
    public void listarProductosStock(int stock) {
        Session session = Conexion.getSession();

        List<Producto> productos = session.createQuery("FROM Producto WHERE stock < :stockMaximo", Producto.class)
                                             .setParameter("stockMaximo", stock)
                                             .getResultList();

        System.out.println("Productos con menos de "+stock+" unidades (ID, nombre, stock, precio):");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
