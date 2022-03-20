# CHALLENGE - CONCURSO DE PREGUNTAS Y RESPUESTAS

El reto fue desarrolloado en el entorno de desarrollo IntelliJ IDEA, Spring Boot, MAVEN y la
base de datos H2.

Se tiene el siguiente diagrama de clases con sus respectivos metodos y atributos.

![Diagrama de clases] (https://github.com/blopezp9/Concurso_Preguntas_Respuestas/blob/master/imagen/ErrorMensaje.png)


## Pasos para ejecutar el proyecto
1: Cargar el proyecto en IntelliJ IDEA y posteriormente correr el proyecto.
##
2: Correr en la terminal de IntelliJ IDEA el siguiente comando

```bash
   curl --request POST localhost:8080/jugador
```
 ##
3: Una vez ejecutado el comando anterior, verá un menú de opciones de esta manera "Ingrese 1 para crear jugador y crear juego. Ingrese 2 para crear juego si ya tiene un usuario registrado. Ingrese 3 para jugar". 
##
4: Si ingresa a la opción 1 para crear un usuario y juego nuevo, deberá volver a la terminal de IntelliJ y ejecutar el mismo comando para ver el menú de opciones.
```bash
   curl --request POST localhost:8080/jugador
```
5: El link de la base de datos y las credenciales de la misma son los siguientes:
```bash
   http://localhost:8080/h2-console/

   user: h2
   password: h2
```
## Funcionalidades
● Configurar Juego: Crear las preguntas y respuestas (con 3 opciones erradas y 1
valida) con sus categorías correspondientes (mínimo 25 preguntas).
##
● Iniciar el juego: se debe iniciar el juego con la primera ronda y de forma aleatoria debe
seleccionar una pregunta según la categoría más baja.
##
● Responder a la pregunta: debes seleccionar una opción de 4 posibles.
##
● Aumentar de nivel: al responder de forma correcta deberás aumentar de nivel y de esa
manera otorgar premios según la ronda que este. Ordena primero tus categorías y de
esa manera sabrás en qué ronda estás ubicado.
##
● Acomular premio: cada vez que ganes debes tener un premio total que tienes como
jugador.
##
● Fin del juego voluntario o ganara ronda final: se finaliza el juego porque el jugador
deci y el acomulado pasa a l jugador (guarda los datos del jugador)
##
● Fin del juego forzado: el sistema finaliza el juego porque no selecciono una pregunta
correcta. (guarda los datos del jugador)
##
● Persistencia de datos: al finalizar el juego se debe guardar los datos del jugador como
histórico del juego.  
## Datos del desarrollador

**Nombre:** Bryan López Parra

**Correo:** blopezp0920@gmail.com
