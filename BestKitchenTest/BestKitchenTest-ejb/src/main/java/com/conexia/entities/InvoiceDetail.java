/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mfigueroa
 */
@Entity
@Table(name = "invoice_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceDetail.findAll", query = "SELECT i FROM InvoiceDetail i")
    , @NamedQuery(name = "InvoiceDetail.findByPkInvoiceDetailId", query = "SELECT i FROM InvoiceDetail i WHERE i.pkInvoiceDetailId = :pkInvoiceDetailId")
    , @NamedQuery(name = "InvoiceDetail.findByPlate", query = "SELECT i FROM InvoiceDetail i WHERE i.plate = :plate")
    , @NamedQuery(name = "InvoiceDetail.findByAmount", query = "SELECT i FROM InvoiceDetail i WHERE i.amount = :amount")})
public class InvoiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_invoice_detail_id")
    private Integer pkInvoiceDetailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "plate")
    private String plate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @JoinColumn(name = "fk_chef_id", referencedColumnName = "pk_chef_id")
    @ManyToOne(optional = false)
    private Chef fkChefId;
    @JoinColumn(name = "fk_invoice_id", referencedColumnName = "pk_invoice_id")
    @ManyToOne(optional = false)
    private Invoice fkInvoiceId;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Integer pkInvoiceDetailId) {
        this.pkInvoiceDetailId = pkInvoiceDetailId;
    }

    public InvoiceDetail(Integer pkInvoiceDetailId, String plate, double amount) {
        this.pkInvoiceDetailId = pkInvoiceDetailId;
        this.plate = plate;
        this.amount = amount;
    }

    public Integer getPkInvoiceDetailId() {
        return pkInvoiceDetailId;
    }

    public void setPkInvoiceDetailId(Integer pkInvoiceDetailId) {
        this.pkInvoiceDetailId = pkInvoiceDetailId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Chef getFkChefId() {
        return fkChefId;
    }

    public void setFkChefId(Chef fkChefId) {
        this.fkChefId = fkChefId;
    }

    public Invoice getFkInvoiceId() {
        return fkInvoiceId;
    }

    public void setFkInvoiceId(Invoice fkInvoiceId) {
        this.fkInvoiceId = fkInvoiceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkInvoiceDetailId != null ? pkInvoiceDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceDetail)) {
            return false;
        }
        InvoiceDetail other = (InvoiceDetail) object;
        if ((this.pkInvoiceDetailId == null && other.pkInvoiceDetailId != null) || (this.pkInvoiceDetailId != null && !this.pkInvoiceDetailId.equals(other.pkInvoiceDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.model.InvoiceDetail[ pkInvoiceDetailId=" + pkInvoiceDetailId + " ]";
    }
    
}
