/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Catagorymaster;
import entity.Productmaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LENOVO
 */
@Stateless
public class productBean implements productBeanLocal {
    @PersistenceContext(unitName="mypu")
    EntityManager em;

    @Override
    public void addProduct(String pname, int price, int cid) {
        Catagorymaster c = em.find(Catagorymaster.class, cid);
        Collection<Productmaster> products = c.getProductmasterCollection();
        Productmaster p = new Productmaster();
        p.setProductName(pname);
        p.setPrice(price);
        p.setCid(c);
        
        products.add(p);
        c.setProductmasterCollection(products);
        
        em.persist(p);
        em.merge(c);
    }

    @Override
    public Collection<Productmaster> getAllProduct() {
        return em.createNamedQuery("Productmaster.findAll",Productmaster.class).getResultList();
    }
     @Override
    public Collection<Catagorymaster> getAllCatagory() {
        return em.createNamedQuery("Catagorymaster.findAll",Catagorymaster.class).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void editProduct(int pid, String pname, int price, int cid) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Catagorymaster c = em.find(Catagorymaster.class, cid);
        Productmaster p = em.find(Productmaster.class, pid);
        Collection<Productmaster> products = c.getProductmasterCollection();
        if(products.contains(p))
        {
            products.remove(p);
        }
        
        p.setProductName(pname);
        p.setPrice(price);
        p.setCid(c);
        
        products.add(p);
        c.setProductmasterCollection(products);
        
        em.merge(p);
        em.merge(c);
        
    }
}
