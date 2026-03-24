import paqueteA.ClaseA;
import paqueteA.SubClase;

public class PruebaPaquetes {
    public static void main(String[] args) {
        System.out.println("Prueba en paquete A");
        ClaseA objeto1 = new ClaseA();

        System.out.println(objeto1.aPublico);

        objeto1.mPublico();

        SubClase objeto2 = new SubClase();
        objeto2.mPublico();



    }
}
