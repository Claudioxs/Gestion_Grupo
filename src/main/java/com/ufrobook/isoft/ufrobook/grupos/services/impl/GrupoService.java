package com.ufrobook.isoft.ufrobook.grupos.services.impl;

import com.ufrobook.isoft.ufrobook.grupos.models.entity.Grupo;
import com.ufrobook.isoft.ufrobook.grupos.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class GrupoService {


    @Autowired
    private GrupoRepository grupoRepository;

    public Grupo crearGrupo (Grupo grupo){
        if(grupo.getId() == null){
            return grupoRepository.save(grupo);
        }
        return null;
    }

    public List<Grupo> listadoGrupo() {
        List<Grupo> grupos = grupoRepository.findAll();
        if (grupos.isEmpty()) {
            // Cuando no hay grupos disponibles devolver una lista vacía
            return Collections.emptyList();
        }
        return grupos;
    }

    public Grupo obtenerGrupoPorId(Long id) {
        return grupoRepository.findById(id).orElse(null);
    }

    public Grupo actualizarGrupo(Grupo grupo) {
        if (grupo.getId() != null) {
            Grupo grupoExistente = grupoRepository.findById(grupo.getId()).orElse(null);
            if (grupoExistente != null) {
                grupoExistente.setNombreGrupo(grupo.getNombreGrupo());
                grupoExistente.setDescripcion(grupo.getDescripcion());
                return grupoRepository.save(grupoExistente);
            }
        }
        return null;
    }
    public void eliminarGrupo(Long id){grupoRepository.deleteById(id);}


    public void añadirModerador(){

    }
    public void eliminarModerador(){

    }
}
