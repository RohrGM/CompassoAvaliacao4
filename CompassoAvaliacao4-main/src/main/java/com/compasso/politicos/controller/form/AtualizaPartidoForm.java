package com.compasso.politicos.controller.form;

import com.compasso.politicos.modelo.Ideologia;
import com.compasso.politicos.modelo.Partido;
import com.compasso.politicos.repository.PartidoRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AtualizaPartidoForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String sigla;
    @NotNull
    private Ideologia ideologia;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setIdeologia(Ideologia ideologia) {
        this.ideologia = ideologia;
    }

    public Partido atualizar(Long id, PartidoRepository partidoRepository) {

        Partido partido = partidoRepository.findById(id);
        partido.setNome(nome);
        partido.setSigla(sigla);
        partido.setIdeologia(ideologia);

        return partido;
    }
}
