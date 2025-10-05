package br.com.fiap.saudepreventiva_api.controller;

import br.com.fiap.saudepreventiva_api.model.AlertaRisco;
import br.com.fiap.saudepreventiva_api.service.AlertaRiscoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/alertas")
public class AlertaRiscoController {

    private final AlertaRiscoService service;

    @PostMapping
    public ResponseEntity<AlertaRisco> criar(@RequestBody @Valid AlertaRisco alerta) {
        AlertaRisco salvo = service.criar(alerta);
        return ResponseEntity.created(URI.create("/api/v1/alertas/" + salvo.getId())).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<AlertaRisco>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaRisco> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertaRisco> atualizar(@PathVariable String id, @RequestBody @Valid AlertaRisco dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
