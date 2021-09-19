package com.compasso.politicos.controller.form;

import com.compasso.politicos.modelo.Associado;
import com.compasso.politicos.modelo.Cargo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class BuscaAssociadoForm {

    private Cargo cargopolitico;

    public BuscaAssociadoForm(Cargo cargopolitico) {
        this.cargopolitico = cargopolitico;
    }

    public Specification<Associado> toSpec() {
        return (root, query, builder) -> {
            List<Predicate> predicados = new ArrayList<>();
            if(cargopolitico != null) {
                Path<String> campoCargo = root.<String>get("cargopolitico");
                Predicate predicadoCargo = builder.equal(campoCargo, cargopolitico);
                predicados.add(predicadoCargo);
            }
            return builder.and(predicados.toArray(new Predicate[0]));
        };
    }
}
