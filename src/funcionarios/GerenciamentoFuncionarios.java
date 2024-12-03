
package funcionarios;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoFuncionarios extends Application {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        // Título
        Label titleLabel = new Label("Gerenciamento de Funcionários");

        // Botões
        Button cadastrarButton = new Button("Cadastrar Funcionário");
        Button listarButton = new Button("Listar Funcionários");
        Button atualizarButton = new Button("Atualizar Funcionário");
        Button removerButton = new Button("Remover Funcionário");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        // Ações dos Botões
        cadastrarButton.setOnAction(e -> cadastrarFuncionario());
        listarButton.setOnAction(e -> listarFuncionarios());
        atualizarButton.setOnAction(e -> atualizarFuncionario());
        removerButton.setOnAction(e -> removerFuncionario());

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(titleLabel, cadastrarButton, listarButton, atualizarButton, removerButton, outputArea);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Gerenciamento de Funcionários");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void cadastrarFuncionario() {
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Funcionário");

        // Campos
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");
        TextField cargoField = new TextField();
        cargoField.setPromptText("Cargo");
        TextField salarioField = new TextField();
        salarioField.setPromptText("Salário");
        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF");

        Button salvarButton = new Button("Salvar");
        salvarButton.setOnAction(e -> {
            String nome = nomeField.getText();
            String cargo = cargoField.getText();
            double salario = Double.parseDouble(salarioField.getText());
            String cpf = cpfField.getText();

            Funcionario funcionario = new Funcionario(nome, cargo, salario, cpf);
            funcionarios.add(funcionario);

            outputArea.appendText("Funcionário cadastrado: " + nome + "\n");
            stage.close();
        });

        VBox layout = new VBox(10, nomeField, cargoField, salarioField, cpfField, salvarButton);
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout, 300, 200));
        stage.show();
    }

    private void listarFuncionarios() {
        outputArea.clear();
        if (funcionarios.isEmpty()) {
            outputArea.appendText("Nenhum funcionário cadastrado.\n");
        } else {
            outputArea.appendText("Funcionários:\n");
            for (Funcionario f : funcionarios) {
                outputArea.appendText(f + "\n");
            }
        }
    }

    private void atualizarFuncionario() {
        Stage stage = new Stage();
        stage.setTitle("Atualizar Funcionário");

        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF do Funcionário");

        Button buscarButton = new Button("Buscar");
        buscarButton.setOnAction(e -> {
            String cpf = cpfField.getText();
            Funcionario funcionario = funcionarios.stream()
                    .filter(f -> f.getCpf().equals(cpf))
                    .findFirst()
                    .orElse(null);

            if (funcionario != null) {
                TextField nomeField = new TextField(funcionario.getNome());
                TextField cargoField = new TextField(funcionario.getCargo());
                TextField salarioField = new TextField(String.valueOf(funcionario.getSalario()));

                Button salvarButton = new Button("Salvar Alterações");
                salvarButton.setOnAction(ev -> {
                    funcionario.setNome(nomeField.getText());
                    funcionario.setCargo(cargoField.getText());
                    funcionario.setSalario(Double.parseDouble(salarioField.getText()));
                    outputArea.appendText("Funcionário atualizado: " + funcionario + "\n");
                    stage.close();
                });

                VBox updateLayout = new VBox(10, nomeField, cargoField, salarioField, salvarButton);
                updateLayout.setPadding(new Insets(10));
                stage.setScene(new Scene(updateLayout, 300, 200));
            } else {
                outputArea.appendText("Funcionário não encontrado.\n");
            }
        });

        VBox layout = new VBox(10, cpfField, buscarButton);
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout, 300, 200));
        stage.show();
    }

    private void removerFuncionario() {
        Stage stage = new Stage();
        stage.setTitle("Remover Funcionário");

        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF do Funcionário");

        Button removerButton = new Button("Remover");
        removerButton.setOnAction(e -> {
            String cpf = cpfField.getText();
            boolean removed = funcionarios.removeIf(f -> f.getCpf().equals(cpf));

            if (removed) {
                outputArea.appendText("Funcionário removido: " + cpf + "\n");
            } else {
                outputArea.appendText("Funcionário não encontrado.\n");
            }
            stage.close();
        });

        VBox layout = new VBox(10, cpfField, removerButton);
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout, 300, 150));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
