/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.entities.DiningTable;
import com.conexia.model.DiningTableFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mfigueroa
 */
@Named(value = "diningTableController")
@SessionScoped
public class DiningTableController implements Serializable {

    @EJB
    private DiningTableFacade diningTableFacade;
    private DiningTable dt=new DiningTable();

    public DiningTable getDt() {
        return dt;
    }

    public void setDt(DiningTable dt) {
        this.dt = dt;
    }
    
    
    
    public DiningTableController() {
    }
    
    public List<DiningTable> findAll()
    {
        return this.diningTableFacade.findAll();
    }
    public String add()
    {
        this.diningTableFacade.create(this.dt);
        return "diningTable";
    }
    
}
