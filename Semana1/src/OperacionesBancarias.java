public class OperacionesBancarias {
    public static void main(String[] args) {
        int cuentaBancaria;
        double monto;
        System.out.println("*** Operaciones Bancarias ***");
        System.out.println("** Deposito a la cuenta de Rachel **");
        System.out.println("Dame el numero de cuenta: 111");
        System.out.println("Cuanto deposita: $100");

        // Clase objeto  = new Constructor
        cuentaBancaria = 111;
        monto = 100;
        Cuenta cuentaR = new Cuenta(cuentaBancaria);
        System.out.println("cuentaR = " + cuentaR);

        // Para aumentar el salo en 100
        if (cuentaR.depositar(monto)) {
            System.out.println("Operacion realizada");
//            System.out.println("Nuevo cuentaR.saldo = " + cuentaR.saldo);
        } else {
            System.out.println("ERROR 9832");
        }

        System.out.println("** Deposito a la cuenta de Ross **");
        System.out.println("Dame el numero de cuenta: 222");
        System.out.println("Cuanto retira: $800");

        // Clase objeto  = new Constructor
        cuentaBancaria = 222;
        monto = 80000000;
        Cuenta cuentaRoss = new Cuenta(cuentaBancaria);
        System.out.println("Hola " + cuentaRoss.getCliente());
        System.out.println("cuentaRoss = " + cuentaRoss);
        if (cuentaRoss.retirar(monto)) {
            System.out.println("Retiro realizado");
            System.out.println("cuentaRoss = " + cuentaRoss);
        } else {
            System.out.println("Error P344l");
        }

        Cuenta cuentaNueva = new Cuenta();
        System.out.println("Cuenta nueva: " + cuentaNueva);
        cuentaNueva.setId(129871);
        System.out.println("Cuenta modificada: " + cuentaNueva);

        System.out.println("** Transferencia de $500 de Rachel a Ross **");
        monto = 50000;
        // forma 1
        if (cuentaR.retirar(monto) && cuentaRoss.depositar(monto)) {
            System.out.println("Transferencia exitosa");
        } else {
            System.out.println("Transaccion rechazada");
        }

        // forma 2
        // transefir un monto $ de una cuenta origen a otra
        monto = 33000;
        System.out.println(cuentaR.transferirA(cuentaRoss, monto));

        System.out.println("cuentaRachel = " + cuentaR.getSaldo());
        System.out.println("cuentaRoss = " + cuentaRoss.getSaldo());
    }
}
