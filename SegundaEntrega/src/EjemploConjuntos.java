import java.util.HashSet;

public class EjemploConjuntos {
    public static void main(String[] args) {
        System.out.println("*** Ejemplo conjuntos ***");
        HashSet<String> java = new HashSet<>();
        java.add("Axel");
        java.add("Alfredo");
        java.add("David");
        System.out.println("Personas que tomaron el curso de Java: " + java);

        HashSet<String> python = new HashSet<>();
        python.add("Paulina");
        python.add("Daniel");
        python.add("Axel");
        python.add("Alfredo");
        System.out.println("Personas que tomaron el curso de Python: " + python);

//        System.out.println("Operaciones de conjunto ");
//        java.addAll(python);
//        System.out.println("Union: " + java);

//        System.out.println("** Interseccion **");
//        java.retainAll(python);
//        System.out.println("interseccion " + java);

//        System.out.println("Diferencia");
//        java.removeAll(python);
//        System.out.println("Personas que tomaron Java pero no Python");

        HashSet<Cliente> tiendaA = new HashSet<Cliente>();
        tiendaA.add(new Cliente("Axel"));
        tiendaA.add(new Cliente("Donovan"));
        tiendaA.add(new Cliente("David"));
        System.out.println("Clientes de A: " + tiendaA);

        HashSet<Cliente> tiendaB = new HashSet<Cliente>();
        tiendaB.add(new Cliente("Alfredo"));
        tiendaB.add(new Cliente("Paulina"));
        tiendaB.add(new Cliente("Donovan"));
        tiendaB.add(new ClienteVIP());

        System.out.println("Clientes de B: " + tiendaB);



    }
}
