/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.entities.Invoice;
import com.conexia.model.InvoiceFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mfigueroa
 */
@Named(value = "invoiceController")
@SessionScoped
public class InvoiceController implements Serializable {

    @EJB
    private InvoiceFacade invoiceFacade;
    private Invoice inv=new Invoice();

    public Invoice getInv() {
        return inv;
    }

    public void setInv(Invoice inv) {
        this.inv = inv;
    }
    

    
    
    public InvoiceController() {
    }
    
    public List<Invoice> findAll()
    {
        return this.invoiceFacade.findAll();
    }
    
    public String add()
    {
        this.invoiceFacade.create(this.inv);
        return "invoice";
    }
    
}
