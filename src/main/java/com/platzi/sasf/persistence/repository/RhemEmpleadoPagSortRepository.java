package com.platzi.sasf.persistence.repository;


import com.platzi.sasf.persistence.entity.RhemEmpleadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface RhemEmpleadoPagSortRepository extends ListPagingAndSortingRepository<RhemEmpleadoEntity, Integer> {

    Page<RhemEmpleadoEntity> findByAvailableTrue(Pageable pageable);

}
