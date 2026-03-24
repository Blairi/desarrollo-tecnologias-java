import java.util.Objects;

public class Radio implements IControles, Icrud {
    private int volumen;
    private boolean encendido;
    private double frecuencia;

    public Radio () {
        this.encendido = false;
        this.frecuencia = 87.1;
        this.volumen = 30;
    }

    @Override
    public void subeVolumen() {
        this.volumen += 5;
    }

    @Override
    public void bajaVolumen() {
        this.volumen -= 5;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "Radio{" +
                "volumen=" + volumen +
                ", encendido=" + encendido +
                ", frecuencia=" + frecuencia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Radio radio)) return false;
        return volumen == radio.volumen && encendido == radio.encendido && Double.compare(frecuencia, radio.frecuencia) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumen, encendido, frecuencia);
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean read() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
