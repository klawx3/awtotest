# Prueba Técnica 

Proyecto donde se encuentra lo solicitado para el **test tecnico** de awto.


## Observaciones de ejecución

El software fue desarollado bajo el motor **mariadb** .

```
mariadb  Ver 15.1 Distrib 10.5.8-MariaDB, for Linux (x86_64) using readline 5.1
```

En caso de no ser compatible con la base de datos en la cual se pruebe este proyecto (mysql o mariadb en otra versión) ;
cambiar los parametros del archivo application.properties

> nota : tambien las credenciales de accesso a la BD deben modificarse


## Otro : Observaciones de diseño de BD

La `description` deberia ser UNIQUE con el fin de restringir la duplicación de datos a nivel de base de datos.
```sql 
CREATE TABLE xxx (
	id INTEGER AUTO_INCREMENT,
	description VARCHAR(50),
	PRIMARY KEY(id)
);
```


