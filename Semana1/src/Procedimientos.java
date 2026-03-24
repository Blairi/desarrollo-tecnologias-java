public class Procedimientos {
    // Estrictamente hablando los procedimientos son metodos
    // Los procedimientos no regresan valor (son de tipo void)

    // Definicion o declaracion del procedimiento
    public static void saluda() {
        System.out.println("Hola");
        int numero = 10;
        numero += 5;
    }

    public static void bienvenida(String nombre) {
        System.out.println("Bienvenida/o " + nombre);
    }

    public static void despedida(int veces, String nombre) {
        for (int n = 1; n <= veces; n++) {
            System.out.println("Adios " + nombre);
        }
    }

    public static void main(String[] args) {
        System.out.println("*** Procedimientos ***");
        // Uso/llamado/ejecucion de un procedimiento
        saluda();
        for (int i = 0; i < 5; i++) {
            saluda();
        }
        bienvenida("Hugo");
        bienvenida("Paco");

        despedida(5, "Ari");
    }
}
