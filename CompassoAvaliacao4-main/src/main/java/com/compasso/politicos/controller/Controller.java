package com.compasso.politicos.controller;

import com.compasso.politicos.controller.dto.AssociadoDto;
import com.compasso.politicos.controller.dto.PartidoDto;

import com.compasso.politicos.controller.form.*;
import com.compasso.politicos.modelo.Associado;
import com.compasso.politicos.modelo.Partido;
import com.compasso.politicos.repository.AssociadoRepository;
import com.compasso.politicos.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;


    @GetMapping("/partidos")
    public ResponseEntity<?> listaPartidos (BuscaPartidoForm form, Pageable pageable){

        List<Partido> partidos = partidoRepository.findAll(form.toSpec(), pageable).getContent();
        if(partidos.size()> 0) {
            return ResponseEntity.ok(PartidoDto.converter(partidos));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/partidos/{id}")
    public ResponseEntity<?> listaPartidoPorId (@PathVariable Long id){

        Optional<Partido> optional = Optional.ofNullable(partidoRepository.findById(id));

        if(optional.isPresent()) {
            return ResponseEntity.ok(new PartidoDto(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/partidos/{id}/associados")
    public ResponseEntity<?> listaAssociadosPorPartidoId (@PathVariable Long id){

        List<Associado> associados = associadoRepository.findByPartidoId(id);

        if(associados.size()> 0) {
            return ResponseEntity.ok(AssociadoDto.converter(associados));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/partidos/{id}")
    @Transactional
    public ResponseEntity<?> removerPartidoPorId(@PathVariable Long id) {

        Optional<Partido> optional = Optional.ofNullable(partidoRepository.findById(id));

        if(optional.isPresent()) {
            partidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/partidos")
    public ResponseEntity<PartidoDto> cadastrarPartido(@RequestBody @Valid PartidoForm partidoForm, UriComponentsBuilder uriBuilder) {

        Partido partido = partidoForm.converter(partidoForm);
        partidoRepository.save(partido);

        URI uri = uriBuilder.path("/api/partidos/{id}").buildAndExpand(partido.getId()).toUri();

        return ResponseEntity.created(uri).body(new PartidoDto(partido));
    }

    @PutMapping("/partidos/{id}")
    @Transactional
    public ResponseEntity<PartidoDto> atualizarPartidoPorId(@PathVariable Long id, @RequestBody @Valid AtualizaPartidoForm form) {
        Optional<Partido> optional = Optional.ofNullable(partidoRepository.findById(id));

        if(optional.isPresent()) {
            Partido partido = form.atualizar(id, partidoRepository);
            return ResponseEntity.ok(new PartidoDto(partido));
        }
        return ResponseEntity.notFound().build();
    }

    //#######################################__ASSOCIADOS__######################################################

    @GetMapping("/associados/{id}")
    public ResponseEntity<?> listaAssociadoPorId (@PathVariable Long id){

        Optional<Associado> optional = Optional.ofNullable(associadoRepository.findById(id));

        if(optional.isPresent()) {
            return ResponseEntity.ok(new AssociadoDto(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/associados")
    public ResponseEntity<?> listaAssociados (BuscaAssociadoForm form, Pageable pageable){

        List<Associado> associados = associadoRepository.findAll(form.toSpec(), pageable).getContent();
        if(associados.size()> 0) {
            return ResponseEntity.ok(AssociadoDto.converter(associados));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/associados")
    public ResponseEntity<AssociadoDto> cadastrarAssociado (@RequestBody @Valid AssociadoForm associadoForm, UriComponentsBuilder uriBuilder) {

        Associado associado = associadoForm.converter(associadoForm, partidoRepository);
        associadoRepository.save(associado);

        URI uri = uriBuilder.path("/api/associados/{id}").buildAndExpand(associado.getId()).toUri();

        return ResponseEntity.created(uri).body(new AssociadoDto(associado));
    }

    @DeleteMapping("/associados/{id}")
    @Transactional
    public ResponseEntity<?> removerAssociadoPorId(@PathVariable Long id) {

        Optional<Associado> optional = Optional.ofNullable(associadoRepository.findById(id));

        if(optional.isPresent()) {
            associadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/associados/{id}")
    @Transactional
    public ResponseEntity<AssociadoDto> atualizarAssociadoPorId(@PathVariable Long id, @RequestBody @Valid AtualizaAssociadoForm form) {
        Optional<Associado> optional = Optional.ofNullable(associadoRepository.findById(id));

        if(optional.isPresent()) {
            Associado associado = form.atualizar(id, associadoRepository, partidoRepository);
            return ResponseEntity.ok(new AssociadoDto(associado));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/associados/partidos")
    @Transactional
    public ResponseEntity<AssociadoDto> atualizarAssociadoPartido(@RequestBody @Valid VinculaAssociadoPartidoForm form) {

        Optional<Associado> optionalAssociado = Optional.ofNullable(associadoRepository.findById(form.getIdAssociado()));
        Optional<Partido> optionalPartido = Optional.ofNullable(partidoRepository.findById(form.getIdPartido()));

        if(optionalAssociado.isPresent() && optionalPartido.isPresent()) {
            Associado associado = form.atualizar(associadoRepository, partidoRepository);
            return ResponseEntity.ok(new AssociadoDto(associado));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/associados/{idAssociado}/partidos/{idPartido}")
    @Transactional
    public ResponseEntity<AssociadoDto> removeAssociadoPartido(@PathVariable Long idAssociado, @PathVariable Long idPartido) {
        Optional<Associado> optionalAssociado = Optional.ofNullable(associadoRepository.findById(idAssociado));
        Optional<Partido> optionalPartido = Optional.ofNullable(partidoRepository.findById(idPartido));

        if(optionalAssociado.isPresent() && optionalPartido.isPresent()) {

            Associado associado = optionalAssociado.get();
            if (associado.getPartido() == optionalPartido.get()){
                associado.setPartido(null);
                return ResponseEntity.ok(new AssociadoDto(associado));
            }else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
