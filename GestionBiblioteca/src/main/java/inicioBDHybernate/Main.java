/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicioBDHybernate;


import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//control shif i para arreglar los imports
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure(new File("hibernate.cfg.xml"));
        
        configuration.addAnnotatedClass(Cliente.class);
        
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        
        Transaction transaction = null;
        try {
            transaction =session.beginTransaction();
            
            Cliente cliente=new Cliente("pepe", "hola@gmail.com", "2024-12-12", null);
            //insertar
            session.persist(cliente);
            
            //update
            // cliente.setId(1);
            // session.merge(cliente);
            //delete
            // cliente.setId(1);
            // session.delete(cliente);
            System.out.println("Cliente guardado correctamente");
            transaction.commit();
        } catch (Exception e) {
            if(transaction !=null){
            transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        
    }
}
