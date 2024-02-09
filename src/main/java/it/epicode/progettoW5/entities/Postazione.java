package it.epicode.progettoW5.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codice;
    private String descrizione;
    private TipoPostazione tipoPostazione;
    private int numeroMassimoOccupanti;
    @ManyToOne
    @JoinColumn(name="edificio_id")
    private Edificio edificio;
}
