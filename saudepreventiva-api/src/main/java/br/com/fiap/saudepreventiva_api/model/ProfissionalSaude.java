package br.com.fiap.saudepreventiva_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "PROFISSIONAIS_SAUDE")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProfissionalSaude {

    @Id
    @Column(length = 36)
    private String id;

    @NotBlank
    @Size(min = 3, max = 120)
    @Column(nullable = false, length = 120)
    private String nome;

    @NotBlank
    @Column(unique = true, length = 20, nullable = false)
    private String registro; // Ex: CRM12345, COREN6789

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String cargo; // Médico, Enfermeiro, Técnico, etc.

    @PrePersist
    public void gerarId() {
        if (this.id == null) this.id = UUID.randomUUID().toString();
    }
}
