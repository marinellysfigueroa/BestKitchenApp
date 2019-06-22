/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.entities.VwTotalInvocedByClientVip;
import com.conexia.model.VwTotalInvocedByClientVipFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mfigueroa
 */
@Named(value = "reportClientController")
@SessionScoped
public class ReportClientController implements Serializable {

    @EJB
    private VwTotalInvocedByClientVipFacade rpClientFacade;
    private VwTotalInvocedByClientVip client= new VwTotalInvocedByClientVip();

    public VwTotalInvocedByClientVip getClient() {
        return client;
    }

    public void setClient(VwTotalInvocedByClientVip client) {
        this.client = client;
    }
    
    
    public ReportClientController() {
    }
    public List<VwTotalInvocedByClientVip> findAll()
    {
        return this.rpClientFacade.findAll();
    }
    
    public String add()
    {
     this.rpClientFacade.create(this.client);
     return "reportClient";   
    }
    
}
