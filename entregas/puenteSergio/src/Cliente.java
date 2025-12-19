

public class Cliente {
    
    
    private static final int CAPACIDAD_INICIAL = 4;
    private static final int VALOR_A = 10;
    private static final int VALOR_B = 20;
    private static final int VALOR_C = 30;
    private static final int VALOR_D = 40;
    private static final int VALOR_MODIFICADO = 99;
    private static final int INDICE_MODIFICAR = 1;

    public static void main(String[] args) {
        ejecutarPrueba();
    }

    private static void ejecutarPrueba() {
        Array array = new Array(CAPACIDAD_INICIAL);

        inicializarDatos(array);
        mostrarEstado(array, "Contenido del array simulado:");

        modificarDato(array);
        mostrarEstado(array, "\n\nCambiamos la posición " + INDICE_MODIFICAR + " a " + VALOR_MODIFICADO + ":");
    }

    private static void inicializarDatos(Array array) {
        array.set(0, VALOR_A);
        array.set(1, VALOR_B);
        array.set(2, VALOR_C);
        array.set(3, VALOR_D);
    }

    private static void modificarDato(Array array) {
        array.set(INDICE_MODIFICAR, VALOR_MODIFICADO);
    }

    private static void mostrarEstado(Array array, String mensaje) {
        System.out.println(mensaje);
        for (int i = 0; i < array.longitud(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}
}


