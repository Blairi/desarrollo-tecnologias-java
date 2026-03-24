public enum Nivel {
    // enumeracion para niveles de un gym
    PLATINO(1200, 10),
    ORO(1000, 5),
    PLATA(500, 3),
    BRONCE(500, 2),
    GRATUITO(0, 1);
    // definir los valores posibles
    private double anualidad;
    private int descuento;

    Nivel(double anualidad, int descuento) {
        this.anualidad = anualidad;
        this.descuento = descuento;
    }

    public double getAnualidad() {
        return anualidad;
    }

    public int getDescuento() {
        return descuento;
    }
}
