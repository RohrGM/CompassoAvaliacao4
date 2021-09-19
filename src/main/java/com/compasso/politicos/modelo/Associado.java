package com.compasso.politicos.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Associado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Cargo cargopolitico;
    private LocalDate datanascimento;
    @ManyToOne
    private Partido partido;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Associado(String nome, Cargo cargopolitico, LocalDate datanascimento, Partido partido, Sexo sexo) {
        this.nome = nome;
        this.cargopolitico = cargopolitico;
        this.datanascimento = datanascimento;
        this.partido = partido;
        this.sexo = sexo;
    }

    public Associado() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargopolitico() {
        return cargopolitico;
    }

    public void setCargopolitico(Cargo cargopolitico) {
        this.cargopolitico = cargopolitico;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
