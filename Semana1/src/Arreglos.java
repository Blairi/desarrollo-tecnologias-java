import java.util.Scanner;

public class Arreglos {
    public static void main(String[] args) {
        System.out.println("*** Arreglos en Java ***");
        // Definicion de arreglos
        int[] arreglo1; // definicion
        int[] arreglo2 = new int[5]; // definicion e inicializacion del arreglo

        System.out.println("arreglo 2: " + arreglo2);

        // Acceso individual a los elementos
        arreglo2[3] = 33;
        arreglo2[1] = 11;
        arreglo2[4] = 44;

        System.out.println("arreglo2 = " + arreglo2[0]);

        // usando recorreremos el arreglo y desplegamos c/u de sus elementos
        for (int i = 0; i < arreglo2.length; i++) {
            System.out.println("arreglo2[" + i + "] = " + arreglo2[i]);
        }

        // arreglo1 = new int[4]; // inicializamos con otro arreglo
        arreglo1 = arreglo2; // inicializamos con otro arreglo 2
        arreglo2[4] = 999;
        for (int i = 0; i < arreglo1.length; i++) {
            System.out.println("arreglo1[" + i + "] = " + arreglo1[i]);
        }

        // 1. Generar un arreglo de 5 calificaciones
        double [] calificaciones = new double[5];
        // 2. Llenar cada una de las calif con teclado
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa 5 califiaciones (una a una): ");
        for (int i = 0; i < calificaciones.length; i++) {
            calificaciones[i] = teclado.nextDouble();
        }
        // 3. Desplegar el contenido del arreglo
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("calificaciones[" + i + "] = " + calificaciones[i]);
        }

        // 4. Cual es la más alta
        double califMax = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            califMax = Math.max(calificaciones[i], califMax);
        }
        System.out.println("califMax = " + califMax);

        System.out.println("** Arreglos de arreglos");
        double[][] parciales = new double[20][3]; // 20 alum. x 3 calif. de cada uno
        for (int alumno = 0; alumno < 20; alumno++) { // para cada alumno
            System.out.println("\nDel alumno " + (alumno + 1));
            for (int calificacion = 0; calificacion < 3; calificacion++) { // para cada calif
                System.out.print("\tCalificacion " + calificacion);
            }
        }

    } // fin de main
} // fin de class
