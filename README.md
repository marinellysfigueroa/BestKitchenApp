
# Creación y configuración de la base de datos
En el presente repositorio encontrará un documento contentivo del diagrama ER diseñado para materializar la presente prueba técnica, dicho modelo debe ser ejecutado en una base de datos postgresql, para ello se adjunta el script best_kitchen.sql. Contentivo de la estructura de base de datos y una pequeña muestra de datos. Es importante aclarar que se debe crear la base de datos y un usuario con permisos de superusurio llamado conexia_app y clave c0n3x14.

A los efectos de la configuración de la base de datos, ejecute por consola los siguientes pasos:
psql -h 127.0.0.1 -U postgres postgres

create database best_kitchen;
create user conexia_app with encrypted password 'c0n3x14';
grant all privileges on database best_kitchen to conexia_app;

Luego restaure la base de datos ejecutando en el terminal, ubicado en la ruta donde haya descargado el archivo:
psql -h 127.0.0.1 -U conexia_app best_kitchen < best_kitchen.sql
# Arquitectura de la aplicación
En este repositorio también encotrará una carpeta denominada BestKitchenTest la cual contiene en su interior los proyectos construidos y gestionados a través de la herramienta "maven".

En cuanto a la arquitectura se elaboró una aplicación empresarial compuesta por una aplicación web y una aplicación de negocios. 
La aplicación Web fue elaborada haciendo uso de Java Server Faces (JSF) y PrimeFaces, mientras que la para la aplicación de negocios se hizo uso de JPA, EJB y Hibernate.

Dichas aplicaciones fueron desarrolladas y desplegadas haciendo uso del servidor Glassfish y el IDE Netbeans.

