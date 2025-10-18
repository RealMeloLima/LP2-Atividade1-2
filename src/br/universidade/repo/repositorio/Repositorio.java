package br.universidade.repo.repositorio;

/**
 * Define a estrutura básica de um repositório de dados.
 */
public interface Repositorio {
    
    /**
     * Adiciona um objeto ao repositório.
     * @param obj O objeto a ser adicionado.
     * @return true se adicionado com sucesso, false caso contrário (erro impresso).
     */
    boolean adicionar(Object obj);

    /**
     * Remove um objeto do repositório pela chave.
     * @param chave A chave (String) do objeto a ser removido.
     * @return true se removido com sucesso, false caso contrário (erro impresso).
     */
    boolean remover(String chave);

    /**
     * Busca um objeto pela chave.
     * @param chave A chave (String) do objeto a ser buscado.
     * @return O objeto encontrado ou null se não for encontrado.
     */
    Object buscar(String chave);

    /**
     * Retorna uma cópia do array interno contendo apenas os objetos válidos.
     * @return Um array de Objetos.
     */
    Object[] listar();
}