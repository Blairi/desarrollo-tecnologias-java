public class ClienteVIP extends Cliente{
    private int descuento;
    public int getDescuento() {
        return descuento;
    }
    public ClienteVIP() {
        super();
        this.descuento = 5;
    }
}
