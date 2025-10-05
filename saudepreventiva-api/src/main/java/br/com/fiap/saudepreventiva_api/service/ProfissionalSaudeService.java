package br.com.fiap.saudepreventiva_api.service;

import br.com.fiap.saudepreventiva_api.model.ProfissionalSaude;
import br.com.fiap.saudepreventiva_api.repository.ProfissionalSaudeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProfissionalSaudeService {

    private final ProfissionalSaudeRepository repo;

    @Transactional
    public ProfissionalSaude criar(@Valid ProfissionalSaude profissional) {
        return repo.save(profissional);
    }

    @Transactional(readOnly = true)
    public List<ProfissionalSaude> listar() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public ProfissionalSaude buscarPorId(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Profissional não encontrado"));
    }

    @Transactional
    public ProfissionalSaude atualizar(String id, @Valid ProfissionalSaude dados) {
        ProfissionalSaude existente = buscarPorId(id);

        existente.setNome(dados.getNome());
        existente.setRegistro(dados.getRegistro());
        existente.setCargo(dados.getCargo());

        return repo.save(existente);
    }

    @Transactional
    public void deletar(String id) {
        repo.delete(buscarPorId(id));
    }
}
