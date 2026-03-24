import java.util.Scanner;

public class Instanciacion {

    public static void despliega(Producto producto) {
        System.out.println("Producto: " + producto);
        System.out.println("\tNombre: " + producto.nombre);
        System.out.println("\tCodigo de barras: " + producto.codidoDeBarras);
        System.out.println("\tPrecio: $" + producto.precio);
        System.out.println("\tPrecio de compra: $" + producto.precioDeCompra);
        System.out.println("\tMarca: " + producto.marca);
        System.out.println("\tTalla: " + producto.talla);
        System.out.println("\tColor: " + producto.color);
        System.out.println("\tExistencias: " + producto.existencias);
    }

    public static void main(String[] args) {
        System.out.println("** Ejemplo de Instanciacion de clases **");

        Producto objeto3 = new Producto(1234);
        despliega(objeto3);

        Cliente cliente = new Cliente();
        System.out.println(cliente);

        // Clase objeto  = new Clase();

        Producto objeto1 = new Producto();
        // Referencia a los atributos de un objeto
        // objeto.atributo
        objeto1.codidoDeBarras = 12345;
        objeto1.talla = 'C';
        objeto1.marca = "Levis";
        objeto1.color = "Azul";
        objeto1.existencias = 100;
        objeto1.precio = 1000.0;
        despliega(objeto1);

        Producto objeto2 = new Producto();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame los datos del nuevo producto:");
        System.out.print("\tNombre: ");
        objeto2.nombre = teclado.nextLine();
        System.out.print("\tCodigo de barras: ");
        objeto2.codidoDeBarras = teclado.nextInt();
        System.out.print("\tPrecio: ");
        objeto2.precio = teclado.nextDouble();

        if (objeto2.alta()) {
            System.out.println("El alta se llevo a cabo OK");
        } else {
            System.out.println("Error 98TX, no se guardo en la BD");
        }
        despliega(objeto2);

    }
}
