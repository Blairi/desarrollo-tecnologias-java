import java.util.Scanner; // 1

public class EntradaDeDatos {
    public static void main(String[] args) {
        System.out.println("*** Entrada de datos ***");
        Scanner teclado = new Scanner(System.in); // 2

        // variables para almacenar los datos de una pelicula
        String nombre;
        int estreno;
        double presupuesto;

        System.out.println("Dame los siguientes datos de la pelicula:");

        System.out.print("\tNombre: ");
        nombre = teclado.nextLine(); // captura string y lo regresa

        System.out.print("\tAnio de estreno: ");
        estreno = teclado.nextInt();

        System.out.print("\tPresupuesto (en millones de dolares): ");
        presupuesto = teclado.nextDouble();

        System.out.println(nombre + " se estreno/estrenara en el " + estreno);
        System.out.println(" con presupuesto de $" + presupuesto + "millones");

        teclado.close();
    }
}
