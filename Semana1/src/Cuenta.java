public class Cuenta {
    private int id;
    private String cliente;
    private double saldo;

    public Cuenta() {
        this.id = 0;
        this.cliente = "Indefinido";
        this.saldo = 0;
    }

    public Cuenta(int id) {
        switch (id) {
            case 111:
                this.id = id;
                this.cliente = "Rachel";
                this.saldo = 1000;
                break;

            case 222:
                this.id = id;
                this.cliente = "Ross";
                this.saldo = 3000;
                break;

            case 333:
                this.id = id;
                this.cliente = "Monica";
                this.saldo = 3000;
                break;
        }
    }

    public String getId() {
        String resultado = String.valueOf(this.id);
        return "***" + resultado;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCliente() {
        return this.cliente.toUpperCase();
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    // Metodos para manejo de cuenta

    public boolean depositar(double monto) {
        if (monto <= 0)
            return false;

        this.saldo += monto;
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || this.saldo < monto)
            return false;
        this.saldo -= monto;
        return true;
    }

    public int transferirA(Cuenta destino, double monto) {
        int resultado = 0;
        // el origen es this
        // 1. retirar dinero del origen
        if (this.retirar(monto)) {
            // depositamos al destino
            if (destino.depositar(monto)) {
                resultado = 100; //ok
            } else{
                resultado = -30; // retiro ok, pero no pudo
            }
        } else {
            resultado = -45; // no pudo retirar
        }
        return resultado;
    }
}
