package br.universidade.repo.repositorio;

import br.universidade.repo.modelo.Aluno;
import java.util.Arrays;


public class RepositorioAlunoArray implements Repositorio {

    private Aluno[] alunos;
    private int proximaPosicao;
    private static final int CAPACIDADE_MAXIMA = 10;

    public RepositorioAlunoArray() {
        this.alunos = new Aluno[CAPACIDADE_MAXIMA];
        this.proximaPosicao = 0;
    }

    /**
     * Adiciona um Aluno ao array.
     * A validação de tipo e capacidade é realizada.
     */
    @Override
    public boolean adicionar(Object obj) {
        if (obj == null) {
            System.err.println(" Erro: objeto a ser adicionado não pode ser nulo.");
            return false;
        }
        if (!(obj instanceof Aluno)) {
            System.err.println("Erro ipo de objeto inválido. Esperado: Aluno.");
            return false;
        }
        if (proximaPosicao >= CAPACIDADE_MAXIMA) {
            System.err.println("Erro capacidade máxima do repositório de Alunos atingida.");
            return false;
        }

        Aluno novoAluno = (Aluno) obj;
        
        if (buscar(novoAluno.getMatricula()) != null) {
            System.err.println(" ERRO: Aluno com matrícula " + novoAluno.getMatricula() + " já existe.");
            return false;
        }
        
        this.alunos[proximaPosicao] = novoAluno;
        this.proximaPosicao++;
        System.out.println("Adicionado: " + novoAluno);
        return true;
    }

    /**
     * Busca um Aluno pela matrícula (chave).
     */
    @Override
    public Object buscar(String chave) {
        if (chave == null || chave.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < proximaPosicao; i++) {
            if (alunos[i] != null && alunos[i].getMatricula().equals(chave)) {
                return alunos[i];
            }
        }
        return null;
    }

    /**
     * Remove um Aluno pela matrícula (chave) e reorganiza o array.
     */
    @Override
    public boolean remover(String chave) {
        int indiceParaRemover = -1;

        for (int i = 0; i < proximaPosicao; i++) {
            if (alunos[i] != null && alunos[i].getMatricula().equals(chave)) {
                indiceParaRemover = i;
                break;
            }
        }

        if (indiceParaRemover == -1) {
            System.err.println("ERRO: Aluno com matrícula " + chave + " não encontrado para remoção.");
            return false;
        }

        Aluno alunoRemovido = alunos[indiceParaRemover];

        for (int i = indiceParaRemover; i < proximaPosicao - 1; i++) {
            alunos[i] = alunos[i + 1];
        }

        alunos[proximaPosicao - 1] = null;
        proximaPosicao--;
        
        System.out.println("Removido com sucesso: " + alunoRemovido);
        return true;
    }

    /**
     * Retorna um novo array contendo apenas os Alunos válidos.
     */
    @Override
    public Object[] listar() {
        return Arrays.copyOf(alunos, proximaPosicao);
    }
}