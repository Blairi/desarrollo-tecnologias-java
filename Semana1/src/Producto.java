public class Producto {
    String nombre;
    int codidoDeBarras;
    char talla;
    String marca;
    String color;
    int existencias;
    double precioDeCompra;
    double precio;
    int descuento;

    public Producto() {
        System.out.println("Estoy en el constructor en Producto");
        this.nombre = "Indefinido";
        this.codidoDeBarras = -1;
        this.talla = 'C';
        this.marca = "Sin marca";
        this.color = "Blanco";
        this.existencias = 0;
        this.precio = 12345;
        this.precioDeCompra = 0;
    }

    public Producto(int codigo) {
        this(); // se refiere al constructor de la clase
        switch (codigo) {
            case 123:
                this.nombre = "Shorts Femeninos";
                this.codidoDeBarras = 123;
                this.talla = 'C';
                this.marca = "Patito";
                this.color = "Verde";
                this.existencias = 300;
                this.precio = 298;
                this.precioDeCompra = 200;
                this.descuento = 12;
                break;
            case 789:
                this.nombre = "Shorts Hombre";
                this.codidoDeBarras = 789;
                this.talla = 'G';
                this.marca = "Patar";
                this.color = "Azul";
                this.existencias = 2;
                this.precio = 29;
                this.precioDeCompra = 20;
                this.descuento = 1;
                break;
        }
    }

    public boolean alta() {
        // Aqui estara el codigo para registrar en la bd
        // un nuevo producto
        System.out.println("Dando de alta un nuevo producto");
        System.out.println("Producto dado de alta exitosamente");
        return true;
    }

    @Override
    public String toString() {
        String res = "Soy un producto ";
        res += "llamado " + this.nombre;
        res += " de color " + this.color;
        res += " con precio de " + this.precio;
        return res;
    }
}
