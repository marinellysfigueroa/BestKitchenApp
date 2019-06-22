/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.entities.InvoiceDetail;
import com.conexia.model.InvoiceDetailFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mfigueroa
 */
@Named(value = "invoiceDetailController")
@SessionScoped
public class InvoiceDetailController implements Serializable {

    @EJB
    private InvoiceDetailFacade invoiceDetailFacade;
    private InvoiceDetail invD=new InvoiceDetail();

    public InvoiceDetail getInvD() {
        return invD;
    }

    public void setInvD(InvoiceDetail invD) {
        this.invD = invD;
    }
    
    
    
    public InvoiceDetailController() {
    }
    
    public List<InvoiceDetail> findAll()
    {
        return this.invoiceDetailFacade.findAll();
    }
    public String add()
    {
        this.invoiceDetailFacade.create(this.invD);
        return "invoice";
    }
    
}
