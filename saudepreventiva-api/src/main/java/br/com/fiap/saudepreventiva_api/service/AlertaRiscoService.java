package br.com.fiap.saudepreventiva_api.service;

import br.com.fiap.saudepreventiva_api.model.AlertaRisco;
import br.com.fiap.saudepreventiva_api.repository.AlertaRiscoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AlertaRiscoService {

    private final AlertaRiscoRepository repo;

    @Transactional
    public AlertaRisco criar(@Valid AlertaRisco alerta) {
        return repo.save(alerta);
    }

    @Transactional(readOnly = true)
    public List<AlertaRisco> listar() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public AlertaRisco buscarPorId(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Alerta não encontrado"));
    }

    @Transactional
    public AlertaRisco atualizar(String id, @Valid AlertaRisco dados) {
        AlertaRisco existente = buscarPorId(id);

        existente.setSeveridade(dados.getSeveridade());
        existente.setOrigem(dados.getOrigem());
        existente.setMensagem(dados.getMensagem());
        existente.setStatus(dados.getStatus());

        return repo.save(existente);
    }

    @Transactional
    public void deletar(String id) {
        repo.delete(buscarPorId(id));
    }
}
