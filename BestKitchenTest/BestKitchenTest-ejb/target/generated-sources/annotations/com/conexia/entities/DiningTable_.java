package com.conexia.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DiningTable.class)
public abstract class DiningTable_ {

	public static volatile ListAttribute<DiningTable, Invoice> invoiceList;
	public static volatile SingularAttribute<DiningTable, Integer> maxNumberDiners;
	public static volatile SingularAttribute<DiningTable, String> location;
	public static volatile SingularAttribute<DiningTable, Integer> pkDiningTableId;

}

