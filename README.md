# Repositório com Interfaces e Múltiplas Implementações em Java

Este projeto foi desenvolvido como parte da Atividade 1-2 da disciplina IMD0040 - LINGUAGEM DE PROGRAMAÇÃO II, focado em exercitar os conceitos de **Interfaces**, **Múltipla Implementação** e **Modularização** (uso de pacotes), utilizando apenas arrays nativos de Java e sem o uso de **Generics** ou **Collections**.

---

## Estrutura e Modularização

O projeto segue uma arquitetura modular, dividida em três pacotes principais sob a raiz `br.universidade.repo`:

| Pacote | Função | Conteúdo Principal |
| :--- | :--- | :--- |
| `modelo/` | **Entidades** | `Aluno.java`, `Livro.java` |
| `repositorio/` | **Contrato e Lógica de Dados** | `Repositorio.java` (Interface), `RepositorioAlunoArray.java`, `RepositorioLivroArray.java` |
| `app/` | **Aplicação/Testes** | `Main.java` (Demonstração) |

---

## Conceitos Implementados

### 1. Interface (`Repositorio.java`)

Define um **contrato** de persistência comum, garantindo que qualquer repositório terá os métodos básicos de CRUD:

* `boolean adicionar(Object obj)`
* `boolean remover(String chave)`
* `Object buscar(String chave)`
* `Object[] listar()`

### 2. Múltipla Implementação e Polimorfismo

Duas classes distintas implementam o mesmo contrato `Repositorio`:

| Implementação | Tipo Armazenado | Chave de Busca |
| :--- | :--- | :--- |
| **`RepositorioAlunoArray`** | `Aluno[]` | Matrícula |
| **`RepositorioLivroArray`** | `Livro[]` | Título |

Ambas as classes utilizam arrays de forma manual (busca linear e deslocamento de elementos na remoção) e tratam erros (capacidade máxima, tipo inválido) com mensagens no console (`System.err`), sem o uso de Exceções.

---

## Como Compilar e Executar

Siga os passos abaixo, garantindo que você está no diretório **`src/`** (o diretório que contém a pasta `br/`).

### 1. Compilação

Use o `javac` para compilar todos os arquivos, garantindo que o compilador encontre todas as classes dependentes.

```bash
# Certifique-se de estar no diretório 'src'
javac br/universidade/repo/app/Main.java \
      br/universidade/repo/modelo/Aluno.java \
      br/universidade/repo/modelo/Livro.java \
      br/universidade/repo/repositorio/Repositorio.java \
      br/universidade/repo/repositorio/RepositorioAlunoArray.java \
      br/universidade/repo/repositorio/RepositorioLivroArray.java

# Executa a classe principal
java -cp . br.universidade.repo.app.Main
