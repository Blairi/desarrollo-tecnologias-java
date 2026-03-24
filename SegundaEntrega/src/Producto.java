/*
Practica 2
Axel Fernando Montiel Aviles
21 de Marzo de 2026
 */

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;

    public Producto() {

    }

    public Producto(int codigo) {
        this();
        this.codigo = codigo;
        switch (codigo) {
            case 1:
                this.nombre = "Cuaderno";
                this.precio = 50.00;
                break;
            case 3:
                this.nombre = "Pluma";
                this.precio = 13.00;
                break;
            case 5:
                this.nombre = "Regla";
                this.precio = 16.50;
                break;
            case 8:
                this.nombre = "Goma";
                this.precio = 7.00;
                break;
            case 9:
                this.nombre = "Lápiz";
                this.precio = 7.50;
                break;
            case 11:
                this.nombre = "Carpeta";
                this.precio = 126.00;
                break;
            case 22:
                this.nombre = "Tinta";
                this.precio = 554.00;
                break;
            case 99:
                this.nombre = "Sobres";
                this.precio = 32.00;
                break;
            case 123:
                this.nombre = "Folder";
                this.precio = 5.00;
                break;
            default:
                this.nombre = null;
                this.precio = 0.0;
                break;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
