import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {
        double examenes, exposicion, tareas;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Examenes: ");
        examenes = teclado.nextDouble();
        System.out.print("Exposicion: ");
        exposicion = teclado.nextDouble();
        System.out.print("Tareas: ");
        tareas = teclado.nextDouble();

        System.out.println("examenes = " + examenes);
        System.out.println("exposicion = " + exposicion);
        System.out.println("tareas = " + tareas);
        double promedio = (examenes + exposicion + tareas) / 3;
        System.out.println("Tu promedio es de: " + promedio);
    }
}
