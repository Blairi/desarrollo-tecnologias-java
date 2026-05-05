package mx.unam.dgtic.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="boletos")
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleto")
    private int idBoleto;

    @Column(name = "asiento")
    private String asiento;

    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;

    @Override
    public String toString() {
        return "Boleto{" +
                "idBoleto=" + idBoleto +
                ", asiento='" + asiento + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", funcion=" + (funcion != null ? funcion.getIdFuncion() : null) +
                '}';
    }
}
