package ExamenParcial;

public class Array<T> {
    private Lista<T> miLista;
    private final int capacidad;

    public Array(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }

        this.capacidad = capacidad;
        this.miLista = new Lista<>();

        for (int i = 0; i < capacidad; i++) {
            miLista.agregar(null);
        }
    }

    public T get(int indice) {
        validarIndice(indice);
        return miLista.obtener(indice);
    }

    public void set(int indice, T valor) {
        validarIndice(indice);
        miLista.modificar(indice, valor);
    }

    public int longitud() {
        return capacidad;
    }

    private void validarIndice(int indice) {
        if (indice < 0 || indice >= capacidad) {
            throw new IndexOutOfBoundsException("Índice " + indice + " fuera de límites para longitud " + capacidad);
        }
    }
}
