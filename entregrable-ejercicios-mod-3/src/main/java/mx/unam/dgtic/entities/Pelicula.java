package mx.unam.dgtic.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name="peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private int idPelicula;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "clasificacion")
    private String clasificacion;
}
