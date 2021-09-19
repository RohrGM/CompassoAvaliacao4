package com.compasso.politicos.controller.form;

import com.compasso.politicos.modelo.Associado;
import com.compasso.politicos.modelo.Partido;
import com.compasso.politicos.repository.AssociadoRepository;
import com.compasso.politicos.repository.PartidoRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class VinculaAssociadoPartidoForm {

    @NotNull @Min(value = 1)
    private long idAssociado;
    @NotNull @Min(value = 1)
    private long idPartido;

    public long getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(long idAssociado) {
        this.idAssociado = idAssociado;
    }

    public long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(long idPartido) {
        this.idPartido = idPartido;
    }

    public Associado atualizar(AssociadoRepository associadoRepository, PartidoRepository partidoRepository) {

        Associado associado = associadoRepository.findById(idAssociado);
        Partido partido = partidoRepository.findById(idPartido);

        associado.setPartido(partido);

        return associado;
    }
}
