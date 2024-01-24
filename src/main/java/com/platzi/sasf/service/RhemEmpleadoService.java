package com.platzi.sasf.service;

import com.platzi.sasf.persistence.entity.RhemEmpleadoEntity;
import com.platzi.sasf.persistence.repository.RhemEmpleadoPagSortRepository;
import com.platzi.sasf.persistence.repository.RhemEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service

public class RhemEmpleadoService {

    private final RhemEmpleadoRepository rhemEmpleadoRepository;
    private final RhemEmpleadoPagSortRepository rhemEmpleadoPagSortRepository;
    @Autowired
    public RhemEmpleadoService(RhemEmpleadoRepository rhemEmpleadoRepository, RhemEmpleadoPagSortRepository rhemEmpleadoPagSortRepository) {
        this.rhemEmpleadoRepository = rhemEmpleadoRepository;
        this.rhemEmpleadoPagSortRepository = rhemEmpleadoPagSortRepository;
    }

    public List<RhemEmpleadoEntity> buscarPorNombres(String nombres) {
        return rhemEmpleadoRepository.findByNombresContaining(nombres);
    }


    public Page<RhemEmpleadoEntity> obtener(int page, int elements){
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.rhemEmpleadoPagSortRepository.findAll(pageRequest);
    }

    //metodo que no recupere un lista sino un solo entity
    public RhemEmpleadoEntity onlyobtener(int codigo){
        return this.rhemEmpleadoRepository.findById(codigo).orElse(null);
    }

    public RhemEmpleadoEntity save(RhemEmpleadoEntity rhemEmpleado){
        return this.rhemEmpleadoRepository.save(rhemEmpleado);
    }

    public void delete(int numero_identificacion){
        this.rhemEmpleadoRepository.deleteById(numero_identificacion);
    }

    public boolean exists(int codigo){
        return this.rhemEmpleadoRepository.existsById(codigo);}

    public void deleteAll() {
        rhemEmpleadoRepository.deleteAll();
    }

}
