package com.platzi.sasf.web.controller;

import com.platzi.sasf.persistence.entity.RhemContratoEmpleadoEntity;
import com.platzi.sasf.service.RhemContratoEmpleadoService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/rhemcontrato")
public class RhemContratoEmpleadoController {
    private final RhemContratoEmpleadoService rhemContratoEmpleadoService;

    @Autowired
    public RhemContratoEmpleadoController(RhemContratoEmpleadoService rhemContratoEmpleadoService) {
        this.rhemContratoEmpleadoService = rhemContratoEmpleadoService;
    }


    @GetMapping
    public Page<RhemContratoEmpleadoEntity> obtener(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "8") int elements){
        return this.rhemContratoEmpleadoService.obetener(page, elements);
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<RhemContratoEmpleadoEntity> onlyobtener(@PathVariable int codigo){
        return ResponseEntity.ok(this.rhemContratoEmpleadoService.onlyobtener(codigo));
    }

    @PostMapping()
    public ResponseEntity<RhemContratoEmpleadoEntity> add(@RequestBody RhemContratoEmpleadoEntity rhemContratoEmpleado){
        if (rhemContratoEmpleado.getCodigo()==null || !this.rhemContratoEmpleadoService.exists(rhemContratoEmpleado.getCodigo())){
            return ResponseEntity.ok(this.rhemContratoEmpleadoService.save(rhemContratoEmpleado));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<RhemContratoEmpleadoEntity> update(@RequestBody RhemContratoEmpleadoEntity rhemContratoEmpleado){

        if (rhemContratoEmpleado.getCodigo() !=null && this.rhemContratoEmpleadoService.exists(rhemContratoEmpleado.getCodigo())){
            return ResponseEntity.ok(this.rhemContratoEmpleadoService.save(rhemContratoEmpleado));
        }
        return ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/all")
    public void deleteAllContratoEmpleados() {
        rhemContratoEmpleadoService.deleteAll();
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable int codigo){
        if (this.rhemContratoEmpleadoService.exists(codigo)){
            this.rhemContratoEmpleadoService.delete(codigo);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


}
