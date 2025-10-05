package br.com.fiap.saudepreventiva_api.service;

import br.com.fiap.saudepreventiva_api.model.Atendimento;
import br.com.fiap.saudepreventiva_api.repository.AtendimentoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository repo;

    @Transactional
    public Atendimento criar(@Valid Atendimento atendimento) {
        return repo.save(atendimento);
    }

    @Transactional(readOnly = true)
    public List<Atendimento> listar() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Atendimento buscarPorId(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Atendimento não encontrado"));
    }

    @Transactional
    public Atendimento atualizar(String id, @Valid Atendimento dados) {
        Atendimento existente = buscarPorId(id);

        existente.setTipo(dados.getTipo());
        existente.setDataAtendimento(dados.getDataAtendimento());
        existente.setObservacoes(dados.getObservacoes());

        return repo.save(existente);
    }

    @Transactional
    public void deletar(String id) {
        repo.delete(buscarPorId(id));
    }
}
