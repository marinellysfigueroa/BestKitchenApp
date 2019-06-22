/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;


import com.conexia.entities.*;
import com.conexia.model.ChefFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;

/**
 *
 * @author mfigueroa
 */
@Named(value = "chefController")
@SessionScoped
public class ChefController implements Serializable {

    @EJB
    private ChefFacade chefFacade;
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
        System.out.println("this.chefFacade "+this.chefFacade);
        return this.chefFacade.findAll();
    }
    public String add()
    {
        this.chefFacade.create(this.chef);
        this.chef=new Chef();
        return "chef";
    }
    
}
