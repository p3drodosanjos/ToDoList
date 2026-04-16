package application;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    // Lista que vai armazenar os objetos do tipo Tarefa
    private List<Tarefa> listaDeTarefas;

    public GerenciadorTarefas() {
        this.listaDeTarefas = new ArrayList<>();
    }

    // Adiciona uma nova tarefa na lista
    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        listaDeTarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    // Lista todas as tarefas com seus respectivos números (índices)
    public void listarTarefas() {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Sua lista está vazia!");
            return;
        }
        
        System.out.println("\n--- Suas Tarefas ---");
        for (int i = 0; i < listaDeTarefas.size(); i++) {
            System.out.println((i + 1) + ". " + listaDeTarefas.get(i).toString());
        }
    }

    // Marca uma tarefa como concluída baseada no número digitado pelo usuário
    public void concluirTarefa(int indice) {
        // Subtraímos 1 porque o usuário vê a lista começando no 1, mas o ArrayList começa no 0
        int indiceReal = indice - 1; 
        
        if (indiceReal >= 0 && indiceReal < listaDeTarefas.size()) {
            listaDeTarefas.get(indiceReal).setConcluida(true);
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Número de tarefa inválido.");
        }
    }
    
    // Remove a tarefa da lista
    public void removerTarefa(int indice) {
        int indiceReal = indice - 1;
        
        if (indiceReal >= 0 && indiceReal < listaDeTarefas.size()) {
            listaDeTarefas.remove(indiceReal);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Número de tarefa inválido.");
        }
    }
}