/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mfigueroa
 */
@Entity
@Table(name = "vw_total_invoced_by_client_vip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTotalInvocedByClientVip.findAll", query = "SELECT v FROM VwTotalInvocedByClientVip v")
    , @NamedQuery(name = "VwTotalInvocedByClientVip.findByPkClientId", query = "SELECT v FROM VwTotalInvocedByClientVip v WHERE v.pkClientId = :pkClientId")
    , @NamedQuery(name = "VwTotalInvocedByClientVip.findByName", query = "SELECT v FROM VwTotalInvocedByClientVip v WHERE v.name = :name")
    , @NamedQuery(name = "VwTotalInvocedByClientVip.findByFirtsLastName", query = "SELECT v FROM VwTotalInvocedByClientVip v WHERE v.firtsLastName = :firtsLastName")
    , @NamedQuery(name = "VwTotalInvocedByClientVip.findBySecondLastName", query = "SELECT v FROM VwTotalInvocedByClientVip v WHERE v.secondLastName = :secondLastName")
    , @NamedQuery(name = "VwTotalInvocedByClientVip.findByObservations", query = "SELECT v FROM VwTotalInvocedByClientVip v WHERE v.observations = :observations")
    , @NamedQuery(name = "VwTotalInvocedByClientVip.findByTotal", query = "SELECT v FROM VwTotalInvocedByClientVip v WHERE v.total = :total")})
public class VwTotalInvocedByClientVip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "pk_client_id")
    @Id
    private Integer pkClientId;
    @Size(max = 25)
    @Column(name = "name")
    private String name;
    @Size(max = 25)
    @Column(name = "firts_last_name")
    private String firtsLastName;
    @Size(max = 25)
    @Column(name = "second_last_name")
    private String secondLastName;
    @Size(max = 50)
    @Column(name = "observations")
    private String observations;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;

    public VwTotalInvocedByClientVip() {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
