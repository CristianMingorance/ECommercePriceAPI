# :shopping_cart: ECommercePriceAPI

## :page_with_curl: Descripción

ECommerce Price API es una REST API desarrollada con Spring Boot, diseñada para proporcionar información sobre precios de productos en el contexto de comercio electrónico. Implementa prácticas de Domain-Driven Design (DDD) y arquitectura hexagonal para garantizar un código limpio, mantenible y escalable. Utiliza una base de datos H2 en memoria para facilitar el despliegue y la prueba de la aplicación.

## :sparkles: Características

- :money_with_wings: API REST para consultar precios de productos basada en fecha, identificador de producto y cadena.
- :rocket: Uso de Spring Boot para una configuración rápida y sencilla.
- :floppy_disk: Base de datos en memoria H2 para almacenamiento de datos de precios.
- :books: Implementación de DDD y arquitectura hexagonal.
- :white_check_mark: Pruebas integradas utilizando JUnit.

## :hammer_and_wrench: Tecnologías Utilizadas

- :coffee: Java 17
- :leaves: Spring Boot
- :floppy_disk: H2 Database
- :wrench: Lombok
- :gear: MapStruct
- :test_tube: JUnit

## :runner: Cómo Empezar

### :pushpin: Requisitos Previos

- JDK 17
- Gradle 6.x

### :gear: Instrucciones de Instalación

1. Clona el repositorio en tu máquina local:
`git clone https://github.com/**-tu-usuario-**/ECommercePriceAPI.git`


2. Navega al directorio del proyecto clonado:
`cd ECommercePriceAPI`


3. Construye el proyecto y ejecuta las pruebas:
`./gradlew build`


### :arrow_forward: Ejecutando la Aplicación

Para iniciar la aplicación, ejecuta:
`./gradlew bootRun`


La aplicación estará disponible en `http://localhost:8080`.


### :hammer_and_pick: Configuración de la Base de Datos H2

Para acceder a la consola de la base de datos H2:

- **Asegúrate de que la aplicación esté en ejecución.**
- **Navega** a `http://localhost:8080/api/h2-console` en tu navegador.
- **Usa la siguiente URL de conexión JDBC:** `jdbc:h2:mem:testdb`.
- **Ingresa** con el nombre de usuario `sa` y deja el campo de contraseña vacío (a menos que hayas configurado una contraseña específica).
- **Interactúa** con la base de datos directamente desde la consola para ejecutar consultas SQL, ver los datos existentes, o realizar cualquier otra operación de base de datos.

### :mag_right: Explorando la API con Swagger

Una vez que la aplicación esté funcionando, puedes explorar los endpoints disponibles y probar la API utilizando la documentación de Swagger:

- **Navega** a `http://localhost:8080/swagger-ui.html` en tu navegador.
- Aquí encontrarás una **lista interactiva** de todos los endpoints disponibles, sus parámetros y los modelos de datos.

### :rocket: Uso de la API

Para realizar una consulta de precios, usa el endpoint `/api/prices/{brandId}/{productId}/{applicationDate}`, donde:

- `brandId` es el identificador numérico de la cadena.
- `productId` es el identificador numérico del producto.
- `applicationDate` es la fecha y hora de la consulta en formato ISO (p. ej., `2020-06-14T16:00:00`).

Por ejemplo, para consultar el precio de un producto con ID 35455 de la marca 1 en la fecha y hora específica, podrías usar:

```console
curl "http://localhost:8080/api/prices/1/35455/2020-06-14T16:00:00"
```

### ❓ Soporte

Si tienes alguna pregunta o te encuentras con algún problema, no dudes en abrir una issue en el repositorio de GitHub.
### ⭐ Contribuir

Las contribuciones son bienvenidas. 

### ⚖ Licencia

Este proyecto se distribuye bajo la licencia MIT. Consulta el archivo `LICENSE.md` para obtener más información.


