/*

Autor: Axel Fernando Montiel Aviles

 */

import java.util.Scanner;

public class Practica1 {
    public static void main(String[] args) {
        // presentacion
        System.out.println("=== Practica 1: Informacion Estudiantil ===");
        Scanner teclado = new Scanner(System.in);

        int opcion;
        // ciclo infinito para el menu.
        while (true) {
            System.out.println("\n\n1 -> Ingresar nuevo estudiante\n0 -> Cerrar programa");
            System.out.print("Ingresar nuevo estudiante? ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            // el usuario desea cerrar el programa...
            if (opcion == 0)
                return;

            // entrada de datos
            System.out.print("\nIngresa nombre: ");
            String nombre = teclado.nextLine();

            System.out.print("Ingresa edad: ");
            int edad = teclado.nextInt();

            System.out.print("Ingresa el numero de materias cursadas: ");
            int numeroDeMateriasCursadas = teclado.nextInt();

            System.out.print("Ingresa el promedio final: ");
            float promedioFinal = teclado.nextFloat();

            System.out.print("Ingresa los creditos cursados: ");
            int creditosCursados = teclado.nextInt();

            // Desplegando informacion
            System.out.println("\n=== Informacion del estudiante " + nombre + " ===");
            evaluarEdad(edad);
            System.out.println("Su estado academico es: " +
                    estadoAcademico(promedioFinal, creditosCursados)
            );
            evaluarEligibilidadBeca(promedioFinal, creditosCursados);
            System.out.println("Creditos faltantes: %" + creditosFaltantes(creditosCursados));

        }

    }

    public static void evaluarEdad(int edad) {
        System.out.println(edad >= 18 ? "Es mayor de edad" : "Es menor de edad");
    }

    public static String estadoAcademico(double promedio, int creditosCursados) {
        String estado = "Irregular";
        if (promedio >= 8.0 && creditosCursados > 20) {
            estado = "Regular";
        }
        return estado;
    }

    public static void evaluarEligibilidadBeca(double promedio, int creditosCursados) {
        if (promedio >= 9.0 && creditosCursados >= 30) {
            System.out.println("Si es elegible para beca");
        } else {
            System.out.println("No es elegible para la beca");
        }
    }

    public static float creditosFaltantes(int creditosCursados) {
        /*
        Usando regla de 3
        120 - 100
        CC  - x
        -> creditos faltantes = CC * 100 / 120
         */
        return creditosCursados * 100 / 120;
    }
}
