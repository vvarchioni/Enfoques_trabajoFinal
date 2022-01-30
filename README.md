# Enfoques_trabajoFinal
Trabajo final de la materia Enfoques; IDE: AndroidStudio


Requerimientos
Para la realización del trabajo se deberá utilizar la API pública SuperHero API
(https://superheroapi.com/). La misma proveé información estructurada de múltiples
superhéroes y villanos de diferentes universos. Dicha información puede ser
consultada a partir del nombre o ID del personaje.
Los requerimientos del aplicativo a desarrollar son los siguientes:
1) Debe permitir buscar un personaje por su nombre o ID, interactuando con la
API.
2) Debe poder mostrar un detalle del personaje buscado. Si la búsqueda da más
de un resultado para un mismo superhéroe (Ej. Batman/Spider-Man) se
deberán mostrar en un listado. El detalle debe contener: Nombre personaje,
nombre real, lugar de nacimiento, editorial, una imagen, poderes, datos de
apariencia y ocupación.
3) Se debe poder marcar un personaje como favorito y acceder al detalle del
mismo a partir de un listado. Esta marca no se debe perder en caso que el
usuario cierre la aplicación.
4) Al marcar un personaje como favorito, la información del mismo debe
almacenarse de manera local utilizando SQLite o Couchbase Lite.
5) Se debe poder deseleccionar un personaje del listado de favoritos.
6) Debe permitir compartir la información de un personaje en redes sociales.
