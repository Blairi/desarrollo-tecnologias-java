package paqueteA;

public class PruebaPaqueteA {
    public static void main(String[] args) {
        System.out.println("Prueba en paquete A");
        ClaseA objeto1 = new ClaseA();

        System.out.println(objeto1.aPublico);
        System.out.println(objeto1.aProtegido);

        objeto1.mPublico();
        objeto1.mProtegido();
    }
}
