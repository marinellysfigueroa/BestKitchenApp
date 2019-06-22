package com.conexia.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Waiter.class)
public abstract class Waiter_ {

	public static volatile ListAttribute<Waiter, Invoice> invoiceList;
	public static volatile SingularAttribute<Waiter, String> secondLastName;
	public static volatile SingularAttribute<Waiter, String> firstLastName;
	public static volatile SingularAttribute<Waiter, Integer> pkWaiterId;
	public static volatile SingularAttribute<Waiter, String> name;

}

