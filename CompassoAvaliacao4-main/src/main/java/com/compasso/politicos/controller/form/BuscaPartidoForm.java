package com.compasso.politicos.controller.form;

import com.compasso.politicos.modelo.Ideologia;
import com.compasso.politicos.modelo.Partido;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

public class BuscaPartidoForm {
    private Ideologia ideologia;

    public BuscaPartidoForm( Ideologia ideologia) {
        this.ideologia = ideologia;
    }

    public Specification<Partido> toSpec() {
        return (root, query, builder) -> {
            List<Predicate> predicados = new ArrayList<>();
            if(ideologia != null) {
                Path<String> campoIdeologia = root.<String>get("ideologia");
                Predicate predicadoIdeologia = builder.equal(campoIdeologia, ideologia);
                predicados.add(predicadoIdeologia);
            }
            return builder.and(predicados.toArray(new Predicate[0]));
        };
    }
}
