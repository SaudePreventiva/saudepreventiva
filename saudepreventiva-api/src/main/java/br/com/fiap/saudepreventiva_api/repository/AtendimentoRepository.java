package br.com.fiap.saudepreventiva_api.repository;

import br.com.fiap.saudepreventiva_api.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, String> { }
