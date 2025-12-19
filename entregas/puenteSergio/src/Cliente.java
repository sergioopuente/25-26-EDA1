package ExamenParcial;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("=== Pruebas de Refactorización Array/Lista ===");

        try {
            System.out.println("\n1. Creando Array<Integer> de capacidad 4...");
            Array<Integer> arrayEnteros = new Array<>(4);

            arrayEnteros.set(0, 10);
            arrayEnteros.set(1, 20);
            arrayEnteros.set(2, 30);
            arrayEnteros.set(3, 40);

            mostrarArray(arrayEnteros, "Array Inicial");

            System.out.println("-> Modificando posición 1 a 99...");
            arrayEnteros.set(1, 99);
            mostrarArray(arrayEnteros, "Array Modificado");

        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }

        try {
            System.out.println("\n2. Probando acceso fuera de límites...");
            Array<String> arrayStrings = new Array<>(2);
            arrayStrings.set(5, "Error");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }

        try {
            System.out.println("\n3. Creando Array<String>...");
            Array<String> nombres = new Array<>(3);
            nombres.set(0, "Ana");
            nombres.set(1, "Bob");
            mostrarArray(nombres, "Array de Nombres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static <T> void mostrarArray(Array<T> array, String titulo) {
        System.out.println("[" + titulo + "]: ");
        for (int i = 0; i < array.longitud(); i++) {
            System.out.print(array.get(i) + (i < array.longitud() - 1 ? ", " : ""));
        }
        System.out.println();
    }
}
