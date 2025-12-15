package reto006;

public class Mensaje implements Comparable<Mensaje> {
    private String contenido;
    private int prioridad; // Mayor número = Mayor prioridad
    private long timestamp;

    public Mensaje(String contenido, int prioridad) {
        this.contenido = contenido;
        this.prioridad = prioridad;
        this.timestamp = System.nanoTime(); // Para desempate FIFO en misma prioridad
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getContenido() {
        return contenido;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(Mensaje otro) {
        // Orden descendente de prioridad
        if (this.prioridad != otro.prioridad) {
            return Integer.compare(otro.prioridad, this.prioridad);
        }
        // Desempate por orden de llegada (FIFO) -> menor timestamp va antes
        return Long.compare(this.timestamp, otro.timestamp);
    } // Nota: Para MaxHeap, queremos que el "menor" sea el de mayor prioridad si usamos MinHeap logic, 
      // pero si implementamos MaxHeap custom, la lógica de comparación depende de la estructura.
      // Estandar: compareTo devuelve > 0 si this > otro.
      // Aquí: Mayor prioridad es "mayor" objeto.
      // El desempate de tiempo: "antes" en el tiempo suele ser "mayor" preferencia.
      // Ajuste: Si this.prio > otro.prio => return 1.
      
    // Re-evaluating standard compareTo for Priority Queue:
    // Usually Java PQ is MinHeap.
    // My custom PQ implementation:
    // If I build a MaxHeap, root is Max.
    // logic: this > other if this.prio > other.prio.
    
    @Override
    public String toString() {
         return "[" + prioridad + "] " + contenido;
    }
}
