/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.entities.Client;
import com.conexia.model.ClientFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mfigueroa
 */
@Named(value = "clientController")
@SessionScoped
public class ClientController implements Serializable {

    @EJB
    private ClientFacade clientFacade;
    private Client client =new Client();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    

    
    public ClientController() {
    }
    public List<Client> findAll()
    {
        return this.clientFacade.findAll();
    }
    public String add()
    {
        this.clientFacade.create(this.client);
        return "client";
    }
    
}
