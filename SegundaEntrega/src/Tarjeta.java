import java.util.Objects;

public class Tarjeta implements Comparable<Tarjeta> {

    private int id;
    private String nombre;
    private int ataque;
    private int defensa;
    private String figura;

    public Tarjeta() {
    }

    public Tarjeta(int id) {
        this.id = id;
    }

    public Tarjeta(int id, String nombre, int ataque, int defensa, String figura) {
        this.id = id;
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.figura = figura;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = defensa; }

    public String getFigura() { return figura; }
    public void setFigura(String figura) { this.figura = figura; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarjeta tarjeta = (Tarjeta) o;
        return id == tarjeta.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tarjeta{id=" + id + ", nombre='" + nombre + "', ataque=" + ataque +
                ", defensa=" + defensa + ", figura='" + figura + "'}";
    }

    @Override
    public int compareTo(Tarjeta otra) {
        // Devuelve 1 si gana esta tarjeta, -1 si gana la otra, o 0 si empatan en ataque
        return Integer.compare(this.ataque, otra.ataque);
    }

}