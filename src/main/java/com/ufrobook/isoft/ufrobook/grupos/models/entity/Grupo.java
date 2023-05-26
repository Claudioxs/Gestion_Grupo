package com.ufrobook.isoft.ufrobook.grupos.models.entity;

import com.ufrobook.isoft.ufrobook.cuenta.models.entity.Usuario;
import com.ufrobook.isoft.ufrobook.mensajes.models.entity.Mensaje;
import com.ufrobook.isoft.ufrobook.muro.models.entity.MuroGrupal;
import com.ufrobook.isoft.ufrobook.notificaciones.models.entity.Notificacion;
import com.ufrobook.isoft.ufrobook.publi_histo.models.entity.Historia;
import com.ufrobook.isoft.ufrobook.publi_histo.models.entity.Publicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "grupos")
@Getter
@Setter
@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_grupo")
    private String nombreGrupo;

    private String descripcion;

    @Column(name = "cant_maximo")
    private int cantMaximo;


    @ManyToMany
    @JoinTable(name = "usuario_grupo",
            joinColumns = @JoinColumn(name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "grupoModerador")
    private List<Usuario> moderadores = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "administrador_id")
    private Usuario administrador;

    @OneToMany(mappedBy = "grupo")
    private List<Solicitud> solicitudes = new ArrayList<>();

    @OneToMany( mappedBy = "grupo")
    private List<Mensaje> mensajes;

    @OneToMany(mappedBy = "grupo")
    private List<Publicacion> publicaciones;

    @OneToOne
    @JoinColumn(name = "grupo_id")
    private MuroGrupal muro;

    @OneToMany(mappedBy = "grupo")
    private List<Historia> historias;

    private static final long serialVersionUID = 1L;

}
