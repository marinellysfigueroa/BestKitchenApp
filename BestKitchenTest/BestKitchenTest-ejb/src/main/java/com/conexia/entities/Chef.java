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
@Table(name = "chef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chef.findAll", query = "SELECT c FROM Chef c")
    , @NamedQuery(name = "Chef.findByPkChefId", query = "SELECT c FROM Chef c WHERE c.pkChefId = :pkChefId")
    , @NamedQuery(name = "Chef.findByName", query = "SELECT c FROM Chef c WHERE c.name = :name")
    , @NamedQuery(name = "Chef.findByFirstLastName", query = "SELECT c FROM Chef c WHERE c.firstLastName = :firstLastName")
    , @NamedQuery(name = "Chef.findBySecondLastName", query = "SELECT c FROM Chef c WHERE c.secondLastName = :secondLastName")})
public class Chef implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_chef_id")
    private Integer pkChefId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkChefId")
    private List<InvoiceDetail> invoiceDetailList;

    public Chef() {
    }

    public Chef(Integer pkChefId) {
        this.pkChefId = pkChefId;
    }

    public Chef(Integer pkChefId, String name, String firstLastName) {
        this.pkChefId = pkChefId;
        this.name = name;
        this.firstLastName = firstLastName;
    }

    public Integer getPkChefId() {
        return pkChefId;
    }

    public void setPkChefId(Integer pkChefId) {
        this.pkChefId = pkChefId;
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
    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkChefId != null ? pkChefId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chef)) {
            return false;
        }
        Chef other = (Chef) object;
        if ((this.pkChefId == null && other.pkChefId != null) || (this.pkChefId != null && !this.pkChefId.equals(other.pkChefId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.model.Chef[ pkChefId=" + pkChefId + " ]";
    }
    
}
