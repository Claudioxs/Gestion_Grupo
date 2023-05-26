
package com.ufrobook.isoft.ufrobook.grupos.controllers;

import com.ufrobook.isoft.ufrobook.cuenta.models.entity.Usuario;
import com.ufrobook.isoft.ufrobook.grupos.models.entity.Grupo;
import com.ufrobook.isoft.ufrobook.grupos.services.impl.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//usar postman
@RestController
@RequestMapping("/grupo/")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @PostMapping("/nuevoGrupo")
    public ResponseEntity<Grupo> crearGrupo(@RequestBody Grupo grupo) {
        //Obtener el nombre de usuario del usuario autenticado(spring security)
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String nombreUsuario = authentication.getName();

        // Obtener el usuario actual a través del servicio de usuarios
        //Usuario administrador = userService.findByUsername(nombreUsuario);

        // Crear una instancia de Grupo y establecer los valores
        Grupo nuevoGrupo = new Grupo();
        nuevoGrupo.setNombreGrupo(grupo.getNombreGrupo());
        nuevoGrupo.setDescripcion(grupo.getDescripcion());
        //nuevoGrupo.setAdministrador(administrador);

        // Guardar el grupo en la base de datos a través del servicio de grupo
        Grupo grupoCreado = grupoService.crearGrupo(nuevoGrupo);

        // Retornar una respuesta con el grupo creado
        return ResponseEntity.status(HttpStatus.CREATED).body(grupoCreado);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Grupo>> listadoGrupo() {
        List<Grupo> grupos = grupoService.listadoGrupo();
        if (grupos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(grupos);
        }
    }

    @PutMapping("/grupoActualizado/{id}")
    public ResponseEntity<Grupo> actualizarGrupo(@PathVariable Long id, @RequestBody Grupo grupo) {
        Grupo grupoExistente = grupoService.obtenerGrupoPorId(id);
        if (grupoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        grupoExistente.setNombreGrupo(grupo.getNombreGrupo());
        grupoExistente.setDescripcion(grupo.getDescripcion());

        Grupo grupoActualizado = grupoService.actualizarGrupo(grupoExistente);
        return ResponseEntity.ok(grupoActualizado);
    }

    @DeleteMapping("/grupoElininado/{id}")
    public ResponseEntity<String> eliminarGrupo(@PathVariable Long id) {
        grupoService.eliminarGrupo(id);
        return ResponseEntity.ok("Grupo eliminado correctamente");
    }





}

