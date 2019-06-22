/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "vw_total_invoiced_monthly_by_waiter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTotalInvoicedMonthlyByWaiter.findAll", query = "SELECT v FROM VwTotalInvoicedMonthlyByWaiter v")
    , @NamedQuery(name = "VwTotalInvoicedMonthlyByWaiter.findByPkWaiterId", query = "SELECT v FROM VwTotalInvoicedMonthlyByWaiter v WHERE v.pkWaiterId = :pkWaiterId")
    , @NamedQuery(name = "VwTotalInvoicedMonthlyByWaiter.findByName", query = "SELECT v FROM VwTotalInvoicedMonthlyByWaiter v WHERE v.name = :name")
    , @NamedQuery(name = "VwTotalInvoicedMonthlyByWaiter.findByFirstLastName", query = "SELECT v FROM VwTotalInvoicedMonthlyByWaiter v WHERE v.firstLastName = :firstLastName")
    , @NamedQuery(name = "VwTotalInvoicedMonthlyByWaiter.findBySecondLastName", query = "SELECT v FROM VwTotalInvoicedMonthlyByWaiter v WHERE v.secondLastName = :secondLastName")
    , @NamedQuery(name = "VwTotalInvoicedMonthlyByWaiter.findByMonth", query = "SELECT v FROM VwTotalInvoicedMonthlyByWaiter v WHERE v.month = :month")
    , @NamedQuery(name = "VwTotalInvoicedMonthlyByWaiter.findByNameMonth", query = "SELECT v FROM VwTotalInvoicedMonthlyByWaiter v WHERE v.nameMonth = :nameMonth")
    , @NamedQuery(name = "VwTotalInvoicedMonthlyByWaiter.findByYear", query = "SELECT v FROM VwTotalInvoicedMonthlyByWaiter v WHERE v.year = :year")
    , @NamedQuery(name = "VwTotalInvoicedMonthlyByWaiter.findByTotal", query = "SELECT v FROM VwTotalInvoicedMonthlyByWaiter v WHERE v.total = :total")})
public class VwTotalInvoicedMonthlyByWaiter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "pk_waiter_id")
    private Integer pkWaiterId;
    @Size(max = 25)
    @Column(name = "name")
    private String name;
    @Size(max = 25)
    @Column(name = "first_last_name")
    private String firstLastName;
    @Size(max = 25)
    @Column(name = "second_last_name")
    private String secondLastName;
    @Size(max = 2147483647)
    @Column(name = "month")
    private String month;
    @Size(max = 2147483647)
    @Column(name = "name_month")
    private String nameMonth;
    @Size(max = 2147483647)
    @Column(name = "year")
    private String year;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;

    public VwTotalInvoicedMonthlyByWaiter() {
    }

    public Integer getPkWaiterId() {
        return pkWaiterId;
    }

    public void setPkWaiterId(Integer pkWaiterId) {
        this.pkWaiterId = pkWaiterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNameMonth() {
        return nameMonth;
    }

    public void setNameMonth(String nameMonth) {
        this.nameMonth = nameMonth;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
