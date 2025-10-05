package br.com.fiap.saudepreventiva_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "UNIDADES_SAUDE")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class UnidadeSaude {

    @Id
    @Column(length = 36)
    private String id;

    @NotBlank
    @Size(min = 3, max = 120)
    @Column(nullable = false, length = 120)
    private String nome;

    @NotBlank
    @Size(min = 3, max = 120)
    @Column(nullable = false, length = 120)
    private String endereco;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String tipo; // UBS, CLINICA_POPULAR, POSTO_SAUDE

    @PrePersist
    public void gerarId() {
        if (this.id == null) this.id = UUID.randomUUID().toString();
    }
}
