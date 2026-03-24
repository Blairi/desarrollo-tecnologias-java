public class Variables { // inicio de clase
    public static void main(String[] args) { // inicia el bloque de la definicion de main
        System.out.println("Definicion y uso de variables");
        // Definicion de variables
        // tipo nombre;
        int edad;

        // Inicializacion de variables
        // variable = primer valor;
        edad = 99;

        // definicion e inicializacion
        double calificacion = 9.9;
        // definicion
        //     inicializacion

        // despues de definir e incializar se puede usar
        System.out.println("Contenido de edad: " + edad);
        System.out.println("Contenido de calificacion: " + calificacion);

        // Definicion de variables con var
        // var nombre = valor inicial;
        var nombre = "Axel"; // --> nombre sera string
        var asistencias = 7; // --> nombre sera int

        System.out.println("*** Tipos de datos primitivos ***");
        // booleanos
        boolean aprobado = true;
        boolean falto = false;
        System.out.println(aprobado);
        System.out.println(falto);

        // char (Un caracter)
        char inicial = 'A';
        System.out.println(inicial);
        System.out.println(inicial + 1);

        // numericos enteros: byte, short, int y long
        short estatura = 1_79; // en centimetros --> 1,79
        long precio = 123_456; // 123,456
        System.out.println(estatura + 1);
        System.out.println(precio);

        // numerico real: float, double
        double temperatura = 36.5;
        System.out.println(temperatura);

        System.out.println("*** Caracteres de escape ***");
        System.out.println("Universidad\nNacional\n\tAutonoma de Mexic\no");

        System.out.println("*** Clase String ***");
        String institucion = "DGTIC";
        String primerLetra = "A"; // a diferencia de 'A', este es un String
        System.out.println("institucion = " + institucion);

        {
            System.out.println("*** Expresiones ***");
            String domicilio = "Circuito s/n, CU";
            System.out.println(edad = 10); // variable int = valor int
            //                 int
            System.out.println(calificacion = 10.0); // variable double = valor int
            //                 double

            System.out.println("*** Promocion y Casting ***");
            calificacion = 9; // promocion
            //             9.0
            System.out.println("calificacion = " + calificacion);
            System.out.println(edad + 1.2);
            //         int + double
            //         double + double
            //         double

            calificacion = edad; // promocion
            // double      int
            //             double
            System.out.println("calificacion = " + calificacion);

            // Casting (nuevo tipo de dato) valor a convertir
            calificacion = 8;
            edad  = (int)calificacion;
            //           8.0
            //           8 (int)
        }



    } // fin del bloque de definicion del main
} // fin de la clase
