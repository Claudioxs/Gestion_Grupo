package com.ufrobook.isoft.ufrobook.solicitudes.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "sugerencias")
@Entity
@Getter
@Setter
public class Sugerencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "validador_amigos")
    private Boolean validadorAmigos;


    @ManyToOne
    @JoinColumn(name = "lista_amigo_id")
    private ListaAmigo listaAmigo;

    @ManyToMany(mappedBy = "sugerencias")
    private List<SolicitudAmistad> solicitudesAmistad;

    private static final long serialVersionUID = 1L;

}
