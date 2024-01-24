package com.platzi.sasf.web.controller;

import com.platzi.sasf.persistence.entity.RhemEmpleadoEntity;
import com.platzi.sasf.service.RhemEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/rheempleado")
public class RhemEmpleadoController {

    private final RhemEmpleadoService rhemEmpleadoService;

    @Autowired
    public RhemEmpleadoController(RhemEmpleadoService rhemEmpleadoService) {
        this.rhemEmpleadoService = rhemEmpleadoService;
    }

    @GetMapping
    public ResponseEntity<Page<RhemEmpleadoEntity>> obtener(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "8") int elements){
        return ResponseEntity.ok(this.rhemEmpleadoService.obtener(page, elements));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<RhemEmpleadoEntity> onlyobtener(@PathVariable int codigo){
        return ResponseEntity.ok(this.rhemEmpleadoService.onlyobtener(codigo));
    }

    @PostMapping
    public ResponseEntity<RhemEmpleadoEntity> add(@RequestBody RhemEmpleadoEntity rhemEmpleado){
        if (rhemEmpleado.getNumeroIdentificacion()==null || !this.rhemEmpleadoService.exists(rhemEmpleado.getNumeroIdentificacion())){
            return ResponseEntity.ok(this.rhemEmpleadoService.save(rhemEmpleado));
        }

        return ResponseEntity.badRequest().build();

    }

    @PutMapping
    public ResponseEntity<RhemEmpleadoEntity> update(@RequestBody RhemEmpleadoEntity rhemEmpleado){
        return ResponseEntity.ok(this.rhemEmpleadoService.save(rhemEmpleado));
    }

    @GetMapping("/empleados")
    public List<RhemEmpleadoEntity> buscarEmpleadosPorNombres(@RequestParam String nombres) {
        return rhemEmpleadoService.buscarPorNombres(nombres);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable int codigo){
        if (this.rhemEmpleadoService.exists(codigo)){
            this.rhemEmpleadoService.delete(codigo);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/all")
    public void deleteAllContratoEmpleados() {
        rhemEmpleadoService.deleteAll();
    }


}
