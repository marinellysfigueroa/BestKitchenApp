/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.entities.Waiter;
import com.conexia.model.WaiterFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mfigueroa
 */
@Named(value = "waiterController")
@SessionScoped
public class WaiterController implements Serializable {

    @EJB
    private WaiterFacade waiterFacade;
    private Waiter waiter = new Waiter();

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    
    public WaiterController() {
    }
    
    public List<Waiter> findAll()
    {
        return this.waiterFacade.findAll();
        
    }
    public String add()
    {
        this.waiterFacade.create(this.waiter);
        return "waiter";
    }
    
}
