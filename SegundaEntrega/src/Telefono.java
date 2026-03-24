public class Telefono implements IControles{
    // atributos
    private int numero;
    private int nivelVolumen;

    // metodos
    public Telefono() {
        this.numero = 0;
    }

    @Override
    public void subeVolumen() {
        this.nivelVolumen += 5;
        if (this.nivelVolumen > VOLUMEN_MAXIMO)
            this.nivelVolumen = VOLUMEN_MAXIMO;
    }

    @Override
    public void bajaVolumen() {
        this.nivelVolumen -= 5;
    }

    public void llamar(int aQuien) {

    }

    // set y get

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNivelVolumen() {
        return nivelVolumen;
    }

    public void setNivelVolumen(int nivelVolumen) {
        this.nivelVolumen = nivelVolumen;
    }


    // to string
    @Override
    public String toString() {
        return "Telefono{" +
                "numero=" + numero +
                ", nivelVolumen=" + nivelVolumen +
                '}';
    }
}
