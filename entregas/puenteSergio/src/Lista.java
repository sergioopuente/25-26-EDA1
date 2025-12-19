package ExamenParcial;

public class Lista {


    private class Nodo {
        private int dato;
        private Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
   
        public int getDato() { return dato; }
        public void setDato(int dato) { this.dato = dato; }
        public Nodo getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    }


    private Nodo cabeza;
    private int tamaño;

    public Lista() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void agregar(int valor) {
        Nodo nuevo = new Nodo(valor);
        insertarAlFinal(nuevo);
        tamaño++;
    }

    private void insertarAlFinal(Nodo nuevo) {
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            buscarUltimo().setSiguiente(nuevo);
        }
    }

    private Nodo buscarUltimo() {
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public int obtener(int indice) {
        validarRango(indice);
        return buscarNodo(indice).getDato();
    }

    public void modificar(int indice, int valor) {
        validarRango(indice);
        buscarNodo(indice).setDato(valor);
    }

    private Nodo buscarNodo(int indice) {
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    private void validarRango(int indice) {
        assert indice >= 0 && indice < tamaño : "Índice de lista fuera de rango";
    }
}
    }
}

