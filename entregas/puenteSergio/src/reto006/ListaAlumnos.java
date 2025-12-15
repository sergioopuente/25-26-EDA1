package reto006;

/**
 * Lista enlazada simple para gestionar suscriptores.
 * Comportamiento de Conjunto (Set): No permite duplicados.
 */
public class ListaAlumnos {
    private NodoAlumno cabeza;
    private int tamano;

    public ListaAlumnos() {
        this.cabeza = null;
        this.tamano = 0;
    }

    /**
     * Inserta un alumno si no existe ya en la lista.
     * 
     * @param alumno Alumno a insertar
     * @return true si se insertó, false si ya existía.
     */
    public boolean insertar(Alumno alumno) {
        if (contiene(alumno.getId())) {
            return false;
        }
        NodoAlumno nuevo = new NodoAlumno(alumno);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoAlumno actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamano++;
        return true;
    }

    /**
     * Elimina un alumno por su ID.
     * 
     * @param idAlumno ID del alumno
     * @return true si se eliminó, false si no se encontró.
     */
    public boolean eliminar(String idAlumno) {
        if (cabeza == null)
            return false;

        if (cabeza.alumno.getId().equals(idAlumno)) {
            cabeza = cabeza.siguiente;
            tamano--;
            return true;
        }

        NodoAlumno actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.alumno.getId().equals(idAlumno)) {
                actual.siguiente = actual.siguiente.siguiente;
                tamano--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean contiene(String idAlumno) {
        NodoAlumno actual = cabeza;
        while (actual != null) {
            if (actual.alumno.getId().equals(idAlumno)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamano() {
        return tamano;
    }

    public NodoAlumno getCabeza() {
        return cabeza;
    }

    public void imprimir() {
        NodoAlumno actual = cabeza;
        System.out.print("[ ");
        while (actual != null) {
            System.out.print(actual.alumno.getNombre() + " ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }
}
