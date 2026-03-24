/*
Sala 5
David Cañedo Vértiz
Donovan Carrasco Manjarrez
Axel Fernando Montiel Aviles
 */
public class CuentaHabiente extends Ciudadano{
    private String numeroCuenta;
    private double saldo;
    private double limiteDeCredito;
    private int diaMesCorte;
    private String CLABE;
    private int numDeCuenta;

    public CuentaHabiente() {
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public int getDiaMesCorte() {
        return diaMesCorte;
    }

    public void setDiaMesCorte(int diaMesCorte) {
        this.diaMesCorte = diaMesCorte;
    }

    public String getCLABE() {
        return CLABE;
    }

    public void setCLABE(String CLABE) {
        this.CLABE = CLABE;
    }

    public int getNumDeCuenta() {
        return numDeCuenta;
    }

    public void setNumDeCuenta(int numDeCuenta) {
        this.numDeCuenta = numDeCuenta;
    }
}
