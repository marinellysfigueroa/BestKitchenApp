/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;


import com.conexia.entities.Chef;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mfigueroa
 */
@Named(value = "chefController")
@SessionScoped
public class ChefController implements Serializable {

    @EJB
    private com.conexia.model.ChefFacade chefFacade;
    private Chef chef= new Chef();

    
    public ChefController() {
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }
    
    public  List<Chef> findAll()
    {
        return this.chefFacade.findAll();
    }
    public String add(Chef chef)
    {
        this.chefFacade.create(chef);
        return "index";
    }
    
}
