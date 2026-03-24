import java.util.Objects;

public class Cliente extends Persona implements Comparable<Cliente> {
    private int telefono;
    private String usuario;
    private String metodoDePagoPreferido;
    public static double bono;

    public Cliente() {
        super(); // Explicitamante ejecuta el constructor
        this.telefono = 555;
        this.usuario = "ninguno";
    }

    public Cliente(String usuario) {
        this();
        this.usuario = usuario;
        this.telefono = 444;
    }

    public static int totalDeClientes() {
        // consultar la bdd
        return (765);
    }

    public boolean create(){
        return true;
    }
    public boolean read() {
        return true;
    }
    public boolean update() {
        return true;
    }
    public boolean delete() {
        return true;
    }

    public void generaCFDI() {
        // Aqui se genera el CFDI por el bono mensual al Asociado

    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMetodoDePagoPreferido() {
        return metodoDePagoPreferido;
    }

    public void setMetodoDePagoPreferido(String metodoDePagoPreferido) {
        this.metodoDePagoPreferido = metodoDePagoPreferido;
    }

    @Override
    public String toString() {
        return "Cliente{(" + super.toString() + "). " +
                "usuario='" + usuario + '\'' +
                ", telefono=" + telefono +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cliente cliente)) return false;
        // dos clientes son iguales si sus usuarios son iguales
        return Objects.equals(getUsuario(), cliente.getUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUsuario());
    }

    public int compareTo(Cliente otro) {
        // Regresara 0 si ==
        // > 0 si this es > otro
        // < 0 si this < otro
        int regreso = 0; // por default iguales
        if ( !this.equals((otro)) ) {
            regreso = this.getUsuario().compareTo(otro.getUsuario());
        }
        return regreso;
    }

}
