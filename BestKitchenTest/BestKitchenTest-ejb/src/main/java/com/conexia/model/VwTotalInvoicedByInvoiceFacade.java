/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.model;

import com.conexia.entities.VwTotalInvoicedByInvoice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mfigueroa
 */
@Stateless
public class VwTotalInvoicedByInvoiceFacade extends AbstractFacade<VwTotalInvoicedByInvoice> {

    @PersistenceContext(unitName = "BestKitchenTest-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VwTotalInvoicedByInvoiceFacade() {
        super(VwTotalInvoicedByInvoice.class);
    }
    
}
