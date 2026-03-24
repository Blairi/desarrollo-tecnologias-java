import java.util.Scanner;

public class Operadores {
    public static void main(String[] args) {
        System.out.println("*** Operadores ***");
        System.out.println("++");

        int numero = 10;
        System.out.println(numero); // 10
        System.out.println(numero += 3); // 13
        System.out.println(numero++); // 13, pero al final vale 14
        System.out.println(numero); // 14

        System.out.println(++numero); // 15
        System.out.println(numero); // 15

        Scanner teclado = new Scanner(System.in);
        int edad = 55;
        System.out.print("Cuantos anios tienes: ");
//        edad = teclado.nextInt();
        System.out.println("Eres " + (edad >= 18 ? "Mayor de edad" : "Menor de edad"));


        System.out.println("*** Operadores a nivel de bit ***");
        numero = 20; // 20 esta en base 10. 00010100 es base 2
        System.out.println("numero original = " + numero);

        // corrimienro a la derecha con >>
        System.out.println("numero>>1: " + (numero>>1)); // 10 base 10 es 00001010
        System.out.println("numero>>2: " + (numero>>2)); // 5 base 10 es  00000101

        // corrimienro a la izquierda con <<
        System.out.println("numero<<1: " + (numero<<1)); // 40 base 10 es 00101000
        System.out.println("numero<<2: " + (numero<<2)); // 80 base 10 es 01010000


        // Logica de bits
        int hugo = 35; //  01010000 base 2
        int luis = 252; // 11111011 base 2
        // como puedo saber si tiene contratado Prime?
        // prime esta en la pos. 4
        System.out.println("hugo & 000001000: " + (hugo & 16)); // regresa 0
        System.out.println("hugo & 000001000: " + (luis & 16)); // regresa 16

        // como puedo agregar prime al servicio
        System.out.println("hugo | 000001000: " + (hugo | 16)); //
    }
}
