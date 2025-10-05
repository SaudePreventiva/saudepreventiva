package br.com.fiap.saudepreventiva_api.service;

import br.com.fiap.saudepreventiva_api.model.Paciente;
import br.com.fiap.saudepreventiva_api.repository.PacienteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repo;

    @Transactional
    public Paciente criar(@Valid Paciente paciente) {
        return repo.save(paciente);
    }

    @Transactional(readOnly = true)
    public List<Paciente> listar() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Paciente buscarPorId(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Paciente não encontrado"));
    }

    @Transactional
    public Paciente atualizar(String id, @Valid Paciente dados) {
        Paciente existente = buscarPorId(id);

        existente.setNome(dados.getNome());
        existente.setCpf(dados.getCpf());
        existente.setDataNascimento(dados.getDataNascimento());
        existente.setEmail(dados.getEmail());
        existente.setTelefone(dados.getTelefone());

        return repo.save(existente);
    }

    @Transactional
    public void deletar(String id) {
        repo.delete(buscarPorId(id));
    }
}
