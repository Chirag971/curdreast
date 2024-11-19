/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.productClient;
import entity.Catagorymaster;
import entity.Productmaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author LENOVO
 */
@Named(value = "productManageBean")
@SessionScoped
public class productManageBean implements Serializable {

    productClient pc;
    Productmaster p;
    Catagorymaster c;
    Response rs;
    Productmaster current = new Productmaster();

    public Productmaster getCurrent() {
        return current;
    }

    public void setCurrent(Productmaster current) {
        this.current = current;
    }
    Collection<Productmaster> products;
    GenericType<Collection<Productmaster>> gproduct;
    
    Collection<Catagorymaster> catagorys;
    GenericType<Collection<Catagorymaster>> gcatagory;
    
    int cid;

    public Productmaster getP() {
        return p;
    }

    public void setP(Productmaster p) {
        this.p = p;
    }

    public Catagorymaster getC() {
        return c;
    }

    public void setC(Catagorymaster c) {
        this.c = c;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
    public productManageBean() {
        
        p = new Productmaster();
        c = new Catagorymaster();
        pc = new productClient();
        products = new ArrayList<>();
        gproduct = new GenericType<Collection<Productmaster>>(){};
        catagorys = new ArrayList<>();
        gcatagory = new GenericType<Collection<Catagorymaster>>(){};
        
    }

    public Collection<Catagorymaster> getCatagorys() {
        rs = pc.getAllcatagory(Response.class);
        catagorys = rs.readEntity(gcatagory);
        return catagorys;
    }

    public void setCatagorys(Collection<Catagorymaster> catagorys) {
        
        this.catagorys = catagorys;
    }
    
    

    public Collection<Productmaster> getProducts() {
        rs = pc.getAllProduct(Response.class);
        products = rs.readEntity(gproduct);
        return products;
    }

    public void setProducts(Collection<Productmaster> products) {
        this.products = products;
    }
    
    
    
    public String addProduct()
    {
        System.out.println(cid);
        String pname = p.getProductName();
        int price = p.getPrice();
        
        pc.addProduct(pname, String.valueOf(price), String.valueOf(cid));
        
        return "index.xhtml";
        
    }
     public String editProduct()
    {
        int pid = current.getPid();
        String pname = current.getProductName();
        int price = current.getPrice();
        cid = current.getCid().getCid();
        
        pc.editProduct(String.valueOf(pid), pname, String.valueOf(price), String.valueOf(cid));
        
        return "index.xhtml";
        
    }
    
    
    
    
    public String redirectAddproduct()
    {
        return "addProduct.xhtml";
    }
    public String redirectEditproduct()
    {
        return "editProduct.xhtml";
    }
}
