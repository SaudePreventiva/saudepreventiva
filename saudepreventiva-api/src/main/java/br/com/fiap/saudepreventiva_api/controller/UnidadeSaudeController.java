package br.com.fiap.saudepreventiva_api.controller;

import br.com.fiap.saudepreventiva_api.model.UnidadeSaude;
import br.com.fiap.saudepreventiva_api.service.UnidadeSaudeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/unidades")
public class UnidadeSaudeController {

    private final UnidadeSaudeService service;

    @PostMapping
    public ResponseEntity<UnidadeSaude> criar(@RequestBody @Valid UnidadeSaude unidade) {
        UnidadeSaude salvo = service.criar(unidade);
        return ResponseEntity.created(URI.create("/api/v1/unidades/" + salvo.getId())).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<UnidadeSaude>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeSaude> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeSaude> atualizar(@PathVariable String id, @RequestBody @Valid UnidadeSaude dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
