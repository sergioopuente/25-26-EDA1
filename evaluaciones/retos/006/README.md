# Reto 006

# pyEdlin

EDLIN es un editor de líneas incluido en MS-DOS y más tarde en los sistemas operativos Microsoft. Proporciona capacidades rudimentarias para editar ficheros de texto plano a través de una interfaz de comandos. Los números de línea son especificados usando números, y las operaciones son especificadas usando un sólo carácter alfabético.

EDLIN era el único editor de textos proporcionado con el MS-DOS antes de la versión 5.0 de ese sistema, cuando fue reemplazado por el editor a pantalla completa edit. Fue eliminado en la versión 6, y está probablemente diseñado a partir de los editores de líneas QED o ed.

Edlin fue creado por Tim Paterson en dos semanas en 1980, y se esperaba que tuviese una vida de seis meses. Edlin realmente fue escrito originalmente para el QDOS de Seattle Computer Products, que más tarde fue comprado por Microsoft convirtiéndose finalmente en el MS-DOS.

## RETO

Implementar una versión de edlin, que permita gestionar ficheros de texto.

### RETOS BASE

1. Defina e implemente una manera de representar la información a almacenar, teniendo en cuenta que gestionará un fichero de texto.
1. Implemente la salida de información en pantalla, mostrando el fichero y las líneas que lo conforman.
1. Agregue a su versión de edlin la capacidad de especificar la línea activa.
1. Agregue a su versión de edlin la capacidad de editar el contenido de la línea activa.
1. Agregue a su versión de edlin la capacidad de eliminar el contenido de una línea.
1. Agregue a su versión de edlin la capacidad de intercambiar el contenido de dos líneas.

### MEJORAS – PARTE 1

- Agregue a su versión de edlin la capacidad de albergar metadatos.
- En base a lo definido arriba, plantee como implementaría la opción de deshacer (CTRL+Z) y rehacer (CTRL+Y).
- Agregue a su edlin la capacidad de guardar versiones del documento, dentro del mismo documento (de modo similar a lo que propone Google Docs).
- Una vez implementada la gesión de versiones, agregue a su edlin la capacidad de permitir la gestión colaborativa, es decir, saber qué usuario editó cada versión del mismo.

