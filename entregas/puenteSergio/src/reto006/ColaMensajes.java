package reto006;

/**
 * Cola de Prioridad para mensajes, implementada sobre un Montículo Binario
 * (Max-Heap).
 * Garantiza O(log N) en inserción y extracción.
 */
public class ColaMensajes {
    private Mensaje[] heap;
    private int size;
    private static final int CAPACIDAD_INICIAL = 20;

    public ColaMensajes() {
        this.heap = new Mensaje[CAPACIDAD_INICIAL];
        this.size = 0;
    }

    public void encolar(Mensaje mensaje) {
        if (size == heap.length) {
            redimensionar();
        }
        heap[size] = mensaje;
        flotar(size);
        size++;
    }

    public Mensaje desencolar() {
        if (estaVacia())
            return null;

        Mensaje root = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null; // Help GC
        size--;
        if (size > 0) {
            hundir(0);
        }
        return root;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    private void flotar(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (mayorQue(heap[index], heap[parentIndex])) {
                intercambiar(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void hundir(int index) {
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < size && mayorQue(heap[leftChild], heap[largest])) {
                largest = leftChild;
            }

            if (rightChild < size && mayorQue(heap[rightChild], heap[largest])) {
                largest = rightChild;
            }

            if (largest != index) {
                intercambiar(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    // Helper para comparar usando la lógica de Mensaje (compareTo)
    // Mensaje.compareTo: Descendente por prioridad.
    // Si m1.compareTo(m2) < 0 significa m1 va ANTES que m2 en ordenación (es
    // "mejor").
    // Pero ojo: mi implementación de Mensaje.compareTo dice: "si this.prio >
    // otro.prio => return -1" (para Arrays.sort descendente usualmente).
    // REVISAR Mensaje.compareTo implementado:
    // if (this.prioridad != otro.prioridad) return Integer.compare(otro.prioridad,
    // this.prioridad);
    // return Long.compare(this.timestamp, otro.timestamp);
    //
    // Integer.compare(y, x) devuelve < 0 si y < x (o sea this > otro).
    // Si this.prioridad (10) > otro.prioridad (5) -> compare(5, 10) -> -1.
    // Significa que "this" es "menor" (debería ir antes en la lista ordenada).
    //
    // EN UN MAX-HEAP: El nodo PADRE debe ser MAYOR (en concepto de valor) que los
    // hijos.
    // SI uso la lógica de Prioridad como "Valor": Mayor Prioridad = Mayor Valor.
    // Entonces quiero que el root sea el de Mayor Prioridad.
    //
    // Si m1.prioridad > m2.prioridad => m1 es "mayor".
    private boolean mayorQue(Mensaje m1, Mensaje m2) {
        if (m1.getPrioridad() != m2.getPrioridad()) {
            return m1.getPrioridad() > m2.getPrioridad();
        }
        // Desempate: Menor timestamp tiene "más prioridad" (llegó antes).
        // Si m1 llegó antes que m2 (m1.ts < m2.ts), m1 debería ser tratado como "mayor"
        // prioridad en la cola.
        return m1.getTimestamp() < m2.getTimestamp();
    }

    private void intercambiar(int i, int j) {
        Mensaje temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void redimensionar() {
        Mensaje[] nuevo = new Mensaje[heap.length * 2];
        System.arraycopy(heap, 0, nuevo, 0, heap.length);
        heap = nuevo;
    }
}
