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

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID", nullable = false)
    @NotNull
    private Paciente paciente;

    // Opcional: um alerta pode estar vinculado a um atendimento específico
    @ManyToOne
    @JoinColumn(name = "ATENDIMENTO_ID")
    private Atendimento atendimento;

    @NotBlank
    @Size(max = 10)
    @Column(length = 10, nullable = false)
    private String severidade; // BAIXA, MEDIA, ALTA, CRITICA

    @NotBlank
    @Size(max = 20)
    @Column(length = 20, nullable = false)
    private String origem; // IA_ORACLE, PROFISSIONAL

    @NotBlank
    @Size(min = 5, max = 500)
    @Column(length = 500, nullable = false)
    private String mensagem;

    @NotBlank
    @Size(max = 15)
    @Column(length = 15, nullable = false)
    private String status; // ABERTO, EM_ANDAMENTO, RESOLVIDO

    @Column(name = "CRIADO_EM", nullable = false)
    private LocalDateTime criadoEm;

    @PrePersist
    public void prePersist() {
        if (this.id == null) this.id = UUID.randomUUID().toString();
        if (this.criadoEm == null) this.criadoEm = LocalDateTime.now();
    }
}
