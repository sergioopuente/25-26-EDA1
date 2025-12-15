package reto006;

/**
 * Árbol Binario de Búsqueda para indexar asignaturas por código.
 * Permite inserción y búsqueda en O(log N) promedio.
 */
public class ArbolAsignaturas {
    private NodoArbol raiz;

    public ArbolAsignaturas() {
        this.raiz = null;
    }

    public void insertar(Asignatura asignatura) {
        raiz = insertarRec(raiz, asignatura);
    }

    private NodoArbol insertarRec(NodoArbol nodo, Asignatura asignatura) {
        if (nodo == null) {
            return new NodoArbol(asignatura);
        }

        // Ordenar alfabéticamente por código
        int comparacion = asignatura.getCodigo().compareTo(nodo.asignatura.getCodigo());

        if (comparacion < 0) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, asignatura);
        } else if (comparacion > 0) {
            nodo.derecho = insertarRec(nodo.derecho, asignatura);
        }
        // Si es igual, no duplicamos (o actualizamos si fuera necesario)
        return nodo;
    }

    public Asignatura buscar(String codigo) {
        return buscarRec(raiz, codigo);
    }

    private Asignatura buscarRec(NodoArbol nodo, String codigo) {
        if (nodo == null) {
            return null;
        }

        int comparacion = codigo.compareTo(nodo.asignatura.getCodigo());

        if (comparacion == 0) {
            return nodo.asignatura;
        } else if (comparacion < 0) {
            return buscarRec(nodo.izquierdo, codigo);
        } else {
            return buscarRec(nodo.derecho, codigo);
        }
    }
}
