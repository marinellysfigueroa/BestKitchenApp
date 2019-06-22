# Prueba técnica Conexia
Repositorio creado para compartir las fuentes de la prueba técnica desarrollada para aplicar al cargo de desarrollador en la empresa Conexia.
# Creación y configuración de la base de datos
En el presente repositorio encontrará un documento contentivo del diagrama ER diseñado para materializar la presente prueba técnica, dicho modelo debe ser ejecutado en una base de datos postgresql, para ello se adjunta el script best_kitchen.sql. Contentivo de la estructura de base de datos y una pequeña muestra de datos. Es importante aclarar que se debe crear la base de datos y un usuario con permisos de superusurio llamado conexia_app y clave c0n3x14.

A los efectos de la configuración de la base de datos, ejecute por consola los siguientes pasos:
psql -h 127.0.0.1 -U postgres postgres

create database best_kitchen;
create user conexia_app with encrypted password 'c0n3x14';
grant all privileges on database best_kitchen to conexia_app;

Luego restaure la base de datos ejecutando en el terminal, ubicado en la ruta donde haya descargado el archivo:
psql -h 127.0.0.1 -U conexia_app best_kitchen < best_kitchen.sql




