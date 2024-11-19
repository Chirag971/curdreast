/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "catagorymaster")
@NamedQueries({
    @NamedQuery(name = "Catagorymaster.findAll", query = "SELECT c FROM Catagorymaster c"),
    @NamedQuery(name = "Catagorymaster.findByCid", query = "SELECT c FROM Catagorymaster c WHERE c.cid = :cid"),
    @NamedQuery(name = "Catagorymaster.findByCatagoryName", query = "SELECT c FROM Catagorymaster c WHERE c.catagoryName = :catagoryName")})
public class Catagorymaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid")
    private Integer cid;
    @Size(max = 255)
    @Column(name = "catagory_name")
    private String catagoryName;
    @OneToMany(mappedBy = "cid")
    private Collection<Productmaster> productmasterCollection;

    public Catagorymaster() {
    }

    public Catagorymaster(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    @JsonbTransient
    public Collection<Productmaster> getProductmasterCollection() {
        return productmasterCollection;
    }

    public void setProductmasterCollection(Collection<Productmaster> productmasterCollection) {
        this.productmasterCollection = productmasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catagorymaster)) {
            return false;
        }
        Catagorymaster other = (Catagorymaster) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Catagorymaster[ cid=" + cid + " ]";
    }
    
}
