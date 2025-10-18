package br.universidade.repo.app;

import br.universidade.repo.modelo.Aluno;
import br.universidade.repo.modelo.Livro;
import br.universidade.repo.repositorio.Repositorio;
import br.universidade.repo.repositorio.RepositorioAlunoArray;
import br.universidade.repo.repositorio.RepositorioLivroArray;


public class Main {

    public static void main(String[] args) {
        
        System.out.println("=================================================");
        System.out.println(" DEMONSTRAÇÃO DO REPOSITÓRIO (SEM EXCEÇÕES) ");
        System.out.println("=================================================\n");

        Repositorio repoAluno = new RepositorioAlunoArray();
        System.out.println("--- REPOSITÓRIO DE ALUNOS ---");
        
        repoAluno.adicionar(new Aluno("2024001", "Maria Silva"));
        repoAluno.adicionar(new Aluno("2024002", "João Pereira"));
        repoAluno.adicionar(new Aluno("2024003", "Ana Souza"));

        System.out.print("\n[TESTE ERRO] Tentando adicionar Livro no Repositório Aluno: \n");
        repoAluno.adicionar(new Livro("The Great Gatsby", "F. Scott Fitzgerald"));
        
        System.out.print("\n[TESTE ERRO] Tentando adicionar Aluno com matrícula 2024001 novamente: \n");
        repoAluno.adicionar(new Aluno("2024001", "Maria Duplicada"));

        System.out.println("\n--- LISTAGEM INICIAL DE ALUNOS (" + repoAluno.listar().length + " itens) ---");
        imprimirLista(repoAluno.listar());

        String matriculaBusca = "2024002";
        Aluno alunoEncontrado = (Aluno) repoAluno.buscar(matriculaBusca);
        if (alunoEncontrado != null) {
            System.out.println("\n Aluno encontrado (Chave " + matriculaBusca + "): " + alunoEncontrado);
        } else {
            System.out.println("\nAluno com matrícula " + matriculaBusca + " não encontrado.");
        }
        
        String matriculaRemover = "2024002";
        repoAluno.remover(matriculaRemover);

        System.out.println("\n--- LISTAGEM APÓS REMOÇÃO (" + repoAluno.listar().length + " itens) ---");
        imprimirLista(repoAluno.listar());
        
        System.out.print("\n[TESTE ERRO] Tentando remover Aluno 999999: \n");
        repoAluno.remover("999999");
            
        
        System.out.println("\n\n-------------------------------------------------");
        
        Repositorio repoLivro = new RepositorioLivroArray();
        System.out.println("--- REPOSITÓRIO DE LIVROS ---");

        repoLivro.adicionar(new Livro("A Arte da Guerra", "Sun Tzu"));
        repoLivro.adicionar(new Livro("1984", "George Orwell"));
        repoLivro.adicionar(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
        repoLivro.adicionar(new Livro("Dom Casmurro", "Machado de Assis"));
        repoLivro.adicionar(new Livro("Cem Anos de Solidão", "Gabriel García Márquez"));

        System.out.print("\n[TESTE ERRO] Tentando adicionar o 6º Livro (Capacidade Máxima=5): \n");
        repoLivro.adicionar(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));

        System.out.println("\n--- LISTAGEM INICIAL DE LIVROS (" + repoLivro.listar().length + " itens) ---");
        imprimirLista(repoLivro.listar());

        String tituloBusca = "1984";
        Livro livroEncontrado = (Livro) repoLivro.buscar(tituloBusca);
        if (livroEncontrado != null) {
            System.out.println("\ Livro encontrado (Chave '" + tituloBusca + "'): " + livroEncontrado);
        } else {
            System.out.println("\nLivro com título " + tituloBusca + " não encontrado.");
        }

        String tituloRemover = "A Arte da Guerra";
        repoLivro.remover(tituloRemover);

        System.out.println("\n--- LISTAGEM APÓS REMOÇÃO (" + repoLivro.listar().length + " itens) ---");
        imprimirLista(repoLivro.listar());

        System.out.println("\n=================================================");
        System.out.println(" FIM DA DEMONSTRAÇÃO ");
        System.out.println("=================================================");
    }

    private static void imprimirLista(Object[] lista) {
        if (lista.length == 0) {
            System.out.println("[Repositório vazio]");
            return;
        }
        for (int i = 0; i < lista.length; i++) {
            System.out.println("  [" + i + "] " + lista[i]);
        }
    }
}