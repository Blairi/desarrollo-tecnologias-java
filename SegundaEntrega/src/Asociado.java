public final class Asociado extends Persona{
    private String licencia;
    private String placas;

    public void generaCFDI() {
        // Aqui se genera el CFDI por el bono mensual al Asociado

    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public void setEdad(int edad) {
        if (edad >= 20 && edad <= 60) {
            super.setEdad(edad);
        }
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

    @Override
    public String toString() {
        return "Asociado{" + getNombre() + ". " +
                "licencia='" + licencia + '\'' +
                ", placas='" + placas + '\'' +
                '}';
    }
}
