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
@Table(name = "dining_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiningTable.findAll", query = "SELECT d FROM DiningTable d")
    , @NamedQuery(name = "DiningTable.findByPkDiningTableId", query = "SELECT d FROM DiningTable d WHERE d.pkDiningTableId = :pkDiningTableId")
    , @NamedQuery(name = "DiningTable.findByMaxNumberDiners", query = "SELECT d FROM DiningTable d WHERE d.maxNumberDiners = :maxNumberDiners")
    , @NamedQuery(name = "DiningTable.findByLocation", query = "SELECT d FROM DiningTable d WHERE d.location = :location")})
public class DiningTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_dining_table_id")
    private Integer pkDiningTableId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_number_diners")
    private int maxNumberDiners;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "location")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDiningTableId")
    private List<Invoice> invoiceList;

    public DiningTable() {
    }

    public DiningTable(Integer pkDiningTableId) {
        this.pkDiningTableId = pkDiningTableId;
    }

    public DiningTable(Integer pkDiningTableId, int maxNumberDiners, String location) {
        this.pkDiningTableId = pkDiningTableId;
        this.maxNumberDiners = maxNumberDiners;
        this.location = location;
    }

    public Integer getPkDiningTableId() {
        return pkDiningTableId;
    }

    public void setPkDiningTableId(Integer pkDiningTableId) {
        this.pkDiningTableId = pkDiningTableId;
    }

    public int getMaxNumberDiners() {
        return maxNumberDiners;
    }

    public void setMaxNumberDiners(int maxNumberDiners) {
        this.maxNumberDiners = maxNumberDiners;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        hash += (pkDiningTableId != null ? pkDiningTableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiningTable)) {
            return false;
        }
        DiningTable other = (DiningTable) object;
        if ((this.pkDiningTableId == null && other.pkDiningTableId != null) || (this.pkDiningTableId != null && !this.pkDiningTableId.equals(other.pkDiningTableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.model.DiningTable[ pkDiningTableId=" + pkDiningTableId + " ]";
    }
    
}
