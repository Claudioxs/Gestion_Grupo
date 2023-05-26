package com.ufrobook.isoft.ufrobook.solicitudes.models.entity;

import com.ufrobook.isoft.ufrobook.cuenta.models.entity.Usuario;
import com.ufrobook.isoft.ufrobook.notificaciones.models.entity.Notificacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "solicitudes_amistad")
@Getter
@Setter
@Entity
public class SolicitudAmistad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "usuario_remitente_id")
    private Usuario usuarioRemitente;

    @ManyToOne
    @JoinColumn(name = "usuario_destinatario_id")
    private Usuario usuarioDestinatario;

    @ManyToMany
    @JoinTable(
            name = "solicitudes_amistad_sugerencias",
            joinColumns = @JoinColumn(name = "solicitud_amistad_id"),
            inverseJoinColumns = @JoinColumn(name = "sugerencia_id")
    )
    private List<Sugerencia> sugerencias;

    @ManyToOne
    @JoinColumn(name = "lista_amigo_id")
    private ListaAmigo listaAmigo;

    private static final long serialVersionUID = 1L;

}
