/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author mfigueroa
 */
@Named(value = "invoiceController")
@SessionScoped
public class InvoiceController implements Serializable {

    /**
     * Creates a new instance of InvoiceController
     */
    public InvoiceController() {
    }
    
}
