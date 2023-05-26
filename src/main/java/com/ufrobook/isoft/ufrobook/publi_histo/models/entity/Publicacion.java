package com.ufrobook.isoft.ufrobook.publi_histo.models.entity;

import com.ufrobook.isoft.ufrobook.coment_reac.models.entity.Comentario;
import com.ufrobook.isoft.ufrobook.coment_reac.models.entity.Reaccion;
import com.ufrobook.isoft.ufrobook.festividades.models.entity.Festividad;
import com.ufrobook.isoft.ufrobook.festividades.models.entity.Recuerdo;
import com.ufrobook.isoft.ufrobook.grupos.models.entity.Grupo;
import com.ufrobook.isoft.ufrobook.muro.models.entity.Muro;
import com.ufrobook.isoft.ufrobook.muro.models.entity.MuroGrupal;
import com.ufrobook.isoft.ufrobook.tedencias.models.entity.HashTag;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name = "publicaciones")
@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    @Column(name = "texto_publicacion")
    private String  textoDeLaImagen;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;


    @OneToOne(mappedBy = "publicacion")
    private Festividad festividad;

    @OneToOne(mappedBy = "publicacion")
    private Recuerdo recuerdo;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "muro_id")
    private Muro muro;

    @ManyToOne
    @JoinColumn(name = "muro_grupal_id")
    private MuroGrupal muroGrupal;

    @ManyToMany
    @JoinTable(
            name = "publicacion_hashtags",
            joinColumns = @JoinColumn(name = "publicacion_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private List<HashTag> hashtags;

    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "publicacion")
    private List<Reaccion> reacciones;

    private static final long serialVersionUID = 1L;

}
