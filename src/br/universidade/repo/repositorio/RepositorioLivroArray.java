package br.universidade.repo.repositorio;

import br.universidade.repo.modelo.Livro;
import java.util.Arrays;

/**
 * Implementação da interface Repositorio para objetos Livro, usando arrays.
 * A chave de busca/remoção é o título do Livro.
 * O tratamento de erro é feito via impressão no console (System.err).
 */
public class RepositorioLivroArray implements Repositorio {

    private Livro[] livros;
    private int proximaPosicao;
    private static final int CAPACIDADE_MAXIMA = 5; // Capacidade menor para teste

    public RepositorioLivroArray() {
        this.livros = new Livro[CAPACIDADE_MAXIMA];
        this.proximaPosicao = 0;
    }

    /**
     * Adiciona um Livro ao array.
     * A validação de tipo e capacidade é realizada.
     */
    @Override
    public boolean adicionar(Object obj) {
        if (obj == null) {
            System.err.println(" ERRO: O objeto a ser adicionado não pode ser nulo.");
            return false;
        }
        if (!(obj instanceof Livro)) {
            System.err.println(" ERRO: Tipo de objeto inválido. Esperado: Livro.");
            return false;
        }
        if (proximaPosicao >= CAPACIDADE_MAXIMA) {
            System.err.println("ERRO: Capacidade máxima do repositório de Livros atingida.");
            return false;
        }

        Livro novoLivro = (Livro) obj;
        if (buscar(novoLivro.getTitulo()) != null) {
            System.err.println(" ERRO: Livro com título '" + novoLivro.getTitulo() + "' já existe.");
            return false;
        }

        this.livros[proximaPosicao] = novoLivro;
        this.proximaPosicao++;
        System.out.println(" Adicionado: " + novoLivro);
        return true;
    }

    /**
     * Busca um Livro pelo título (chave).
     */
    @Override
    public Object buscar(String chave) {
        if (chave == null || chave.trim().isEmpty()) {
            return null;
        }
        
        for (int i = 0; i < proximaPosicao; i++) {
            if (livros[i] != null && livros[i].getTitulo().equals(chave)) {
                return livros[i];
            }
        }
        return null;
    }

    /**
     * Remove um Livro pelo título (chave) e reorganiza o array.
     */
    @Override
    public boolean remover(String chave) {
        int indiceParaRemover = -1;

        for (int i = 0; i < proximaPosicao; i++) {
            if (livros[i] != null && livros[i].getTitulo().equals(chave)) {
                indiceParaRemover = i;
                break;
            }
        }

        if (indiceParaRemover == -1) {
            System.err.println(" ERRO: Livro com título '" + chave + "' não encontrado para remoção.");
            return false;
        }

        Livro livroRemovido = livros[indiceParaRemover];

        for (int i = indiceParaRemover; i < proximaPosicao - 1; i++) {
            livros[i] = livros[i + 1];
        }

        livros[proximaPosicao - 1] = null;
        proximaPosicao--;
        
        System.out.println(" Removido com sucesso: " + livroRemovido);
        return true;
    }

    /**
     * Retorna um novo array contendo apenas os Livros válidos.
     */
    @Override
    public Object[] listar() {
        return Arrays.copyOf(livros, proximaPosicao);
    }
}