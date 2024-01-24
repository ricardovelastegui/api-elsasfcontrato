package com.platzi.sasf.service;

import com.platzi.sasf.persistence.entity.RhemContratoEmpleadoEntity;
import com.platzi.sasf.persistence.repository.RhemContratoEmpleadoPagSortRepository;
import com.platzi.sasf.persistence.repository.RhemContratoEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RhemContratoEmpleadoService  {
    private final RhemContratoEmpleadoRepository rhemContratoEmpleadoRepository;
    private final RhemContratoEmpleadoPagSortRepository rhemContratoEmpleadoPagSortRepository;
    @Autowired
    public RhemContratoEmpleadoService(RhemContratoEmpleadoRepository rhemContratoEmpleadoRepository, RhemContratoEmpleadoPagSortRepository rhemContratoEmpleadoPagSortRepository) {
        this.rhemContratoEmpleadoRepository = rhemContratoEmpleadoRepository;
        this.rhemContratoEmpleadoPagSortRepository = rhemContratoEmpleadoPagSortRepository;
    }
    public Page<RhemContratoEmpleadoEntity> obetener(int page, int elements){
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.rhemContratoEmpleadoPagSortRepository.findAll(pageRequest);
    }

    public RhemContratoEmpleadoEntity onlyobtener(int codigo){
        return this.rhemContratoEmpleadoRepository.findById(codigo).orElse(null);
    }

    public RhemContratoEmpleadoEntity save(RhemContratoEmpleadoEntity rhemContratoEmpleado){
        return this.rhemContratoEmpleadoRepository.save(rhemContratoEmpleado);
    }

    public void delete(int codigo){
        this.rhemContratoEmpleadoRepository.deleteById(codigo);
    }

    public void deleteAll() {
        rhemContratoEmpleadoRepository.deleteAll();
    }

    public boolean exists(int codigo){
        return this.rhemContratoEmpleadoRepository.existsById(codigo);
    }

}
