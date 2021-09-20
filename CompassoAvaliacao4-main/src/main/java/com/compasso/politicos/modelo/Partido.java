package com.compasso.politicos.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Partido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String sigla;
    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;
    @Column(name = "datafundacao")
    private LocalDate dataFundacao;

    public Partido(String nome, String sigla, Ideologia ideologia, LocalDate dataFundacao) {
        this.nome = nome;
        this.sigla = sigla;
        this.ideologia = ideologia;
        this.dataFundacao = dataFundacao;
    }

    public Partido() {}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Ideologia getIdeologia() {
        return ideologia;
    }

    public void setIdeologia(Ideologia ideologia) {
        this.ideologia = ideologia;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
