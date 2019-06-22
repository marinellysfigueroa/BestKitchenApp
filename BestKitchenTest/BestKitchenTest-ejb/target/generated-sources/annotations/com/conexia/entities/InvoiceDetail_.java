package com.conexia.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InvoiceDetail.class)
public abstract class InvoiceDetail_ {

	public static volatile SingularAttribute<InvoiceDetail, Double> amount;
	public static volatile SingularAttribute<InvoiceDetail, Chef> fkChefId;
	public static volatile SingularAttribute<InvoiceDetail, Invoice> fkInvoiceId;
	public static volatile SingularAttribute<InvoiceDetail, Integer> pkInvoiceDetailId;
	public static volatile SingularAttribute<InvoiceDetail, String> plate;

}

