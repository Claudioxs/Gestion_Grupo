package com.ufrobook.isoft.ufrobook.tedencias.models.entity;

import com.ufrobook.isoft.ufrobook.coment_reac.models.entity.Comentario;
import com.ufrobook.isoft.ufrobook.publi_histo.models.entity.Historia;
import com.ufrobook.isoft.ufrobook.publi_histo.models.entity.Publicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "hashtags")
@Entity
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "palabra_clave")
    private String palabraClave;

    private String hashTag;


    @ManyToMany(mappedBy = "hashtags")
    private List<Publicacion> publicaciones;

    @ManyToMany(mappedBy = "hashtags")
    private List<Historia> historias;

    @ManyToMany(mappedBy = "hashtags")
    private List<Comentario> comentarios;

    @ManyToOne
    @JoinColumn(name = "trending_topic_id")
    private TrendingTopic trendingTopic;

    private static final long serialVersionUID = 1L;

}
