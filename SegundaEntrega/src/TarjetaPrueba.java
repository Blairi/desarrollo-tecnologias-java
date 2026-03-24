public class TarjetaPrueba {
    public static void main(String[] args) {
        Tarjeta gohan = new Tarjeta(56, "GOHAN", 6600, 7700, "Tijera");
        Tarjeta ali = new Tarjeta(124, "PRINCIPE ALÍ", 5600, 6700, "Tijera");

        System.out.println(gohan);
        System.out.println(ali);

        System.out.println("\n--- COMBATE POR ATAQUE ---");
        int resultado = gohan.compareTo(ali);

        if (resultado > 0) {
            System.out.println("Gana " + gohan.getNombre() + " por tener mayor ataque!");
        } else if (resultado < 0) {
            System.out.println("Gana " + ali.getNombre() + " por tener mayor ataque!");
        } else {
            System.out.println("Es un empate de ataque!");
        }
    }
}
