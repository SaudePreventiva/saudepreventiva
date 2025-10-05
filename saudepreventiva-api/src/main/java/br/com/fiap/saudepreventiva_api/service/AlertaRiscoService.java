package br.com.fiap.saudepreventiva_api.service;

import br.com.fiap.saudepreventiva_api.model.AlertaRisco;
import br.com.fiap.saudepreventiva_api.model.Atendimento;
import br.com.fiap.saudepreventiva_api.model.Paciente;
import br.com.fiap.saudepreventiva_api.repository.AlertaRiscoRepository;
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
public class AlertaRiscoService {

    private final AlertaRiscoRepository repo;
    private final PacienteRepository pacienteRepo;
    private final AtendimentoRepository atendimentoRepo;

    @Transactional
    public AlertaRisco criar(@Valid AlertaRisco alerta) {
        // 🔹 Valida paciente obrigatório
        Paciente p = pacienteRepo.findById(alerta.getPaciente().getId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Paciente não encontrado"));
        alerta.setPaciente(p);

        // 🔹 Valida atendimento (opcional)
        if (alerta.getAtendimento() != null && alerta.getAtendimento().getId() != null) {
            Atendimento a = atendimentoRepo.findById(alerta.getAtendimento().getId())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Atendimento não encontrado"));
            alerta.setAtendimento(a);
        } else {
            alerta.setAtendimento(null);
        }

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

        if (dados.getPaciente() != null && dados.getPaciente().getId() != null) {
            Paciente p = pacienteRepo.findById(dados.getPaciente().getId())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Paciente não encontrado"));
            existente.setPaciente(p);
        }

        if (dados.getAtendimento() != null && dados.getAtendimento().getId() != null) {
            Atendimento a = atendimentoRepo.findById(dados.getAtendimento().getId())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Atendimento não encontrado"));
            existente.setAtendimento(a);
        } else {
            existente.setAtendimento(null);
        }

        return repo.save(existente);
    }

    @Transactional
    public void deletar(String id) {
        repo.delete(buscarPorId(id));
    }
}
