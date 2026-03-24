/*
Axel Fernando Montiel Aviles
Mauricio Lara Avila
Jesus Arturo Vazquez Zaragoza
 */

public class Cliente {
    int idCliente;
    String nombre;
    char sexo;
    int edad;
    double lineaCredito;
    String telefono;
    String email;

    public Cliente() {
        this.idCliente = -1;
        this.nombre = "sin nombre";
        this.sexo = '0';
        this.edad = 0;
        this.lineaCredito = 0.0;
        this.telefono = "+52 2143 1212";
    }

    public Cliente(int id) {
        this();
        // en la base de datos se buscara...
        this.idCliente = 2;
        this.nombre = "Carlos";
        this.sexo = 'M';
        this.email = "carlos@mail.com";
    }

    public Cliente(String telefono) {
        this();
        // se ejecuta consulta
        this.idCliente = 4;
        this.nombre = "";
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", edad=" + edad +
                ", lineaCredito=" + lineaCredito +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
