package br.com.fiap.saudepreventiva_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ATENDIMENTOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Atendimento {

    @Id
    @Column(length = 36)
    private String id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String tipo; // Ex: CONSULTA, EXAME, VACINA

    @NotNull
    private LocalDate dataAtendimento;

    @Size(max = 500)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID", nullable = false)
    private Paciente paciente;

    @PrePersist
    public void gerarId() {
        if (this.id == null) this.id = UUID.randomUUID().toString();
    }
}
