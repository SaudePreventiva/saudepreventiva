package br.com.fiap.saudepreventiva_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "PACIENTES")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Paciente {

    @Id
    @Column(name = "ID", length = 36)
    private String id;

    @NotBlank
    @Size(min = 3, max = 120)
    @Column(name = "NOME", nullable = false, length = 120)
    private String nome;

    @NotBlank
    @Pattern(regexp = "\\d{11}")
    @Column(name = "CPF", nullable = false, unique = true, length = 11)
    private String cpf;

    @Past
    @Column(name = "DATA_NASC")
    private LocalDate dataNascimento;

    @Email
    @Column(name = "EMAIL", length = 120)
    private String email;

    @Column(name = "TELEFONE", length = 20)
    private String telefone;

    @PrePersist
    public void gerarId() {
        if (this.id == null) this.id = UUID.randomUUID().toString();
    }
}
