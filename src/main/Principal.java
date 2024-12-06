import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Principal extends Application {
    private List<Loja> lojas = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private TextArea outputArea; // Área para mostrar informações de lojas e produtos

    @Override
    public void start(Stage primaryStage) {
        // Configurar os elementos da interface
        Label titleLabel = new Label("Gerenciador de Lojas e Produtos");

        // Botões de ação
        Button criarLojaButton = new Button("Criar Loja");
        Button criarProdutoButton = new Button("Criar Produto");
        Button listarButton = new Button("Listar Lojas e Produtos");
        
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        // Ações para os botões
        criarLojaButton.setOnAction(e -> criarLoja());
        criarProdutoButton.setOnAction(e -> criarProduto());
        listarButton.setOnAction(e -> listarLojasEProdutos());

        // Layout da aplicação
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(titleLabel, criarLojaButton, criarProdutoButton, listarButton, outputArea);

        // Configuração da janela
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Gerenciador de Lojas e Produtos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para criar uma loja
    private void criarLoja() {
        Stage lojaStage = new Stage();
        lojaStage.setTitle("Criar Loja");

        // Campos de entrada
        TextField nomeLojaField = new TextField();
        nomeLojaField.setPromptText("Nome da Loja");
        TextField qtdFuncionariosField = new TextField();
        qtdFuncionariosField.setPromptText("Quantidade de Funcionários");
        TextField salarioBaseField = new TextField();
        salarioBaseField.setPromptText("Salário Base");
        TextField enderecoField = new TextField();
        enderecoField.setPromptText("Endereço da Loja");
        TextField dataFundacaoField = new TextField();
        dataFundacaoField.setPromptText("Data de Fundação:");

        // Botão para salvar loja
        Button salvarLojaButton = new Button("Salvar Loja");
        salvarLojaButton.setOnAction(e -> {
            String nomeLoja = nomeLojaField.getText();
            int qtdFuncionarios = Integer.parseInt(qtdFuncionariosField.getText());
            double salarioBase = Double.parseDouble(salarioBaseField.getText());
            String endereco = enderecoField.getText();
            int dataFundacao = Integer.parseInt(dataFundacaoField.getText());

            Loja loja = new Loja(nomeLoja, qtdFuncionarios, salarioBase, endereco, dataFundacao, qtdFuncionarios);
            lojas.add(loja);

            outputArea.appendText("Loja criada: " + nomeLoja + "\n");
            lojaStage.close();
        });

        VBox lojaLayout = new VBox(10, nomeLojaField, qtdFuncionariosField, salarioBaseField, enderecoField, dataFundacaoField, salvarLojaButton);
        lojaLayout.setPadding(new Insets(10));
        lojaStage.setScene(new Scene(lojaLayout, 300, 200));
        lojaStage.show();
    }

    // Método para criar um produto
    private void criarProduto() {
        Stage produtoStage = new Stage();
        produtoStage.setTitle("Criar Produto");

        // Campos de entrada
        TextField nomeProdutoField = new TextField();
        nomeProdutoField.setPromptText("Nome do Produto");
        TextField precoField = new TextField();
        precoField.setPromptText("Preço");

        // Botão para salvar produto
        Button salvarProdutoButton = new Button("Salvar Produto");
        salvarProdutoButton.setOnAction(e -> {
            String nomeProduto = nomeProdutoField.getText();
            double preco = Double.parseDouble(precoField.getText());

            Produto produto = new Produto(nomeProduto, preco, null);
            produtos.add(produto);

            outputArea.appendText("Produto criado: " + nomeProduto + "\n");
            produtoStage.close();
        });

        VBox produtoLayout = new VBox(10, nomeProdutoField, precoField, salvarProdutoButton);
        produtoLayout.setPadding(new Insets(10));
        produtoStage.setScene(new Scene(produtoLayout, 300, 200));
        produtoStage.show();
    }

    // Método para listar lojas e produtos
    private void listarLojasEProdutos() {
        outputArea.clear();
        outputArea.appendText("Lojas:\n");
        for (Loja loja : lojas) {
            outputArea.appendText(loja.toString() + "\n");
        }

        outputArea.appendText("\nProdutos:\n");
        for (Produto produto : produtos) {
            outputArea.appendText(produto.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
