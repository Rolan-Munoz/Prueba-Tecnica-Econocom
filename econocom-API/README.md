# PRUEBA TÉCNICA PARA ECONOCOM;
# Esta parte del proyecto es la parte backend de la prueba técnica propuesta por econocom con motivo
# del proceso de selección para la posición de desarrollador fullstack

# Este proyecto desarrollado con Spring Boot en su version 2.7.18 y java en su version 8, tiene como
# objetivo la creación de un API REST que permita la creación de usuarios y su autenticación haciendo
# de spring seguridad y JWT.


# Para la creación de este proyecto se ha utilizado el IDE IntelliJ IDEA, y se ha hecho uso de la 
# herramienta web https://start.spring.io/ para la creación del proyecto base, añadiendo los siguientes
# starter y dependencias :
# - Spring Web
# - Spring Security
# - Spring Data JPA
# - H2 Database
# - Lombok
# - JWT

# Para la creación de la base de datos se ha utilizado H2, una base de datos en memoria que permite 
# realizar pruebas de manera rápida y sencilla, además de ser compatible con JPA y Hibernate.

# La estructura del proyecto sigue el patrón de diseño MVC (Modelo-Vista-Controlador), donde:
# - El modelo representa la estructura de los datos y la lógica de negocio.
# - La vista es la representación de los datos, en este caso, se ha realizado a traves de Angular
# - El controlador es el encargado de recibir las peticiones y devolver las respuestas, en este caso,

# Se ha optado también por una separación por capas en el proyecto, donde:
# La capa de dominio contiene las entidades y la persistencia en base de datos.
# La capa de infrastructure contiene los repositorios y los controladores.
# La capa de application contiene los servicios, mappers y DTOs con los que trabajaremos en el cliente.
# La capa de security contiene la configuración de seguridad y los filtros de autenticación, asi como 
# las utilidades necesarias para configurar JWT
# De esta manera logramos tener un codigo mas limpio, escalable, mantenible y desacoplado

