package com.compasso.politicos.controller.form;

import com.compasso.politicos.modelo.Associado;
import com.compasso.politicos.modelo.Cargo;
import com.compasso.politicos.modelo.Partido;
import com.compasso.politicos.modelo.Sexo;
import com.compasso.politicos.repository.PartidoRepository;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class AssociadoForm {

    @NotBlank
    private String nome;
    @NotNull
    private Cargo cargopolitico;
    @NotNull @Past
    private LocalDate datanascimento;
    @NotBlank
    private String nomePartido;
    @NotNull
    private Sexo sexo;

    public Associado converter(AssociadoForm associadoForm, PartidoRepository partidoRepository) {
        Partido partido = partidoRepository.findByNome(nomePartido);

        return new Associado(nome, cargopolitico, datanascimento, partido, sexo);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargopolitico(Cargo cargopolitico) {
        this.cargopolitico = cargopolitico;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

    public void setPartido(String nomePartido) {
        this.nomePartido = nomePartido;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
