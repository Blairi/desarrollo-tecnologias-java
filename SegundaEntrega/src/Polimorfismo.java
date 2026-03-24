public class Polimorfismo {
    public static void main(String[] args) {
        System.out.println("** Polimorfismo **");
        // Clase objeto = new Constructor(parametros);

        Cliente o1 = new Cliente();
        o1.setEdad(20); // o1 se comporta como Persona
        o1.setNombre("Carlos");
        o1.setMetodoDePagoPreferido("TDC");

        Asociado o2 = new Asociado();
        o2.setEdad(20); // o2 se comporta como asociado
        o2.setNombre("Axel");

        Cliente o3 = new ClienteVIP();
        System.out.println("o3 = " + o3);

        Cliente[] fila = new Cliente[3];
        fila[0] = o1; // cliente
        fila[1] = o3; // cliente vip
        fila[2] = new Cliente();

        for (int i = 0; i < fila.length; i++) {
            System.out.println("Cliente " + (i + 1) + ": " + fila[i]);
        }

        Persona[] personas = new Persona[3];
        personas[0] = new Cliente();
        personas[1] = new Asociado();
        personas[2] = new ClienteVIP();
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona " + (i + 1) + ": " + personas[i]);
        }
    }
}
