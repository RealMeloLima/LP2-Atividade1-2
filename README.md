Repositório com Interfaces e Múltiplas Implementações em Java

Este projeto foi desenvolvido como parte da Atividade 1-2 da disciplinaIMD0040 - LINGUAGEM DE PROGRAMAÇÃO II, focado em exercitar os conceitos de Interfaces, Múltipla Implementação e Modularização (uso de pacotes), utilizando apenas arrays nativos de Java e sem o uso de Generics ou Collections.

 Estrutura do Projeto

O projeto segue uma arquitetura modular, dividida em três pacotes principais sob a raiz br.universidade.repo:

src/
 └─ br/
    └─ universidade/
       └─ repo/
          ├─ app/                 <- Camada de Aplicação (Execução)
          │  └─ Main.java         <- Demonstra as operações do repositório.
          ├─ modelo/              <- Camada de Entidades (Modelos de Dados)
          │  ├─ Aluno.java         <- Entidade básica.
          │  └─ Livro.java         <- Entidade básica.
          └─ repositorio/         <- Camada de Repositório (Contrato e Implementações)
             ├─ Repositorio.java   <- A Interface (Contrato).
             ├─ RepositorioAlunoArray.java <- Implementação para armazenar Alunos[].
             └─ RepositorioLivroArray.java <- Implementação para armazenar Livros[].


 Conceitos Implementados

1. Interface (Repositorio.java)

Define um contrato de persistência comum, garantindo que qualquer repositório (seja de Aluno, Livro, etc.) terá os seguintes métodos públicos:

boolean adicionar(Object obj)

boolean remover(String chave)

Object buscar(String chave)

Object[] listar()

2. Múltipla Implementação e Polimorfismo

Duas classes distintas implementam o mesmo contrato Repositorio, demonstrando Polimorfismo:

RepositorioAlunoArray: Armazena objetos Aluno[]. A chave de busca é a matrícula do aluno.

RepositorioLivroArray: Armazena objetos Livro[]. A chave de busca é o título do livro.

Ambas as implementações usam arrays de forma manual (busca linear, deslocamento de elementos na remoção) para cumprir o requisito de não usar coleções avançadas. O tratamento de erros (capacidade máxima, tipo inválido) é feito com mensagens no console (System.err.println), sem o uso de Exceções (try/catch).

3. Execução (Main.java)

A classe Main cria uma instância de cada repositório (RepositorioAlunoArray e RepositorioLivroArray) e demonstra todas as operações do contrato Repositorio para cada tipo, além de testar as validações de erro.

Como Compilar e Executar

Para rodar este projeto, navegue até o diretório src/ no seu terminal (o diretório que contém a pasta br/).

1. Compilação

Use o javac para compilar todos os arquivos .java.

# Certifique-se de estar no diretório 'src'
javac br/universidade/repo/app/Main.java \
      br/universidade/repo/modelo/Aluno.java \
      br/universidade/repo/modelo/Livro.java \
      br/universidade/repo/repositorio/Repositorio.java \
      br/universidade/repo/repositorio/RepositorioAlunoArray.java \
      br/universidade/repo/repositorio/RepositorioLivroArray.java


2. Execução

Use o comando java com o parâmetro -cp . (classpath) para indicar que a máquina virtual deve começar a procurar as classes a partir do diretório atual (.), seguindo o nome completo do pacote da classe Main.

# Executa a classe principal
java -cp . br.universidade.repo.app.Main


Você verá o resultado da demonstração do repositório de Alunos e Livros no console.
