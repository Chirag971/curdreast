/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Catagorymaster;
import entity.Productmaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author LENOVO
 */
@Local
public interface productBeanLocal {
    void addProduct(String pname,int price,int cid);
    void editProduct(int pid,String pname,int price,int cid);
    Collection<Productmaster> getAllProduct();
    Collection<Catagorymaster> getAllCatagory();
}
