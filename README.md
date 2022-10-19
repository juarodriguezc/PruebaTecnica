# Prueba Tecnica
## Juan Sebastián Rodríguez Castellanos
### _Universidad Nacional de Colombia_


API REST desarrollada en Spring Boot, la cual consume el API:  https://rickandmortyapi.com/documentation/

## Requisitos

- Java 17
- Maven
- MySQL (Para ejecución en local)

## Instalación

Para la instalación de la API es necesario:

- Clonar el repositorio
```sh
git clone https://github.com/juarodriguezc/PruebaTecnica.git
```
- Cambiar al directorio clonado
```sh
cd PruebaTecnica
```

## Ejecución

En el directorio raíz del proyecto ejecutar el siguiente comando:
```sh
mvn spring-boot:run
```

Para usar una base de datos local es necesario cambiar los parámetros del _application.properties_.
## Pruebas
El API se puede probar tanto de manera local como en la nube, ya que esta se encuentra desplegada usando *Heroku*,
la dirección de la aplicación es: https://ricky-martin-app.herokuapp.com/

Los distintos endpoints son:


### Obtener episodio de la API externa:
#### GET /episode/{id}

```sh
https://ricky-martin-app.herokuapp.com/episode/{id}
```

### Mostrar todos los episodios almacenados en la BD:
#### GET /episode

```sh
https://ricky-martin-app.herokuapp.com/episode
```

### Eliminar todos los episodios almacenados en la BD:
#### DELETE /episode

```sh
https://ricky-martin-app.herokuapp.com/episode
```

### Calcular si los números ingresados son happy numbers:
#### GET /happynumber?numbers={n1,n2,...}

```sh
https://ricky-martin-app.herokuapp.com/happynumber?numbers=n1,n2,...
```

### Calcular la sumatoria hasta N:
#### GET /summation?number={num}

```sh
https://ricky-martin-app.herokuapp.com/summation?number={num}
```


