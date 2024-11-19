/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:JakartaEE8Resource [rest]<br>
 * USAGE:
 * <pre>
 *        productClient client = new productClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author LENOVO
 */
public class productClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/crudinrestexam/resources";

    public productClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public void addProduct(String pname, String price, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addProduct/{0}/{1}/{2}", new Object[]{pname, price, cid})).request().post(null);
    }

    public <T> T getAllcatagory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("catagory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllProduct(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void editProduct(String pid, String pname, String price, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editProduct/{0}/{1}/{2}/{3}", new Object[]{pid, pname, price, cid})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
