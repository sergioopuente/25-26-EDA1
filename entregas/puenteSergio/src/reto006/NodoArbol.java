package reto006;

public class NodoArbol {
    public Asignatura asignatura;
    public NodoArbol izquierdo;
    public NodoArbol derecho;

    public NodoArbol(Asignatura asignatura) {
        this.asignatura = asignatura;
        this.izquierdo = null;
        this.derecho = null;
    }
}
