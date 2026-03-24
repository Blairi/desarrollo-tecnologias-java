/*
En la clase Intercambia2Variables
Pide dos datos int, guardalos en dos variables diferentes (una y otra).
 */

import java.util.Scanner; // 1

public class Intercambia2Variables {
    public static void main(String[] args) {
        int una;
        int otra;
        Scanner teclado = new Scanner(System.in); // 2
        System.out.print("Valor de una: ");
        una = teclado.nextInt(); // 3
        System.out.print("Valor de otra: ");
        otra = teclado.nextInt(); // 3

        System.out.println("Valores originales:");
        System.out.println("una = " + una);
        System.out.println("otra = " + otra);

        // ?????
        int temp = otra;
        otra = una;
        una = temp;

        System.out.println("Valores finales:");
        System.out.println("una = " + una);
        System.out.println("otra = " + otra);
    }
}
