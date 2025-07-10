# README general del proyecto y manual de uso y arranque de las aplicaciones

# La prueba tecnica consiste en la creacion de un servicio de login y autenticacion para usuarios creados con las siguientes tecnologias:
# - Backend : Spring Boot v2.7.18 y java v8
# - Frontend : Angular v16.2.16

# Se han creado las funcionalidades necesarias en ambas partes del proyecto para la comunicacion entre ambas partes. Se han creado tambien los diferentes mecanismos de seguridad con Spring Security y JWT en el backend, las validaciones necesarias de los datos ingresados por el usuario en el frontend, asi como se ha habilitado y configurado el CORS para que no exista problemas en la comunicacion entre ambas aplicaciones.

# PARA EJECUTAR LA APLICACION DEBEEMOS:
# 1- Descargar el repositorio y descomprimir la carpeta.
# 2- Desde la terminal entramos ejecutamos - cd Prueba-Tecnica-Econocom/econocom-API - para entrar en la carpeta de la API
# 3- Ejecutamos - mvn clean install -  para instalar las dependencias necesarias
# 4- Arrancamos la API ejecutando en nuestra terminal - mvn spring-boot:run - 
# 5- Entramos ahora a la carpeta del frontend ejecutando - cd Prueba-Tecnica-Econocom/econocom-frontend - 
# 6- Instalamos dependencias necesarias con - npm install - 
# 7- Arrancamos la aplicacion ejecutando - ng serve - 
# 8- Vamos a nuestro navegador y entramos en "localhost:http://localhost:4200"
# 9- Probamos las funcionalidades de nuestra app
