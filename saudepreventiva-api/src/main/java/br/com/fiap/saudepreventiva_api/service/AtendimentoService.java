package br.com.fiap.saudepreventiva_api.service;

import br.com.fiap.saudepreventiva_api.model.Atendimento;
import br.com.fiap.saudepreventiva_api.model.Paciente;
import br.com.fiap.saudepreventiva_api.repository.AtendimentoRepository;
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
public class AtendimentoService {

    private final AtendimentoRepository repo;
    private final PacienteRepository pacienteRepo;

    @Transactional
    public Atendimento criar(@Valid Atendimento atendimento) {
        Paciente paciente = pacienteRepo.findById(atendimento.getPaciente().getId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Paciente não encontrado"));
        atendimento.setPaciente(paciente);
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
    public Atendimento atualizar(String id, @Valid Atendimento novo) {
        Atendimento existente = buscarPorId(id);

        existente.setTipo(novo.getTipo());
        existente.setDataAtendimento(novo.getDataAtendimento());
        existente.setObservacoes(novo.getObservacoes());

        if (novo.getPaciente() != null && novo.getPaciente().getId() != null) {
            Paciente paciente = pacienteRepo.findById(novo.getPaciente().getId())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Paciente não encontrado"));
            existente.setPaciente(paciente);
        }

        return repo.save(existente);
    }

    @Transactional
    public void deletar(String id) {
        repo.delete(buscarPorId(id));
    }
}
