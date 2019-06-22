/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mfigueroa
 */
@Entity
@Table(name = "waiter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Waiter.findAll", query = "SELECT w FROM Waiter w")
    , @NamedQuery(name = "Waiter.findByPkWaiterId", query = "SELECT w FROM Waiter w WHERE w.pkWaiterId = :pkWaiterId")
    , @NamedQuery(name = "Waiter.findByName", query = "SELECT w FROM Waiter w WHERE w.name = :name")
    , @NamedQuery(name = "Waiter.findByFirstLastName", query = "SELECT w FROM Waiter w WHERE w.firstLastName = :firstLastName")
    , @NamedQuery(name = "Waiter.findBySecondLastName", query = "SELECT w FROM Waiter w WHERE w.secondLastName = :secondLastName")})
public class Waiter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_waiter_id")
    private Integer pkWaiterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_last_name")
    private String firstLastName;
    @Size(max = 25)
    @Column(name = "second_last_name")
    private String secondLastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkWaiterId")
    private List<Invoice> invoiceList;

    public Waiter() {
    }

    public Waiter(Integer pkWaiterId) {
        this.pkWaiterId = pkWaiterId;
    }

    public Waiter(Integer pkWaiterId, String name, String firstLastName) {
        this.pkWaiterId = pkWaiterId;
        this.name = name;
        this.firstLastName = firstLastName;
    }

    public Integer getPkWaiterId() {
        return pkWaiterId;
    }

    public void setPkWaiterId(Integer pkWaiterId) {
        this.pkWaiterId = pkWaiterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkWaiterId != null ? pkWaiterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Waiter)) {
            return false;
        }
        Waiter other = (Waiter) object;
        if ((this.pkWaiterId == null && other.pkWaiterId != null) || (this.pkWaiterId != null && !this.pkWaiterId.equals(other.pkWaiterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.model.Waiter[ pkWaiterId=" + pkWaiterId + " ]";
    }
    
}
