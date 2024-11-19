package com.mycompany.crudinrestexam.resources;

import ejb.productBeanLocal;
import entity.Catagorymaster;
import entity.Productmaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
    // reast of product master :=
    
    @EJB productBeanLocal pbl;
    
    @POST
    @Path("/addProduct/{pname}/{price}/{cid}")
    public void addProduct(@PathParam("pname") String pname,@PathParam("price") int price,@PathParam("cid") int cid)
    {
        pbl.addProduct(pname, price, cid);
    }
     @POST
    @Path("/editProduct/{pid}/{pname}/{price}/{cid}")
    public void editProduct(@PathParam("pid") int pid,@PathParam("pname") String pname,@PathParam("price") int price,@PathParam("cid") int cid)
    {
        pbl.editProduct(pid, pname, price, cid);
    }
    
    @GET
    @Produces("application/json")
    public Collection<Productmaster> getAllProduct()
    {
        return pbl.getAllProduct();
    }
    @GET
    @Path("/catagory")
    @Produces("application/json")
    public Collection<Catagorymaster> getAllcatagory()
    {
        return pbl.getAllCatagory();
    }
}
