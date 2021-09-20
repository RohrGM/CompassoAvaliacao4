package com.compasso.politicos.repository;

import com.compasso.politicos.modelo.Associado;
import com.compasso.politicos.modelo.Partido;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;
import java.util.Optional;

public interface AssociadoRepository extends PagingAndSortingRepository<Associado, String>, JpaSpecificationExecutor<Associado> {

    List<Associado> findByPartidoId(Long id);

    void deleteById(Long id);

    Associado findById(Long id);
}
