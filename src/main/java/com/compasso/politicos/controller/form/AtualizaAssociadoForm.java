package com.compasso.politicos.controller.form;

import com.compasso.politicos.modelo.Cargo;
import com.compasso.politicos.modelo.Associado;
import com.compasso.politicos.modelo.Partido;
import com.compasso.politicos.repository.AssociadoRepository;
import com.compasso.politicos.repository.PartidoRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AtualizaAssociadoForm {

    @NotNull
    private Cargo cargopolitico;
    @NotNull @Min(value = 1)
    private long partidoId;

    public void setCargopolitico(Cargo cargopolitico) {
        this.cargopolitico = cargopolitico;
    }

    public void setPartido(long partidoId) {
        this.partidoId = partidoId;
    }

    public Associado atualizar(Long id, AssociadoRepository associadoRepository, PartidoRepository partidoRepository) {

        Associado associado = associadoRepository.findById(id);
        Partido partido = partidoRepository.findById(this.partidoId);
        associado.setCargopolitico(cargopolitico);
        associado.setPartido(partido);

        return associado;
    }

    public Associado remover(Long idAssociado, Long idPartido, AssociadoRepository associadoRepository, PartidoRepository partidoRepository) {
        Associado associado = associadoRepository.findById(idAssociado);
        Partido partido = partidoRepository.findById(idPartido);
        if (associado.getPartido() == partido){
            associado.setPartido(null);
        }
        return associado;

    }
}
