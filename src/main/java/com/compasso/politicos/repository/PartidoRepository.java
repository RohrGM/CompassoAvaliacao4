package com.compasso.politicos.repository;

import com.compasso.politicos.modelo.Partido;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PartidoRepository extends PagingAndSortingRepository<Partido, String>, JpaSpecificationExecutor<Partido> {

    Partido findById(Long id);

    void deleteById(Long id);

    Partido findByNome(String nomePartido);
}
