enum Suscripcion {
    ORO, PLATA, BRONCE
}

public class Enumeraciones {
    public static void main(String[] args) {
        System.out.println("*** Enumeraciones ***");
        Suscripcion miSuscripcion = Suscripcion.ORO;
        Suscripcion tuSuscripcion = Suscripcion.PLATA;
        System.out.println("tuSuscripcion = " + tuSuscripcion);
        tuSuscripcion = Suscripcion.BRONCE;
        miSuscripcion = Suscripcion.valueOf("BRONCE");
        // Es posibe a partir del ordinal obtener el tipo de susc

        System.out.println("miSuscripcion = " + miSuscripcion.ordinal());

        System.out.println("*** Enumeraciones con atributos ***");
        Nivel miNivel = Nivel.ORO;
        Nivel tuNivel = Nivel.PLATA;
        Nivel suNivel = Nivel.GRATUITO;

        System.out.println("Mi nivel es: " + miNivel + " con anualidad de " + miNivel.getAnualidad() + " y " +miNivel.getDescuento() + "%");
        System.out.println("Tu nivel es: " + tuNivel + " con anualidad de " + tuNivel.getAnualidad() + " y " +tuNivel.getDescuento() + "%");
        System.out.println("Su nivel es: " + suNivel + " con anualidad de " + suNivel.getAnualidad() + " y " +suNivel.getDescuento() + "%");
    }
}
