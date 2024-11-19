/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "productmaster")
@NamedQueries({
    @NamedQuery(name = "Productmaster.findAll", query = "SELECT p FROM Productmaster p"),
    @NamedQuery(name = "Productmaster.findByPid", query = "SELECT p FROM Productmaster p WHERE p.pid = :pid"),
    @NamedQuery(name = "Productmaster.findByPrice", query = "SELECT p FROM Productmaster p WHERE p.price = :price"),
    @NamedQuery(name = "Productmaster.findByProductName", query = "SELECT p FROM Productmaster p WHERE p.productName = :productName")})
public class Productmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pid")
    private Integer pid;
    @Column(name = "price")
    private Integer price;
    @Size(max = 255)
    @Column(name = "product_name")
    private String productName;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne
    private Catagorymaster cid;

    public Productmaster() {
    }

    public Productmaster(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Catagorymaster getCid() {
        return cid;
    }

    public void setCid(Catagorymaster cid) {
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productmaster)) {
            return false;
        }
        Productmaster other = (Productmaster) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productmaster[ pid=" + pid + " ]";
    }
    
}
