public class Funciones {

    public static void main(String[] args) {
        System.out.println("*** Funciones ***");
        // Llamado/ejecucion de la funcion
        mensaje();
        String texto1;
        texto1 = mensaje();
        System.out.println(texto1);

        System.out.println(mensaje());

        // Funcion que recibe dos enteros y regresa un valor
        System.out.println(suma(8,9));
        byte vByte = 10;
        long vLong = 20;
        double vDouble = 30;
        System.out.println(suma(vByte, 500));
        System.out.println(suma(vByte, (int)vLong));
        System.out.println(suma(100, (int)vDouble));
        System.out.println(suma(100, vDouble));
        System.out.println(suma(100.9, 200));
        //                     double             , int

        // Procedimiento sobrecargado
        System.out.println();

        System.out.println(sumatoria(5, 9));

        System.out.println(sumatoriaRecursiva(5));
    }

    public static int sumatoria(int valorInicial, int valorFinal) {
        // Regresar la sumatoria de los enteros en [valorInicial, valorFinal]
        // p. ej sumatoria (5,9) -> 5+6+7+8+9 = 35
        int suma = 0;
        for (int i = valorInicial; i <= valorFinal; i++) {
            suma += i;
        }
        return suma;
    }

    public static int sumatoria(int valorFinal) {
        int res = 0;
        for (int i = 1; i <= valorFinal; i++) {
            res += i;
        }
        return res;
    }

    public static String mensaje() {
        System.out.println("Estoy dentro de la funcion");
        return "Hola"; // lo que regresa a quien la ejecute
    }

    public static double sumatoriaRecursiva(int valorFinal) {
        double resultado;
        if (valorFinal > 0)
            resultado = valorFinal + sumatoriaRecursiva(valorFinal - 1);
        else
            resultado = 0; // por definicion, la sumatoria de 0 es 0
        return resultado;
    }

    public static double suma(int primerNumero, int segundoNumero) {
        double resultado;
        resultado = primerNumero + segundoNumero;
        return resultado;
    }

    public static double suma(double primerNumero, double segundoNumero) {
        double resultado;
        resultado = primerNumero + segundoNumero;
        return resultado;
    }

}
