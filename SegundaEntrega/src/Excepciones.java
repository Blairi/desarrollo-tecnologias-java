import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
    public static void main(String[] args) {
        System.out.println("** Excepciones **");
        int variable;
        int[] numeros = {9, -4, 0, 8, 10, 22};
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame un numero entero: ");
        try {
            try {

                variable = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("El dato no corresponde");
                variable = 1;
            }

            if (variable == 13) {
                MiExcepcion objeto = new MiExcepcion("Es de mala suerte");
                throw objeto; // dispara el objeto de tipo MiExcepcion
            }

            System.out.println("Valor capturado: " + variable);
            System.out.println("numeros[" + variable + "] = " + numeros[variable]);
            System.out.println("1000/" + variable + "=" + (1000 / variable));
        } catch (ArithmeticException e) {
            System.out.println("Sucedio un problema con una operacion aritmetica");
            System.out.println("Vuelve a intentarlo m'as tarde");
        }
        catch (InputMismatchException e) {
            System.out.println("Solo se permiten valores enteros");
            System.out.println("Intenta nuevamente");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fuerda de rango [0,5]");
            System.out.println("Prueba con un valor dentro del rango permitido");
        } catch (MiExcepcion e) {
            System.out.println("Atrape mi propia excepcion");
        }
        catch (Exception e) {
            System.out.println("Contacta al soporte");
        }
        finally {
            System.out.println("Cuando sale este texto?");
        }
        System.out.println("Fin del programa");
    }
}
