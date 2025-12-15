package reto006;

/**
 * Clase principal que gestiona el flujo de mensajes.
 */
public class SistemaIris {
    private ArbolAsignaturas directorioAsignaturas;

    public SistemaIris() {
        this.directorioAsignaturas = new ArbolAsignaturas();
    }

    public void registrarAsignatura(String codigo, String nombre) {
        Asignatura nueva = new Asignatura(codigo, nombre);
        directorioAsignaturas.insertar(nueva);
        System.out.println("Sistema: Asignatura registrada -> " + nueva);
    }

    public void inscribirAlumno(String codigoAsignatura, Alumno alumno) {
        Asignatura asig = directorioAsignaturas.buscar(codigoAsignatura);
        if (asig != null) {
            boolean exito = asig.agregarSuscriptor(alumno);
            if (exito) {
                System.out.println("Sistema: Alumno " + alumno.getNombre() + " suscrito a " + codigoAsignatura);
            } else {
                System.out
                        .println("Sistema: Alumno " + alumno.getNombre() + " YA estaba suscrito a " + codigoAsignatura);
            }
        } else {
            System.out.println("Error: Asignatura " + codigoAsignatura + " no encontrada.");
        }
    }

    /**
     * Simula la recepción de un mensaje.
     * 
     * @param asunto    Debe contener el código de la asignatura como primera
     *                  palabra o entre corchetes.
     * @param cuerpo    Contenido del mensaje.
     * @param prioridad Prioridad del mensaje.
     */
    public void recibirMensaje(String asunto, String cuerpo, int prioridad) {
        // Lógica simple de parsing: Extraer código del asunto.
        // Asumimos formato "[CODIGO] Asunto" o "CODIGO Asunto"
        String codigo = extraerCodigo(asunto);

        Asignatura asig = directorioAsignaturas.buscar(codigo);
        if (asig != null) {
            Mensaje msg = new Mensaje(cuerpo, prioridad);
            asig.recibirMensaje(msg);
            System.out.println("Sistema: Mensaje recibido para " + codigo + " (Prioridad: " + prioridad + ")");
        } else {
            System.out.println("Log: Mensaje NO categorizado o asignatura inexistente. Código extraído: " + codigo);
        }
    }

    public void procesarMensajes(String codigoAsignatura) {
        Asignatura asig = directorioAsignaturas.buscar(codigoAsignatura);
        if (asig == null) {
            System.out.println("Error: No se puede procesar, asignatura desconocida.");
            return;
        }

        System.out.println(">>> Procesando cola de " + asig.getNombre() + " <<<");
        ColaMensajes cola = asig.getColaMensajes();

        while (!cola.estaVacia()) {
            Mensaje msg = cola.desencolar();
            String resumenIA = simularResumenIA(msg.getContenido());
            notificarSuscriptores(asig, resumenIA);
        }
        System.out.println(">>> Fin de procesamiento <<<");
    }

    private void notificarSuscriptores(Asignatura asig, String mensajeResumido) {
        ListaAlumnos suscriptores = asig.getListaSuscriptores();
        if (suscriptores.estaVacia()) {
            System.out.println("Info: No hay suscriptores para notificar.");
            return;
        }

        NodoAlumno actual = suscriptores.getCabeza();
        while (actual != null) {
            // Fan-out: Simulación de envío WhatsApp
            enviarWhatsApp(actual.alumno, asig.getCodigo() + ": " + mensajeResumido);
            actual = actual.siguiente;
        }
    }

    private void enviarWhatsApp(Alumno destino, String texto) {
        // Simulación
        System.out.println(
                "   -> Enviando WhatsApp a " + destino.getNombre() + " (" + destino.getEmail() + "): " + texto);
    }

    private String simularResumenIA(String contenidoOriginal) {
        return "[IA Resume]: " + contenidoOriginal; // Mock
    }

    private String extraerCodigo(String asunto) {
        // Intenta sacar palabra entre corchetes [CODIGO]
        if (asunto.startsWith("[")) {
            int fin = asunto.indexOf("]");
            if (fin != -1) {
                return asunto.substring(1, fin);
            }
        }
        // Fallback: primera palabra
        String[] partes = asunto.split(" ");
        if (partes.length > 0)
            return partes[0];
        return "";
    }
}
