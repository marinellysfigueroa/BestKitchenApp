/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mfigueroa
 */
@Entity
@Table(name = "vw_total_invoiced_by_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTotalInvoicedByInvoice.findAll", query = "SELECT v FROM VwTotalInvoicedByInvoice v")
    , @NamedQuery(name = "VwTotalInvoicedByInvoice.findByTotal", query = "SELECT v FROM VwTotalInvoicedByInvoice v WHERE v.total = :total")
    , @NamedQuery(name = "VwTotalInvoicedByInvoice.findByFkInvoiceId", query = "SELECT v FROM VwTotalInvoicedByInvoice v WHERE v.fkInvoiceId = :fkInvoiceId")})
public class VwTotalInvoicedByInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "fk_invoice_id")
    private Integer fkInvoiceId;

    public VwTotalInvoicedByInvoice() {
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getFkInvoiceId() {
        return fkInvoiceId;
    }

    public void setFkInvoiceId(Integer fkInvoiceId) {
        this.fkInvoiceId = fkInvoiceId;
    }
    
}
