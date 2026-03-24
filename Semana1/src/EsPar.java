import java.util.Scanner;

public class EsPar {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int valor;
        System.out.print("Ingresa el valor: ");
        valor = teclado.nextInt();
        System.out.println("El valor es par? : " + (valor % 2 == 0 ? "Si" : "No"));
    }
}
