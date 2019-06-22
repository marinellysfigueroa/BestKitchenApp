package com.conexia.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static volatile SingularAttribute<Client, String> secondLastName;
	public static volatile SingularAttribute<Client, String> firtsLastName;
	public static volatile SingularAttribute<Client, String> observations;
	public static volatile SingularAttribute<Client, String> name;
	public static volatile SingularAttribute<Client, Integer> pkClientId;
	public static volatile SingularAttribute<Client, Invoice> invoice;

}

