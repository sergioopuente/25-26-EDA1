package reto006;

public class Asignatura {
    private String codigo;
    private String nombre;
    private ColaMensajes colaMensajes;
    private ListaAlumnos listaSuscriptores;

    public Asignatura(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.colaMensajes = new ColaMensajes();
        this.listaSuscriptores = new ListaAlumnos();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ColaMensajes getColaMensajes() {
        return colaMensajes;
    }

    public ListaAlumnos getListaSuscriptores() {
        return listaSuscriptores;
    }

    /**
     * Agrega un mensaje a la cola de prioridad de la asignatura.
     * 
     * @param mensaje
     */
    public void recibirMensaje(Mensaje mensaje) {
        colaMensajes.encolar(mensaje);
    }

    /**
     * Suscribe un alumno a la asignatura.
     * 
     * @param alumno
     * @return true si éxito, false si ya estaba.
     */
    public boolean agregarSuscriptor(Alumno alumno) {
        return listaSuscriptores.insertar(alumno);
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
