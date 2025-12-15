# Reto 006: Planificación y Diseño del Sistema Iris

## 1. Introducción
Este documento detalla las decisiones de diseño y la planificación estructural para el sistema **Iris**. El objetivo principal es construir un redirector de mensajes eficiente, capaz de manejar picos de tráfico y garantizar la entrega ordenada de información prioritaria.

## 2. Arquitectura de Estructuras de Datos
Para cumplir con los requisitos exigenes de rendimiento, hemos evitado el uso de colecciones genéricas estándar en los puntos críticos, optando por estructuras de datos especializadas. La arquitectura se basa en tres pilares:

### A. Indexación de Asignaturas (Búsqueda Rápida)
*   **Estructura**: Árbol Binario de Búsqueda (BST).
*   **Decisión**: Necesitamos buscar una asignatura por su código (String) cada vez que llega un mensaje.
*   **Justificación**: 
    *   Un BST permite búsquedas en tiempo logarítmico **O(log N)** promedio.
    *   Mantiene el catálogo ordenado alfabéticamente de forma natural, útil para listados administrativos.
    *   Es superior a una lista simple O(N) y más flexible en memoria que una Tabla Hash estática para este contexto educativo.

### B. Gestión de Mensajes (Priorización)
*   **Estructura**: Cola de Prioridad (Max-Heap).
*   **Decisión**: Los mensajes tienen niveles de urgencia (Urgente > Importante > Informativo). No deben procesarse en estricto orden de llegada (FIFO), sino por importancia.
*   **Justificación**:
    *   Un Heap garantiza que el mensaje de mayor prioridad esté siempre disponible en la raíz en **O(1)**.
    *   La inserción y extracción cuestan **O(log M)**, lo cual es muy eficiente incluso con colas grandes.
    *   Actúa como un **buffer**, desacoplando la recepción (rápida) del procesamiento (lento, llamada a IA), protegiendo el sistema de saturación.

### C. Suscripción de Alumnos (Difusión)
*   **Estructura**: Lista Enlazada Simple (con comportamiento de Conjunto/Set).
*   **Decisión**: Un mensaje procesado debe enviarse a todos los alumnos suscritos.
*   **Justificación**:
    *   **Envío (Fan-out)**: Para enviar notificaciones, debemos recorrer *toda* la lista secuencialmente. La lista enlazada es óptima para recorridos completos O(K).
    *   **Unicidad**: Se implementa una validación lógica al insertar para evitar duplicados (Set), asegurando que un alumno no reciba el mismo mensaje dos veces.
    *   **Flexibilidad**: Facilita la eliminación de alumnos (bajas) re-enlazando punteros sin necesidad de mover bloques de memoria contigua como en un Array.

## 3. Análisis de Complejidad (Big O)
El diseño garantiza la escalabilidad del sistema:

| Operación | Estructura | Complejidad Temporal |
| :--- | :--- | :--- |
| **Buscar Asignatura** | BST | **O(log N)** |
| **Encolar Mensaje** | Heap (Priority Queue) | **O(log M)** |
| **Obtener Mensaje Urgente** | Heap | **O(1)** (acceso) / O(log M) (extracción) |
| **Suscribir Alumno** | Lista (con chequeo) | **O(K)** (verificar duplicado) |
| **Notificar (Fan-out)** | Lista | **O(K)** (siendo K = num suscriptores) |

> *N = Total Asignaturas, M = Mensajes en cola, K = Suscriptores por asignatura.*

## 4. Diagramas de Referencia
El diseño visual se encuentra detallado en la carpeta `uml/` (o `documentosUML/` según configuración):
*   **Diagrama de Clases**: Muestra la composición de `SistemaIris` con `ArbolAsignaturas`, `ColaMensajes` y `ListaAlumnos`.
*   **Diagrama de Flujo**: Ilustra el viaje del dato desde la entrada, pasando por el filtrado del Árbol, la espera en la Cola, hasta la difusión por la Lista.

## 5. Compromisos Asumidos
*   **Latencia Intencional**: Aceptamos que los mensajes de baja prioridad esperen en la cola si hay urgencias, para garantizar la calidad del servicio (QoS).
*   **Consumo de Memoria**: El uso de nodos enlazados (en el BST y Listas) implica un *overhead* de memoria por los punteros, el cual es despreciable dada la capacidad de hardware actual frente al volumen de datos esperado (< 1000 asignaturas).
