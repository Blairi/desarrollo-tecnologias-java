import java.sql.SQLOutput;
import java.util.HashMap;

public class EjemploHashMap {
    public static void main(String[] args) {
        System.out.println("*** Ejemplo de Mapa con HashMap ***");
        HashMap<Integer, String> alumnos = new HashMap<>();
        System.out.println("alumnos = " + alumnos);

        alumnos.put(9876, "Lucia");
        alumnos.put(1234, "Luis");
        alumnos.put(987, "Juan");
        alumnos.put(8877, "Eligio");
        System.out.println("alumnos = " + alumnos);

        alumnos.put(987, "Carlos");
        alumnos.put(6633, "Laura");
        System.out.println("alumnos = " + alumnos);

        System.out.println("Valor en 986 = " + alumnos.get(987));
        System.out.println("Valor en 666 = " + alumnos.get(666));

        //
        System.out.println("Eliminando al 987: " + alumnos.remove(987));
        System.out.println("Eliminando al 666: " + alumnos.remove(666));
        System.out.println("Alumnos despues de remove " + alumnos);

        HashMap<String, Integer> meses = new HashMap<>();
        meses.put("Enero", 31);
        meses.put("Febrero", 28);
        meses.put("Marzo", 31);
        System.out.println("Dias del tercer mes: " + meses.get("Marzo"));

    }
}
