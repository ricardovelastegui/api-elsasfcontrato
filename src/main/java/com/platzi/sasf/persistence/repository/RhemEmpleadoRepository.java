package com.platzi.sasf.persistence.repository;

import com.platzi.sasf.persistence.entity.RhemEmpleadoEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RhemEmpleadoRepository extends ListCrudRepository<RhemEmpleadoEntity, Integer> {
    List<RhemEmpleadoEntity> findByNombresContaining(String nombre);

}
