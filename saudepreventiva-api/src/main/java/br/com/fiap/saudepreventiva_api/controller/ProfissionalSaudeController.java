package br.com.fiap.saudepreventiva_api.controller;

import br.com.fiap.saudepreventiva_api.model.ProfissionalSaude;
import br.com.fiap.saudepreventiva_api.service.ProfissionalSaudeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profissionais")
public class ProfissionalSaudeController {

    private final ProfissionalSaudeService service;

    @PostMapping
    public ResponseEntity<ProfissionalSaude> criar(@RequestBody @Valid ProfissionalSaude profissional) {
        ProfissionalSaude salvo = service.criar(profissional);
        return ResponseEntity.created(URI.create("/api/v1/profissionais/" + salvo.getId())).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalSaude>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalSaude> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalSaude> atualizar(@PathVariable String id, @RequestBody @Valid ProfissionalSaude dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
