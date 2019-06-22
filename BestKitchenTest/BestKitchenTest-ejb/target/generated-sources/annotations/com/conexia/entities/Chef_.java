package com.conexia.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Chef.class)
public abstract class Chef_ {

	public static volatile SingularAttribute<Chef, Integer> pkChefId;
	public static volatile SingularAttribute<Chef, String> secondLastName;
	public static volatile SingularAttribute<Chef, String> firstLastName;
	public static volatile ListAttribute<Chef, InvoiceDetail> invoiceDetailList;
	public static volatile SingularAttribute<Chef, String> name;

}

