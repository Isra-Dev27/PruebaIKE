# Implementación de Servicios con Spring Boot y Maven

## Requisitos

Para probar los servicios de manera local, es necesario tener instalado **JDK-21**.

## Primer Servicio: Búsqueda de Personas

### Acceso al Servicio

Se puede acceder al primer servicio de manera local a través de la siguiente URL:

http://localhost:8080/api/PersonFind?


### Nombres Predefinidos

Para este servicio, los nombres están definidos dentro del código. Para probarlo, se deben utilizar algunos de los siguientes nombres:

![Nombres Predefinidos](https://github.com/Isra-Dev27/PruebaIKE/assets/146276498/46c66574-8e3f-4e71-83cf-b263309383db)

### Evidencia del Correcto Funcionamiento

#### Código 302 - FOUND

![Código 302 - FOUND](https://github.com/Isra-Dev27/PruebaIKE/assets/146276498/eb9e1aa5-bed8-4fad-ade6-0f9472a2bf08)

#### Código 404 - NOT FOUND

![Código 404 - NOT FOUND](https://github.com/Isra-Dev27/PruebaIKE/assets/146276498/0be090af-580a-454d-82b8-e4a9a8a29693)

## Segundo Servicio: Búsqueda de Personas en MySQL

### Acceso al Servicio

Para este servicio, se requiere la creación de una base de datos MySQL llamada `bd-pruebaike`. Una vez creada, se debe ejecutar el script SQL disponible en el repositorio. Se puede acceder al servicio de manera local a través de la siguiente URL:

http://localhost:8080/api/PersonFindBD?


### Evidencia de la Base de Datos

![Evidencia de la Base de Datos](https://github.com/Isra-Dev27/PruebaIKE/assets/146276498/ff52501d-9760-4281-a294-5c83aaa27e03)

### Evidencia del Correcto Funcionamiento del Servicio

#### Código 302 - FOUND

![Código 302 - FOUND](https://github.com/Isra-Dev27/PruebaIKE/assets/146276498/c45b888f-fa3f-40a8-9b30-ac6632738e38)

#### Código 404 - NOT FOUND

![Código 404 - NOT FOUND](https://github.com/Isra-Dev27/PruebaIKE/assets/146276498/7489a17f-12bc-4e31-9782-8713114b378f)

## Tercer Servicio: Comprobación de Palíndromos

### Acceso al Servicio

Para acceder a este servicio, se debe utilizar **Postman** o **CURL** (en Linux) para realizar una solicitud POST a la siguiente URL:

http://localhost:8080/api/palindromeChecker?

### Evidencia del Funcionamiento del Servicio

Se adjunta evidencia del correcto funcionamiento del servicio:

![image](https://github.com/Isra-Dev27/PruebaIKE/assets/146276498/af373eed-616e-43cf-a725-97ea00381d00)




