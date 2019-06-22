package com.conexia.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Invoice.class)
public abstract class Invoice_ {

	public static volatile SingularAttribute<Invoice, Date> date;
	public static volatile SingularAttribute<Invoice, DiningTable> fkDiningTableId;
	public static volatile SingularAttribute<Invoice, Integer> fkClientId;
	public static volatile ListAttribute<Invoice, InvoiceDetail> invoiceDetailList;
	public static volatile SingularAttribute<Invoice, Integer> pkInvoiceId;
	public static volatile SingularAttribute<Invoice, Client> client;
	public static volatile SingularAttribute<Invoice, Waiter> fkWaiterId;

}

