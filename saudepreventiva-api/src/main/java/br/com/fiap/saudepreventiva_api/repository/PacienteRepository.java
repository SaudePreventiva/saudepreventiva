package br.com.fiap.saudepreventiva_api.repository;

import br.com.fiap.saudepreventiva_api.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
    boolean existsByCpf(String cpf);
}
