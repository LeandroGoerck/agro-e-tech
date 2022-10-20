# Agro-e-Tech

A aplicação deve ter as seguintes funcionalidades:
1. Isle
  - [x] Listar as ilhas
  - [x] Adicionar uma nova ilha com o seu status true ou false
  - [x] Atualizar uma ilha
  - [x] Excluir uma ilha

2. Measurements
  - [x] Listar as medidas
  - [x] Criar uma nova medida para uma ilha

---

# Sumário

- [Habilidades desenvolvidas](#habilidades-desenvolvidas)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Organização e Estruturação do Projeto](#organização-e-estruturação-do-projeto)
- [Pré-requisitos](#pré-requisitos)
  - [Ferramentas necessárias](#ferramentas-necessárias)
  - [Rodando no servidor local](#rodando-no-servidor-local)
  - [Rodando os testes](#rodando-os-testes)

  ---

# Habilidades desenvolvidas

- A API foi desenvolvida com a linguagem Java e com Quarkus
- Os testes foram criados com JUnit e QuarkusTest.
- O banco de dados utilizado foi o mongodb com conexão via Panache.
- Teste das rotas utilizando Postman
- Criação, leitura, edição e exclusão (CRUD)

---

# Tecnologias utilizadas

- [Java](https://www.java.com/pt-BR/)
- [Quarkus](https://quarkus.io/)
- [JUnit](https://junit.org/junit5/)
- [MongoDB](https://www.mongodb.com/)
- [Docker](https://www.docker.com/)
- [Postman](https://www.postman.com/)

---

# Organização e Estruturação do Projeto

O projeto está organizado e estruturado da seguinte maneira:
```
├── agro-e-tech
├── docker-compose.yml
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── docker
│   │   │   ├── docker-compose.yml
│   │   │   ├── Dockerfile.jvm
│   │   │   ├── Dockerfile.legacy-jar
│   │   │   ├── Dockerfile.native
│   │   │   └── Dockerfile.native-micro
│   │   ├── java
│   │   │   └── agro
│   │   │       └── tech
│   │   │           ├── exceptions
│   │   │           │   └── NotFoundException.java
│   │   │           ├── GreetingResource.java
│   │   │           ├── model
│   │   │           │   ├── Isle.java
│   │   │           │   └── Measurements.java
│   │   │           ├── repository
│   │   │           │   ├── IsleRepository.java
│   │   │           │   └── MeasurementsRepository.java
│   │   │           ├── resource
│   │   │           │   ├── IsleResource.java
│   │   │           │   └── MeasurementsResource.java
│   │   │           └── service
│   │   │               ├── IsleService.java
│   │   │               └── MeasurementsService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── META-INF
│   │           └── resources
│   │               └── index.html
│   └── test
│       └── java
│           └── agro
│               └── tech
│                   ├── GreetingResourceIT.java
│                   ├── GreetingResourceTest.java
│                   ├── resource
│                   │   ├── IsleResourceTest.java
│                   │   └── MeasurementResourceTest.java
│                   └── service
│                       ├── IsleServiceTest.java
│                       └── MeasurementServiceTest.java
├── structure.txt
└── target
    ├── build-metrics.json
    ├── classes
    │   ├── agro
    │   │   └── tech
    │   │       ├── exceptions
    │   │       │   └── NotFoundException.class
    │   │       ├── GreetingResource.class
    │   │       ├── model
    │   │       │   ├── Isle.class
    │   │       │   └── Measurements.class
    │   │       ├── repository
    │   │       │   ├── IsleRepository.class
    │   │       │   └── MeasurementsRepository.class
    │   │       ├── resource
    │   │       │   ├── IsleResource.class
    │   │       │   └── MeasurementsResource.class
    │   │       └── service
    │   │           ├── IsleService.class
    │   │           └── MeasurementsService.class
    │   ├── application.properties
    │   └── META-INF
    │       ├── panache-archive.marker
    │       └── resources
    │           └── index.html
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    ├── maven-status
    │   └── maven-compiler-plugin
    │       ├── compile
    │       │   └── null
    │       │       ├── createdFiles.lst
    │       │       └── inputFiles.lst
    │       └── testCompile
    │           └── null
    │               ├── createdFiles.lst
    │               └── inputFiles.lst
    ├── quarkus
    │   └── bootstrap
    └── test-classes
        ├── agro
        │   └── tech
        │       ├── GreetingResourceIT.class
        │       └── GreetingResourceTest.class
        └── META-INF
            └── panache-archive.marker
```
---

# Pré-requisitos

## Ferramentas necessárias

Para rodar o projeto, você vai precisar instalar as seguintes ferramentas:
 - [Git](https://git-scm.com);
 - [Java](https://www.java.com/pt-BR/);
 - [Docker](https://www.docker.com/)
 - Um editor para trabalhar com o código como [VSCode](https://code.visualstudio.com/) ou outro de sua preferência;

---

## Rodando no servidor local

 - Clone do Projeto e realize os comandos necessários

    - Clone este repositório
    ```bash
    git clone https://github.com/LeandroGoerck/agro-e-tech
    ```

    - Acesse a pasta do projeto no terminal/cmd
    ```bash
    cd agro-e-tech
    ```

    - Rode o quarkus para o modo de produção
    ```bash
    quarkus dev
    ```

    - Suba os containers docker
    ```bash
    cd src/main/docker && docker-compose up
    ```
  
  ---

## Rodando os testes

  - Para rodar os testes utilize o seguinte comando

  ```bash
    mvn test
  ```

#Autores
@nathaliamiranda
@LeandroGoerck
@prgalhardo