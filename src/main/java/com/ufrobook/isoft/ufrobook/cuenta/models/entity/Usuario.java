package com.ufrobook.isoft.ufrobook.cuenta.models.entity;

import com.ufrobook.isoft.ufrobook.coment_reac.models.entity.Comentario;
import com.ufrobook.isoft.ufrobook.coment_reac.models.entity.Reaccion;
import com.ufrobook.isoft.ufrobook.grupos.models.entity.Grupo;
import com.ufrobook.isoft.ufrobook.grupos.models.entity.Solicitud;
import com.ufrobook.isoft.ufrobook.mensajes.models.entity.Mensaje;
import com.ufrobook.isoft.ufrobook.muro.models.entity.Muro;
import com.ufrobook.isoft.ufrobook.notificaciones.models.entity.Notificacion;
import com.ufrobook.isoft.ufrobook.solicitudes.models.entity.ListaAmigo;
import com.ufrobook.isoft.ufrobook.solicitudes.models.entity.SolicitudAmistad;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name =  "usuarios" )
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @NotBlank
    @Column(name = "nombre_pila")
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String clave;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;


    @OneToMany(mappedBy = "remitente")
    private List<Solicitud> solicitudesGrupoEnviadas;

    @OneToMany(mappedBy = "destinatario")
    private List<Solicitud> solicitudesGrupoRecibidas ;

    @ManyToMany(mappedBy = "usuarios")
    private List<Grupo> grupos;

    @ManyToOne
    @JoinColumn(name = "id_grupo_del_moderador")
    private Grupo grupoModerador;

    @OneToOne(mappedBy = "administrador")
    private Grupo grupoAdministrador;

    @OneToMany(mappedBy = "emisor")
    private List<Mensaje> mensajesEnviados ;

    @OneToMany(mappedBy = "receptor")
    private List<Mensaje> mensajesRecibidos ;

    @OneToOne(mappedBy = "usuario")
    private Muro muro;

    @OneToMany(mappedBy = "usuario")
    private List<Notificacion> notificaciones;

    @OneToMany(mappedBy = "usuarioRemitente")
    private List<SolicitudAmistad> solicitudesEnviadas;

    @OneToMany(mappedBy = "usuarioDestinatario")
    private List<SolicitudAmistad> solicitudesRecibidas;

    @ManyToOne
    @JoinColumn(name = "id_integrante_lista_amigos")
    private ListaAmigo integranteListaAmigos;

    @OneToOne(mappedBy = "usuario")
    private ListaAmigo listaAmigo;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    private List<Reaccion> reacciones;

    private static final long serialVersionUID = 1L;

}
