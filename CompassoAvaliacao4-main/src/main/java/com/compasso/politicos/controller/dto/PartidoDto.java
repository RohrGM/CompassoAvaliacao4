package com.compasso.politicos.controller.dto;

import com.compasso.politicos.modelo.Ideologia;
import com.compasso.politicos.modelo.Partido;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PartidoDto {

    private long id;
    private String nome;
    private String sigla;
    private Ideologia ideologia;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataFundacao;

    public PartidoDto(Partido partido) {
        this.id = partido.getId();
        this.nome = partido.getNome();
        this.sigla = partido.getSigla();
        this.ideologia = partido.getIdeologia();
        this.dataFundacao = partido.getDataFundacao();
    }

    public static List<PartidoDto> converter(List<Partido> partidos) {
        return partidos.stream().map(PartidoDto::new).collect(Collectors.toList());
    }

    public long getId() {return id;}

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public Ideologia getIdeologia() {
        return ideologia;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
}
