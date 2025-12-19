# Reto 007: Refactorización del Examen Parcial

Este directorio contiene la solución al Refactorización del código del examen parcial de EDA1.

## Objetivos
Refactorizar la implementación de `Array`, `Lista`, y `Nodo` para cumplir con principios de código limpio y robusto, manteniendo la restricción de que `Array` debe basarse en `Lista`.

## Cambios Implementados

### 1. Genéricos (`<T>`)
Se han introducido tipos genéricos en todas las clases (`Array<T>`, `Lista<T>`, `Nodo<T>`) para permitir reutilizar las estructuras de datos con cualquier tipo de objeto (no solo `int`).

### 2. Manejo de Excepciones
- Se reemplazaron los `assert` por excepciones estándar (`IndexOutOfBoundsException`, `IllegalArgumentException`).
- Esto mejora la robustez.

### 3. Código Limpio en `src/ExamenParcial`
- El código final se encuentra en el paquete `ExamenParcial`.
- Se han eliminado comentarios innecesarios.

## Ejecución
```bash
javac -d bin src/ExamenParcial/*.java
java -cp bin ExamenParcial.Cliente
```

