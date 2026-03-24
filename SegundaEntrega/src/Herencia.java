public class Herencia {
    public static void main(String[] args) {
        System.out.println("** Herencia **");

        System.out.println("Metodos estaticos");
        System.out.println(Cliente.totalDeClientes());

        System.out.println("*** Atributos estaticos ***");
        Cliente.bono = 0.07;
        System.out.println(Cliente.bono);

        // Instanciar la clase Persona
//        Persona o1 = new Persona();
//
//        o1.setEdad(20);
//        o1.setNombre("Axel");
//        System.out.println("Persona -> o1 = " + o1);

        // instanciar la subclase Asociado
        Asociado o2 = new Asociado();
        o2.setEdad(20); //
        o2.setNombre("Curtis");
        o2.setPlacas("ABC123");
        System.out.println("Asociado -> o2 = " + o2);
        System.out.println("Edad del asociado: " + o2.getEdad());

        // instancia la subclase cliente
        Cliente o3 = new Cliente();
//        o3.setNombre("Lucia");
        o3.setEdad(20);
        o3.setUsuario("lucia123");
        System.out.println("Cliente -> o3 = " + o3);
        System.out.println(o3.totalDeClientes());
        System.out.println(o3.bono);

        ClienteVIP o4 = new ClienteVIP();
        System.out.println("o4 = " + o4);

        // Palabra reservada final
        final int EDAD = 50;
//        EDAD = 99;
        System.out.println("edad = " + EDAD);

    }
}
