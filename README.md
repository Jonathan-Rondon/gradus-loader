# Gradus-Loader 🚀

`Gradus-Loader` é uma aplicação de linha de comando desenvolvida em Java, responsável por popular um banco de dados com informações de alunos a partir de um arquivo de texto. Este projeto faz parte de um sistema maior, o "Gradus", e serve como o mecanismo de carga inicial de dados (ETL - Extract, Transform, Load).

## Índice

- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar](#como-executar)
- [Estrutura do Arquivo de Dados](#estrutura-do-arquivo-de-dados)
- [To-Do List (Próximos Passos)](#to-do-list-próximos-passos)
- [Autor](#autor)

## Funcionalidades

-   **Leitura de Arquivo:** Lê um arquivo de texto (`.csv` ou `.txt`) contendo uma lista de alunos.
-   **Validação de Dados:** Verifica se o banco de dados já contém dados para evitar duplicações a cada execução.
-   **Persistência de Dados:** Insere os registros de alunos em um banco de dados PostgreSQL usando JPA/Hibernate.
-   **Execução via Linha de Comando:** Projetado para ser executado como um processo único para a carga de dados.

## Tecnologias Utilizadas

-   **Java 17**
-   **Maven** (ou Gradle) - Gerenciador de dependências
-   **Spring Data JPA / Hibernate** - Para persistência de dados
-   **PostgreSQL** - Banco de dados relacional
-   **Docker** - Para executar o banco de dados em um contêiner

## Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas em sua máquina:
-   [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior
-   [Apache Maven](https://maven.apache.org/download.cgi) 3.8+
-   [Docker](https://www.docker.com/products/docker-desktop/)
-   [Git](https://git-scm.com/)

## Como Executar

Siga os passos abaixo para configurar e executar o projeto.

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/gradus-loader.git
cd gradus-loader
```

### 2. Configurar o Banco de Dados

Esta aplicação foi projetada para se conectar a um banco de dados PostgreSQL executado via Docker.

**Observação:** O banco de dados deve ser iniciado a partir do projeto da API principal (`gradus-api` ou `campus-core-api`), que contém o arquivo `docker-compose.yml`. Certifique-se de que o contêiner do banco de dados esteja em execução antes de prosseguir.

Se precisar rodar o banco de forma independente, use o seguinte comando em um terminal:
```bash
docker run --name gradus-db -e POSTGRES_USER=seu-usuario -e POSTGRES_PASSWORD=sua-senha -e POSTGRES_DB=gradus_db -p 5432:5432 -d postgres
```

### 3. Configurar a Conexão

Verifique o arquivo `src/main/resources/application.properties` e garanta que as credenciais do banco de dados estão corretas:

```properties
# Exemplo de configuração
spring.datasource.url=jdbc:postgresql://localhost:5432/gradus_db
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
```

### 4. Compilar o Projeto

Use o Maven para compilar o projeto e gerar o arquivo `.jar`.

```bash
mvn clean package
```

### 5. Executar a Aplicação

Após a compilação, execute o arquivo JAR gerado a partir da linha de comando. Você precisará fornecer o caminho para o arquivo de dados como um argumento.

```bash
java -jar target/gradus-loader-0.0.1-SNAPSHOT.jar /caminho/para/seu/arquivo_de_alunos.csv
```
**Exemplo:**
```bash
java -jar target/gradus-loader-0.0.1-SNAPSHOT.jar C:/Users/Jonathan/Downloads/alunos.csv
```
A aplicação irá ler o arquivo, processar os dados e inseri-los no banco. O log da operação será exibido no console.

## Estrutura do Arquivo de Dados

A aplicação espera um arquivo de texto (ex: `.csv`) com os dados separados por vírgula (`,`), seguindo a ordem:

`campus,curso,nome_estudante,idade,email_institucional,periodo_entrada`

**Exemplo de conteúdo (`alunos.csv`):**
```csv
Campus A,Engenharia de Software,João Silva,21,joao.silva@campus.edu,2022.1
Campus B,Ciência da Computação,Maria Oliveira,22,maria.oliveira@campus.edu,2021.2
```

## To-Do List (Próximos Passos)

-   [ ] Implementar um tratamento de erros mais robusto para linhas mal formatadas no arquivo de entrada.
-   [ ] Adicionar testes unitários para a lógica de parsing do arquivo.
-   [ ] Permitir a configuração do delimitador (ex: `,` ou `;`) via argumento de linha de comando.
-   [ ] Criar um log de saída com o resumo da operação (ex: "X registros lidos, Y inseridos, Z com erro").

## Autor

**Jonathan Rondon**
