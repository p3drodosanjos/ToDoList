package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Nossa classe herda de JFrame, ou seja, ela É uma janela.
public class JanelaPrincipal extends JFrame {

    // Componentes da nossa interface
    private JTextField campoTexto;
    private JButton botaoAdicionar;
    private JButton botaoConcluir;
    private JButton botaoRemover;
    
    // O JList exibe a lista, e o DefaultListModel gerencia os dados dela
    private JList<Tarefa> listaVisual;
    private DefaultListModel<Tarefa> modeloLista;

    public JanelaPrincipal() {
        // 1. Configurações básicas da Janela
        setTitle("Meu To-Do List");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new BorderLayout()); // Define o tipo de layout

        // 2. Inicializando os componentes
        modeloLista = new DefaultListModel<>();
        listaVisual = new JList<>(modeloLista);
        campoTexto = new JTextField(20);
        botaoAdicionar = new JButton("Adicionar");
        botaoConcluir = new JButton("Concluir Tarefa");
        botaoRemover = new JButton("Remover");

        // 3. Organizando o painel superior (Input e Botão Adicionar)
        JPanel painelSuperior = new JPanel();
        painelSuperior.add(new JLabel("Nova Tarefa:"));
        painelSuperior.add(campoTexto);
        painelSuperior.add(botaoAdicionar);

        // 4. Organizando o painel inferior (Botões Concluir e Remover)
        JPanel painelInferior = new JPanel();
        painelInferior.add(botaoConcluir);
        painelInferior.add(botaoRemover);

        // 5. Adicionando os painéis à Janela Principal
        add(painelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(listaVisual), BorderLayout.CENTER); // JScrollPane adiciona barra de rolagem
        add(painelInferior, BorderLayout.SOUTH);

        // 6. Configurando as Ações dos Botões (Listeners)
        configurarAcoes();
    }

    private void configurarAcoes() {
        // Ação do botão Adicionar
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campoTexto.getText();
                if (!texto.trim().isEmpty()) { // Verifica se não está vazio
                    Tarefa novaTarefa = new Tarefa(texto);
                    modeloLista.addElement(novaTarefa); // Adiciona no modelo, a tela atualiza sozinha
                    campoTexto.setText(""); // Limpa o campo de texto
                } else {
                    JOptionPane.showMessageDialog(null, "Digite uma tarefa primeiro!");
                }
            }
        });

        // Ação do botão Concluir
        botaoConcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega o índice do item que o usuário selecionou com o mouse
                int indexSelecionado = listaVisual.getSelectedIndex();
                if (indexSelecionado != -1) {
                    Tarefa tarefa = modeloLista.getElementAt(indexSelecionado);
                    tarefa.setConcluida(true);
                    listaVisual.repaint(); // Atualiza a cor/texto visual da lista
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma tarefa na lista para concluir.");
                }
            }
        });

        // Ação do botão Remover
        botaoRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexSelecionado = listaVisual.getSelectedIndex();
                if (indexSelecionado != -1) {
                    modeloLista.remove(indexSelecionado);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma tarefa para remover.");
                }
            }
        });
    }

    // O método main agora só precisa "ligar" a janela
    public static void main(String[] args) {
        // Isso garante que a interface gráfica inicie de forma segura na thread correta
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JanelaPrincipal janela = new JanelaPrincipal();
                janela.setVisible(true); // Faz a janela aparecer!
            }
        });
    }
}