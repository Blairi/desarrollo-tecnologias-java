import java.util.Scanner;

// Dado un numero n, imprimir su tabla de multiplicar
public class Tabla {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n;
        System.out.print("Ingresa el numero n para mostrar su tabla: ");
        n = teclado.nextInt();
        System.out.println("Imprimiendo tabla del " + n);
        int i = 1;
        while (i <= 10) {
            System.out.println("" + n + " * " + i + " = " + n * i);
            i++;
        }


    }
}
