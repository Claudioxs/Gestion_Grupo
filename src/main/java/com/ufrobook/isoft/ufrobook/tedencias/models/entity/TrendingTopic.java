package com.ufrobook.isoft.ufrobook.tedencias.models.entity;

import com.ufrobook.isoft.ufrobook.muro.models.entity.Muro;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "trending_topics")
@Getter
@Setter
@Entity
public class TrendingTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;


    @OneToMany(mappedBy = "trendingTopic")
    private List<HashTag> hashTags ;

    @OneToOne(mappedBy = "trendingTopic")
    private Muro muro;

    private static final long serialVersionUID = 1L;

}
