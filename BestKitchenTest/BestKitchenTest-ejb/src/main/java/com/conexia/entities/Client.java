/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mfigueroa
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByPkClientId", query = "SELECT c FROM Client c WHERE c.pkClientId = :pkClientId")
    , @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name")
    , @NamedQuery(name = "Client.findByFirtsLastName", query = "SELECT c FROM Client c WHERE c.firtsLastName = :firtsLastName")
    , @NamedQuery(name = "Client.findBySecondLastName", query = "SELECT c FROM Client c WHERE c.secondLastName = :secondLastName")
    , @NamedQuery(name = "Client.findByObservations", query = "SELECT c FROM Client c WHERE c.observations = :observations")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_client_id")
    private Integer pkClientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "firts_last_name")
    private String firtsLastName;
    @Size(max = 25)
    @Column(name = "second_last_name")
    private String secondLastName;
    @Size(max = 50)
    @Column(name = "observations")
    private String observations;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
    private Invoice invoice;

    public Client() {
    }

    public Client(Integer pkClientId) {
        this.pkClientId = pkClientId;
    }

    public Client(Integer pkClientId, String name, String firtsLastName) {
        this.pkClientId = pkClientId;
        this.name = name;
        this.firtsLastName = firtsLastName;
    }

    public Integer getPkClientId() {
        return pkClientId;
    }

    public void setPkClientId(Integer pkClientId) {
        this.pkClientId = pkClientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirtsLastName() {
        return firtsLastName;
    }

    public void setFirtsLastName(String firtsLastName) {
        this.firtsLastName = firtsLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkClientId != null ? pkClientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.pkClientId == null && other.pkClientId != null) || (this.pkClientId != null && !this.pkClientId.equals(other.pkClientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.model.Client[ pkClientId=" + pkClientId + " ]";
    }
    
}
