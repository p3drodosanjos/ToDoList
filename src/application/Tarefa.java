package application;

public class Tarefa {
    private String descricao;
    private boolean concluida;

    // Construtor: Toda vez que criarmos uma tarefa, ela começa como "não concluída"
    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    // O método toString ajuda a imprimir a tarefa formatada no console
    @Override
    public String toString() {
        String status = concluida ? "[X]" : "[ ]";
        return status + " " + descricao;
    }
}