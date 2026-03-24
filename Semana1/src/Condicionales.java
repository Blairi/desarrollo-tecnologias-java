public class Condicionales {
    public static void main(String[] args) {
        System.out.println("*** Condicionales ***");
        System.out.println("** if/if-else");

        int edad = 8;
        char genero = 'F';

        System.out.println("Hola, tienes " + edad + " anios y tu genero es: " + genero);
        // if
        if (edad < 18){
            System.out.println("Felicidades, aun no tienes que pagar impuestos");
            System.out.println("Tienes mas tiempo libre");
        }

        // if-else
        if (edad >= 18) {
            System.out.println("Felicidades, ya puedes votar y ser votado");
            System.out.println("Y te pagan si trabajas");
            if (genero == 'M'){
                System.out.println("Por cierto, tienes que hacer el SMN");
            } else {
                System.out.println("Ademas, no tienes obligacion de realizar el SMN");
            }
        } else {
            System.out.println("Felicidades, aun no tienes que pagar impuestos");
        }

        System.out.println("*** switch como sentencia ***");
        edad = 12;
        switch (edad){
            case 4:
                System.out.println("Debes inscribirte al preescolar");
                break;
            case 6:
                System.out.println("Debes inscribirte a la primaria");
                break;
            case 12:
                System.out.println("Ahora debes inscribirte a la secundaria");
                break;
            default:
                System.out.println("Por lo pronto no debes inscribirte a nada, sigue");
                break;
        }

        System.out.println("*** Switch como expresion ***");
        String resultado;
        resultado = switch (edad) {
            case 4 -> "Kinder";
            case 6 -> "Primaria";
            case 12 -> "Secundaria";
            case 15 -> "Bachillerato";
            default -> "Nada";
        };

        System.out.println("Debes iniciar el tramite para entrar a: " + resultado);
    }
}
