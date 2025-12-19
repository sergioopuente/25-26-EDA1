# Explicación de la Refactorización

## Contexto
El código original presentaba una implementación de la clase `Array` que, paradójicamente, utilizaba una Lista Enlazada (`Lista`) y Nodos (`Nodo`) para gestionar sus elementos. Esta estructura es ineficiente y contraintuitiva para simular un array, ya que transforma operaciones de acceso directo $O(1)$ en operaciones lineales $O(N)$.

## Problemas Identificados
1.  **Ineficiencia Temporal**:
    *   `get(indice)`: Recorría la lista desde el inicio hasta el índice, coste $O(N)$.
    *   `set(indice, valor)`: Igualmente, coste $O(N)$.
    *   **Total**: Muy lento para accesos aleatorios.
2.  **Complejidad Estructural**:
    *   Necesidad de mantener 3 clases (`Array`, `Lista`, `Nodo`) para algo que el lenguaje soporta nativamente.
    *   Gestión de punteros y memoria innecesaria.
3.  **Violación de Principios**:
    *   **KISS (Keep It Simple, Stupid)**: La solución era innecesariamente compleja.
    *   **YAGNI (You Ain't Gonna Need It)**: La flexibilidad de una lista enlazada (inserciones dinámicas) no era requerida por la especificación de `Array`.

## Solución Aplicada
Se refactorizó la clase `Array` para utilizar un array primitivo `int[]` como estructura subyacente.

### Detalles Técnicos
*   **Atributo**: Se cambió `private Lista miLista` por `private int[] datos`.
*   **Constructor**: Se inicializa `datos = new int[capacidad]`. Complejidad $O(1)$ (asignación de memoria).
*   **Acceso (get/set)**: Acceso directo al índice del array. Complejidad $O(1)$.
*   **Eliminación de Código Muerto**: Se eliminaron las clases `Lista.java` y `Nodo.java` al no ser ya necesarias.

## Beneficios
*   **Rendimiento**: Mejora drástica en la velocidad de acceso y modificación.
*   **Legibilidad**: El código es más corto, claro y fácil de entender.
*   **Mantenibilidad**: Menos clases que mantener y probar.
