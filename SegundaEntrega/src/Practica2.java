/*
Practica 2
Axel Fernando Montiel Aviles
21 de Marzo de 2026
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Practica2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Producto> carrito = new ArrayList<>();
        double precioTotal = 0.0;

        int codigo = 0;

        System.out.println("--- Punto de Venta ---");
        System.out.println("Ingrese los codigos de los productos para la venta (-1 para finalizar)");

        // se rompera el bucle cuando sea -1
        while (codigo != -1) {

            System.out.print("\nIngrese codigo de producto (-1 para salir): ");
            codigo = teclado.nextInt();

            if (codigo != -1) {
                Producto nuevoProducto = new Producto(codigo);

                // validar si existe el producto
                if (nuevoProducto.getNombre() == null) {
                    System.out.println("\t[Error] El producto " + codigo + " no existe.");
                } else {
                    System.out.println("\tNuevo producto registrado:");
                    System.out.println("\tnuevoProducto = " + nuevoProducto);

                    carrito.add(nuevoProducto);
                    precioTotal += nuevoProducto.getPrecio();

                    System.out.println("\t+ Lleva " + carrito.size() + " articulos. Subtotal: $" + precioTotal);
                }
            }
        }

        // Cuando se termino el bucle
        System.out.println("\n============================");
        System.out.println("RESUMEN DE VENTA");
        System.out.println("Total de productos: \t" + carrito.size());
        System.out.println("Precio Total (antes de IVA): \t$" + precioTotal);
        double iva = precioTotal*0.16;
        System.out.println("IVA: \t$" + iva);
        System.out.println("Precio Total con IVA: \t$" + ( precioTotal + iva));
        System.out.println("============================");

        teclado.close();
    }
}