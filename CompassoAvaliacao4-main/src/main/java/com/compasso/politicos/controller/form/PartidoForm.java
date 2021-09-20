package com.compasso.politicos.controller.form;

import com.compasso.politicos.modelo.Ideologia;
import com.compasso.politicos.modelo.Partido;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class PartidoForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String sigla;
    @NotNull
    private Ideologia ideologia;
    @NotNull @PastOrPresent
    private LocalDate dataFundacao;

    public Partido converter(PartidoForm partidoForm) {
        return new Partido(nome, sigla, ideologia, dataFundacao);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public void setIdeologia(Ideologia ideologia) {
        this.ideologia = ideologia;
    }
    public void setDatafundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
