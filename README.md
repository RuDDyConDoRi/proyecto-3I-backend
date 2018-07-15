## Proyecto-3I-backend

###### Software necesario: 
* Instalar y configurar el jdk de java version 1.7 o superior, revisar la instalacion desde su terminal:
  
  `$> java -version`
  `java version "1.7.0"`

* Instalar y configurar MAVEN version 3.0 o superior, revisar la instalacion:
  `$> mvn --version`
  `Apache Maven 3.5.0 (ff8ff6095c62210b5713f426; 2017-04-03T15:39:06-   04:00)`
  `java version "1.7.0"`

* Tener `mySql`, corriendo en el puerto `3306` con el usuario `root` y el password en blanco.

## 
###### Pasos para ejecutar el servicio REST 

Ingresar a la carpeta `proyecto-3I-backend`, ahi se encuentran las siguientes carpetas:
> * com.ctr.iii.dominio
> * com.ctr.iii.dao
> * com.ctr.iii.servicio
> * com.ctr.iii.servicio.web

1. Ingresar a la carpeta `com.ctr.iii.dominio`, ahi ejecutar el siguiente comando de maven:
   
   `$ ../proyecto-3I-backend/com.ctr.iii.dominio> mvn -o install`
   
   esperar a que muestre el mensaje:
   
   `[INFO] ----------------------------------------------------------------------------------`
   `[INFO] BUILD SUCCESS`
   `[INFO] ----------------------------------------------------------------------------------`
   
2. Ingresar a la carpeta `com.ctr.iii.dao`, ahi ejecutar el siguiente comando de maven:
   
   `$ ../proyecto-3I-backend/com.ctr.iii.dao> mvn -o install`
   
   esperar a que muestre el mensaje:
   
   `[INFO] ----------------------------------------------------------------------------------`
   `[INFO] BUILD SUCCESS`
   `[INFO] ----------------------------------------------------------------------------------`

3. Ingresar a la carpeta `com.ctr.iii.servicio`, ahi ejecutar el siguiente comando de maven:
   
   `$ ../proyecto-3I-backend/com.ctr.iii.servicio> mvn -o install`
   
   esperar a que muestre el mensaje:
   
   `[INFO] ----------------------------------------------------------------------`
   `[INFO] BUILD SUCCESS`
   `[INFO] ----------------------------------------------------------------------`

4. Ingresar a la carpeta `com.ctr.iii.servicio.web`, ahi ejecutar el siguiente comando de maven:
   
   `$ ../proyecto-3I-backend/com.ctr.iii.servicio.web> mvn -o install`
   
   esperar a que muestre el mensaje:
   
   `[INFO] ----------------------------------------------------------------------------------`
   `[INFO] BUILD SUCCESS`
   `[INFO] ----------------------------------------------------------------------------------`

    Desplegar desde la carpeta `com.ctr.iii.servicio.web`, con el siguiente comando de maven:
   
   `$ ../proyecto-3I-backend/com.ctr.iii.servicio.web> mvn jetty:run-war`
   
   esperar a que muestre el mensaje:
   
   `[INFO] Started ServerConnector@4ce8ca9f{HTTP/1.1}{localhost:8080}`
   `[INFO] Started Jetty Server`
   `[INFO] Starting scanner at interval of 10 seconds.`

	Verificar el servicio REST ingresando a la direccion:
    
    `http://localhost:8080/`
    
    El mensaje de respuesta sera:
    
    `Resultado de verificacion del Servicio REST`