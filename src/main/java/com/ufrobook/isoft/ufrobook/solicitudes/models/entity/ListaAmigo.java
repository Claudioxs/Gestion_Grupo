package com.ufrobook.isoft.ufrobook.solicitudes.models.entity;

import com.ufrobook.isoft.ufrobook.cuenta.models.entity.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "lista_amigos")
@Entity
public class ListaAmigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "integranteListaAmigos")
    private List<Usuario> amigos;

    @OneToMany(mappedBy = "listaAmigo")
    private List<Sugerencia> sugerencias;

    @OneToMany(mappedBy = "listaAmigo")
    private List<SolicitudAmistad> solicitudesAmistad;


    private static final long serialVersionUID = 1L;

}