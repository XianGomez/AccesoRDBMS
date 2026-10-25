# Ejercicio 1: Preguntas sobre el repositorio de estudiantes

## 1. ¿Qué clase utiliza `config.properties` y para qué? ¿Por qué `getProperty` recibe dos valores?

La clase `Config` carga la configuración. `getProperty` recibe la clave que busca y un valor por defecto, por si no encuentra esa clave.

## 2. ¿Qué clase utiliza `Connection`, `Statement` y `ResultSet` y para qué?

`DatabaseService` los utiliza para conectarse a la base de datos, ejecutar consultas y leer sus resultados.

## 3. ¿Qué estructura de datos utiliza `EstudiantesRepositoryImpl`?

Usa listas de estudiantes y, para recibir resultados de la base de datos, una lista de mapas donde cada mapa representa una fila.

## 4. ¿Dónde añadiríamos un nuevo método para buscar estudiantes?

Lo declararía en `EstudiantesRepository` y escribiría su implementación SQL en `EstudiantesRepositoryImpl`.

## 5. ¿Cómo se gestionan los IDs? ¿Cómo se adaptaría el código a UUID?

Ahora los genera la base de datos con `AUTO_INCREMENT`. Para usar UUID, cambiaría el tipo del ID en el modelo y la tabla, generaría cada UUID en el código y lo incluiría al insertar el estudiante.