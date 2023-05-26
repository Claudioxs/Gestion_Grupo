package com.ufrobook.isoft.ufrobook.grupos.repository;

import com.ufrobook.isoft.ufrobook.grupos.models.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends  JpaRepository<Solicitud,Long>{
}
