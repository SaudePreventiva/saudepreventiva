package br.com.fiap.saudepreventiva_api.controller;

import br.com.fiap.saudepreventiva_api.model.Atendimento;
import br.com.fiap.saudepreventiva_api.service.AtendimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/atendimentos")
public class AtendimentoController {

    private final AtendimentoService service;

    @PostMapping
    public ResponseEntity<Atendimento> criar(@RequestBody @Valid Atendimento atendimento) {
        Atendimento salvo = service.criar(atendimento);
        return ResponseEntity.created(URI.create("/api/v1/atendimentos/" + salvo.getId())).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Atendimento>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> atualizar(@PathVariable String id, @RequestBody @Valid Atendimento novo) {
        return ResponseEntity.ok(service.atualizar(id, novo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
