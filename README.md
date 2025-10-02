# Saúde Preventiva API

API REST desenvolvida em **Spring Boot 3 + Java 17** como parte da disciplina de **Java Advanced**.  
O projeto faz parte da **Plataforma de Saúde Preventiva**, que centraliza dados médicos para UBS, clínicas populares e postos de saúde.

---

## 🎯 Objetivos
- Implementação de um **CRUD REST** para o domínio **Paciente**.  
- Utilização de **JPA/Hibernate** com banco **H2** (substituindo Oracle temporariamente).  
- Aplicar validações com **Bean Validation**.  
- Respeitar os conceitos de **POO, coesão, desacoplamento** e **REST nível 1 (Richardson)**.  
- Garantir persistência e recuperação de dados testados via **Insomnia**.  

---

## 🛠️ Tecnologias
- Java 17 (LTS)  
- Spring Boot 3  
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
| Método | Endpoint                 | Descrição                 |
| ------ | ------------------------ | ------------------------- |
| POST   | `/api/v1/pacientes`      | Cadastrar paciente        |
| GET    | `/api/v1/pacientes`      | Listar todos os pacientes |
| GET    | `/api/v1/pacientes/{id}` | Buscar paciente por ID    |
| PUT    | `/api/v1/pacientes/{id}` | Atualizar paciente        |
| DELETE | `/api/v1/pacientes/{id}` | Excluir paciente          |

## 📂 Testes no Insomnia

Todos os endpoints foram testados no **Insomnia** e exportados para validação pelo professor.  

Para importar:
1. Baixe o arquivo [Insomnia_2025-10-02.yaml](docs/Insomnia_2025-10-02.yaml) deste repositório.
2. Abra o Insomnia → `Application` → `Preferences` → `Data` → `Import Data`.
3. Selecione o arquivo `.yaml`.
4. As requisições de `POST`, `GET`, `PUT` e `DELETE` estarão prontas para uso.


## 👥 Equipe
- Maria Eduarda Fernandes Rocha - RM: 560657
- Victor de Carvalho Alves - RM: 560395
- Juan Pablo Rebelo Coelho - RM: 560445
