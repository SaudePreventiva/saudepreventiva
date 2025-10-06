# Saúde Preventiva API

API REST desenvolvida em Spring Boot 3 + Java 17 como parte da disciplina de Java Advanced.
O projeto integra a **Plataforma de Saúde Preventiva**, que centraliza dados médicos de UBS, clínicas populares e postos de saúde, visando a prevenção de doenças e o acompanhamento de pacientes de forma digital.

---

## 🎯 Objetivos
- Implementar CRUDs REST (Create, Read, Update, Delete) para os principais domínios da plataforma:
Paciente, Atendimento, Alerta de Risco, Profissional de Saúde e Unidade de Saúde.
- Aplicar validações com Bean Validation e mapeamento JPA/Hibernate.
- Respeitar os princípios de POO, coesão, baixo acoplamento e REST Nível 1 (Richardson).
- Utilizar o banco H2 para persistência local (substituindo temporariamente o Oracle Database 23ai).
- Testar todos os endpoints via Insomnia e garantir a persistência e recuperação corretas dos dados.

---

## 🛠️ Tecnologias
- Java 17 (LTS)  
- Spring Boot 3.5.x
- H2 Database (desenvolvimento)  
- JPA / Hibernate  
- Bean Validation  
- Lombok  
- Maven  
- Insomnia (testes)  
- GitHub (versionamento)  

---

## 📌 Como rodar o projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/SaudePreventiva/saudepreventiva.git
   cd saudepreventiva-api
   ```

2. Compile e rode a aplicação:
   ```bash
   mvn spring-boot:run
   ```
3. Acesse no navegador ou cliente HTTP:
- API: http://localhost:8080
- Console H2: http://localhost:8080/h2-console
    - JDBC URL: jdbc:h2:file:./data/h2-saude
    - Usuário: sa
    - Senha: (vazio)

## 📚 Endpoints da Sprint 1 (Paciente)
Paciente
| Método | Endpoint                 | Descrição                 |
| ------ | ------------------------ | ------------------------- |
| POST   | `/api/v1/pacientes`      | Cadastrar paciente        |
| GET    | `/api/v1/pacientes`      | Listar todos os pacientes |
| GET    | `/api/v1/pacientes/{id}` | Buscar paciente por ID    |
| PUT    | `/api/v1/pacientes/{id}` | Atualizar paciente        |
| DELETE | `/api/v1/pacientes/{id}` | Excluir paciente          |

Atendimento
| Método | Endpoint                    | Descrição                    |
| ------ | --------------------------- | ---------------------------- |
| POST   | `/api/v1/atendimentos`      | Registrar atendimento        |
| GET    | `/api/v1/atendimentos`      | Listar todos os atendimentos |
| GET    | `/api/v1/atendimentos/{id}` | Buscar atendimento por ID    |
| PUT    | `/api/v1/atendimentos/{id}` | Atualizar atendimento        |
| DELETE | `/api/v1/atendimentos/{id}` | Excluir atendimento          |

Alerta de Risco
| Método | Endpoint               | Descrição            |
| ------ | ---------------------- | -------------------- |
| POST   | `/api/v1/alertas`      | Cadastrar alerta     |
| GET    | `/api/v1/alertas`      | Listar alertas       |
| GET    | `/api/v1/alertas/{id}` | Buscar alerta por ID |
| PUT    | `/api/v1/alertas/{id}` | Atualizar alerta     |
| DELETE | `/api/v1/alertas/{id}` | Excluir alerta       |

Profissional de Saúde
| Método | Endpoint                     | Descrição                  |
| ------ | ---------------------------- | -------------------------- |
| POST   | `/api/v1/profissionais`      | Cadastrar profissional     |
| GET    | `/api/v1/profissionais`      | Listar profissionais       |
| GET    | `/api/v1/profissionais/{id}` | Buscar profissional por ID |
| PUT    | `/api/v1/profissionais/{id}` | Atualizar profissional     |
| DELETE | `/api/v1/profissionais/{id}` | Excluir profissional       |

Unidade de Saúde
| Método | Endpoint                | Descrição                  |
| ------ | ----------------------- | -------------------------- |
| POST   | `/api/v1/unidades`      | Cadastrar unidade de saúde |
| GET    | `/api/v1/unidades`      | Listar unidades de saúde   |
| GET    | `/api/v1/unidades/{id}` | Buscar unidade por ID      |
| PUT    | `/api/v1/unidades/{id}` | Atualizar unidade de saúde |
| DELETE | `/api/v1/unidades/{id}` | Excluir unidade de saúde   |

## 📂 Testes no Insomnia

Todos os endpoints foram **testados individualmente** no Insomnia. Os testes contemplam **POST, GET, PUT e DELETE** para cada entidade.

Para importar:
1. Baixe o arquivo [Insomnia_2025-10-05.yaml](docs/Insomnia_2025-10-05.yaml) deste repositório.
2. Abra o Insomnia → `Application` → `Preferences` → `Data` → `Import Data`.
3. Selecione o arquivo `.yaml`.
4. As requisições de `POST`, `GET`, `PUT` e `DELETE` estarão prontas para uso.

## 📑 Documentação da API (Swagger/OpenAPI)
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI (JSON): http://localhost:8080/v3/api-docs
- OpenAPI (YAML): http://localhost:8080/v3/api-docs.yaml

## 👥 Equipe
- Maria Eduarda Fernandes Rocha - RM: 560657
- Victor de Carvalho Alves - RM: 560395
- Juan Pablo Rebelo Coelho - RM: 560445
