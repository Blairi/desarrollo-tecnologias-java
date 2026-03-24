package paqueteA;

public class ClaseA {
    public int aPublico = 1;
    private int aPrivado = 2;
    protected int aProtegido = 3;

    public void mPublico() {
        System.out.println("Metodo publico");
    }

    private void mPrivado() {
        System.out.println("Metodo publico");
    }

    protected void mProtegido() {
        System.out.println("Metodo protegido");
    }

}
