import java.util.Scanner;

public class Ciclos {
    public static void main(String[] args) {
        System.out.println("*** Ciclos ***");

        System.out.println("*** while ***");
        int vueltas = 1;
        while (vueltas < 10) {
            System.out.println("Voy en la vuelta " + vueltas++);
        }

        // cuando no conozco el numero de vueltas, pero se cuando parar
        int numero = -99;
        Scanner teclado = new Scanner(System.in);
        // la persona debe "adivinar" el numero secreto (que sera el 7)
        while (numero != 7) {
            System.out.println("En que numero del 1 al 10 estoy pensando? ");
            numero = teclado.nextInt();
        }

        System.out.println("** do-while **");
        // Adivinar el numero 70
        numero = 70;
        do {
            System.out.println("Dime un numero del 1 al 100 y te dire si es el que tengo en mente");
            numero = teclado.nextInt();
        } while (numero != 70);


        System.out.println ("Ciclos for");
        numero = 7; // Para desplegar la table de multiplicar del 7
        for (int i=1;i<=10;i++) {
            System.out.println(i + "x" + numero + "= " + (i * numero));
        }
    }
}
