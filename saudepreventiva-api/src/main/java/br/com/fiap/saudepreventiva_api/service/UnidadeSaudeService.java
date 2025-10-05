package br.com.fiap.saudepreventiva_api.service;

import br.com.fiap.saudepreventiva_api.model.UnidadeSaude;
import br.com.fiap.saudepreventiva_api.repository.UnidadeSaudeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UnidadeSaudeService {

    private final UnidadeSaudeRepository repo;

    @Transactional
    public UnidadeSaude criar(@Valid UnidadeSaude unidade) {
        return repo.save(unidade);
    }

    @Transactional(readOnly = true)
    public List<UnidadeSaude> listar() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public UnidadeSaude buscarPorId(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unidade de saúde não encontrada"));
    }

    @Transactional
    public UnidadeSaude atualizar(String id, @Valid UnidadeSaude dados) {
        UnidadeSaude existente = buscarPorId(id);

        existente.setNome(dados.getNome());
        existente.setEndereco(dados.getEndereco());
        existente.setTipo(dados.getTipo());

        return repo.save(existente);
    }

    @Transactional
    public void deletar(String id) {
        repo.delete(buscarPorId(id));
    }
}
