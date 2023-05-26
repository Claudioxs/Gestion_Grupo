package com.ufrobook.isoft.ufrobook.muro.models.entity;

import com.ufrobook.isoft.ufrobook.grupos.models.entity.Grupo;
import com.ufrobook.isoft.ufrobook.publi_histo.models.entity.Historia;
import com.ufrobook.isoft.ufrobook.publi_histo.models.entity.Publicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "muros_grupales")
@Getter
@Setter
@Entity
public class MuroGrupal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_foto_grupo")
    private Long idFotoGrupo;

    @Column(name = "id_foto_portada")
    private Long idFotoPortada;


    @OneToMany(mappedBy = "muroGrupal")
    private List<Publicacion> publicacionesDestacadas;


    @OneToMany(mappedBy = "muroGrupal")
    private List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "muroGrupal")
    private List<Historia> historias;

    @OneToOne(mappedBy = "muro")
    private Grupo grupo;

    private static final long serialVersionUID = 1L;

}