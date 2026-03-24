public class ClasesEquivalentes {

    public static void metodo(Cliente objeto, String texto, int variable) {
        objeto = new Cliente();
        objeto.setNombre(texto);
        objeto.setEdad(variable);
        texto = "Nuevo texto";
        variable = 99;
    }

    public static void main(String[] args) {
        System.out.println("** Clases equivalentes **");
        Integer numeroEntero = 33;
        Double numeroDoble = 66.6;
        double variable = 66;

        System.out.println(numeroDoble.intValue());
        numeroDoble = Double.parseDouble("77.7");
        System.out.println(numeroDoble + 100);

        System.out.println("Paso de parametros");

        Cliente o1 = new Cliente();
        o1.setNombre("Ana");
        o1.setEdad(88);
        String texto = "Valor original";
        int numero = 100;
        System.out.println(o1 + "--" + texto + "--" + numero);
        metodo(o1, texto, numero);
        System.out.println(o1 + "--" + texto + "--" + numero);
    }
}
