package com.compasso.politicos.controller.dto;

import com.compasso.politicos.modelo.Associado;
import com.compasso.politicos.modelo.Cargo;
import com.compasso.politicos.modelo.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AssociadoDto {

    private long id;
    private String nome;
    private Cargo cargopolitico;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate datanascimento;
    private PartidoDto partido;
    private Sexo sexo;

    public AssociadoDto(Associado associado) {
        this.id = associado.getId();
        this.nome = associado.getNome();
        this.cargopolitico = associado.getCargopolitico();
        this.datanascimento = associado.getDatanascimento();
        try{this.partido = new PartidoDto(associado.getPartido());}catch (NullPointerException e){};
        this.sexo = associado.getSexo();
    }

    public static List<AssociadoDto> converter(List<Associado> associados) {
        return associados.stream().map(AssociadoDto::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargopolitico() {
        return cargopolitico;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public PartidoDto getPartido() {return partido;}

    public Sexo getSexo() {
        return sexo;
    }
}
