package br.com.fiap.saudepreventiva_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ALERTAS_RISCO")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class AlertaRisco {

    @Id
    @Column(length = 36)
    private String id;

    @NotBlank
    @Size(max = 10)
    private String severidade; // BAIXA, MEDIA, ALTA, CRITICA

    @NotBlank
    @Size(max = 20)
    private String origem; // IA_ORACLE, PROFISSIONAL

    @NotBlank
    @Size(min = 5, max = 500)
    private String mensagem;

    @NotBlank
    @Size(max = 15)
    private String status; // ABERTO, RESOLVIDO, etc.

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @PrePersist
    public void prePersist() {
        if (this.id == null) this.id = UUID.randomUUID().toString();
        if (this.criadoEm == null) this.criadoEm = LocalDateTime.now();
    }
}
