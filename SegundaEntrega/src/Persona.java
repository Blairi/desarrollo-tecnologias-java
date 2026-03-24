public abstract class Persona implements Icrud{

    private String nombre;
    private String rfc;
    private String correo;
    private double calificacion;
    private int edad;

    public Persona() {
        this.nombre = "Sin nombre";
        this.rfc = "XXXX";
        this.calificacion = 0;
        this.edad = 0;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public final void setCalificacion(double calificacion) {
        if (calificacion >= 0 && calificacion <= 5)
            this.calificacion = calificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 18)
            this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", calificacion=" + calificacion +
                ", edad=" + edad +
                '}';
    }

    public abstract void generaCFDI();
}
