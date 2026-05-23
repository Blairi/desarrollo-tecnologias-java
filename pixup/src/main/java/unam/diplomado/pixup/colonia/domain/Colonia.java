package unam.diplomado.pixup.colonia.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Colonia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String cp;
    @ManyToOne(targetEntity = Municipio.class)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;
}
