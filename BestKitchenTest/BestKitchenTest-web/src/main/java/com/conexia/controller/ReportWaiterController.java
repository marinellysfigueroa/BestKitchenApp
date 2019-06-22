/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.entities.VwTotalInvoicedMonthlyByWaiter;
import com.conexia.model.VwTotalInvoicedMonthlyByWaiterFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mfigueroa
 */
@Named(value = "reportWaiterController")
@SessionScoped
public class ReportWaiterController implements Serializable {

    @EJB
    private VwTotalInvoicedMonthlyByWaiterFacade rpWaiterFacade;
    private VwTotalInvoicedMonthlyByWaiter waiter = new VwTotalInvoicedMonthlyByWaiter();

    public VwTotalInvoicedMonthlyByWaiter getWaiter() {
        return waiter;
    }

    public void setWaiter(VwTotalInvoicedMonthlyByWaiter waiter) {
        this.waiter = waiter;
    }
    
    

   
    public ReportWaiterController() {
    }
    
    public List<VwTotalInvoicedMonthlyByWaiter> findAll()
    {
        return this.rpWaiterFacade.findAll();
    }
    public String add()
    {
        this.rpWaiterFacade.create(this.waiter);
        return "reportWaiter";
    }
    
}
