/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicioBDHybernate;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DAM1
 */
public class ClienteDAO {
    public void selectALL(){
        Session session=Conexion.getSession();
        
        List<Cliente> clientes=session.createQuery("FROM Cliente",Cliente.class).getResultList();
        
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
    public void insert(Cliente cliente){
        Session session=Conexion.getSession();
        session.persist(cliente);
        
    }
    
    public List<Cliente> selectAL(){
        Session session=Conexion.getSession();
        
        return session.createQuery("FROM Cliente",Cliente.class).getResultList();
        
       
    }
    
    
}
