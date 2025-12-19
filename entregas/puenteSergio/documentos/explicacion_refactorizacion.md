# Explicación de la Refactorización - Reto 007

## Resumen
Se ha refactorizado el código del examen parcial (`Array`, `Lista`, `Nodo`) para cumplir con los principios de desarrollo de software moderno, enfocándose en la **Genericidad**, **Robustez** y **Encapsulamiento**.

## Cambios Realizados

### 1. Implementación de Genéricos (`<T>`)
**Antes:**
El código solo funcionaba con `int`. Esto limitaba la reutilización de las estructuras de datos.

**Después:**
Se han convertido `Nodo`, `Lista` y `Array` en clases genéricas (`Nodo<T>`, `Lista<T>`, `Array<T>`).
-   Ahora es posible crear arrays de `String`, `Integer`, `Double`, o cualquier objeto.
-   Ejemplo: `new Array<String>(5)`.

### 2. Manejo de Excepciones
**Antes:**
Se utilizaban `assert` para validar índices. Las aserciones pueden ser deshabilitadas en tiempo de ejecución (`-ea`) y no son la forma estándar de manejar errores de lógica de negocio o validación de entradas en producción.

**Después:**
Se ha implementado el lanzamiento explícito de `IndexOutOfBoundsException` y `IllegalArgumentException`.
-   Esto permite al cliente capturar y manejar los errores (`try-catch`).
-   Mejora la seguridad y estabilidad de la aplicación.
-   Mensajes de error descriptivos.

### 3. Encapsulamiento y Validaciones
**Antes:**
Validaciones dispersas y dependientes de asserts.

**Después:**
-   Se creó un método privado `validarIndice(int)` en `Lista` y `Array` para centralizar la lógica de validación (DRY - Don't Repeat Yourself).
-   Se asegura que la `capacidad` en `Array` sea positiva en el constructor.

### 4. Limpieza de Código (Clean Code)
-   Nombres de variables y métodos más claros y consistentes.
-   Javadoc añadido para documentación de métodos públicos.
-   Inicialización explícita con `null` en el constructor de `Array` para claridad, aunque Java lo hace por defecto, aquí se explicita la intención de "rellenar" la lista subyacente.

## Diagrama UML

Se adjunta el archivo `documento.puml` con el diagrama de clases refactorizado, mostrando las relaciones y la nueva estructura genérica.
