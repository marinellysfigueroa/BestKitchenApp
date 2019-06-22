/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mfigueroa
 */
@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i")
    , @NamedQuery(name = "Invoice.findByPkInvoiceId", query = "SELECT i FROM Invoice i WHERE i.pkInvoiceId = :pkInvoiceId")
    , @NamedQuery(name = "Invoice.findByFkClientId", query = "SELECT i FROM Invoice i WHERE i.fkClientId = :fkClientId")
    , @NamedQuery(name = "Invoice.findByDate", query = "SELECT i FROM Invoice i WHERE i.date = :date")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_invoice_id")
    private Integer pkInvoiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_client_id")
    private int fkClientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkInvoiceId")
    private List<InvoiceDetail> invoiceDetailList;
    @JoinColumn(name = "pk_invoice_id", referencedColumnName = "pk_client_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Client client;
    @JoinColumn(name = "fk_dining_table_id", referencedColumnName = "pk_dining_table_id")
    @ManyToOne(optional = false)
    private DiningTable fkDiningTableId;
    @JoinColumn(name = "fk_waiter_id", referencedColumnName = "pk_waiter_id")
    @ManyToOne(optional = false)
    private Waiter fkWaiterId;

    public Invoice() {
    }

    public Invoice(Integer pkInvoiceId) {
        this.pkInvoiceId = pkInvoiceId;
    }

    public Invoice(Integer pkInvoiceId, int fkClientId, Date date) {
        this.pkInvoiceId = pkInvoiceId;
        this.fkClientId = fkClientId;
        this.date = date;
    }

    public Integer getPkInvoiceId() {
        return pkInvoiceId;
    }

    public void setPkInvoiceId(Integer pkInvoiceId) {
        this.pkInvoiceId = pkInvoiceId;
    }

    public int getFkClientId() {
        return fkClientId;
    }

    public void setFkClientId(int fkClientId) {
        this.fkClientId = fkClientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DiningTable getFkDiningTableId() {
        return fkDiningTableId;
    }

    public void setFkDiningTableId(DiningTable fkDiningTableId) {
        this.fkDiningTableId = fkDiningTableId;
    }

    public Waiter getFkWaiterId() {
        return fkWaiterId;
    }

    public void setFkWaiterId(Waiter fkWaiterId) {
        this.fkWaiterId = fkWaiterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkInvoiceId != null ? pkInvoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.pkInvoiceId == null && other.pkInvoiceId != null) || (this.pkInvoiceId != null && !this.pkInvoiceId.equals(other.pkInvoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.model.Invoice[ pkInvoiceId=" + pkInvoiceId + " ]";
    }
    
}
