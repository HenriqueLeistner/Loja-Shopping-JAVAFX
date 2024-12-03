public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionarios;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;


    // Inicializar todos os Atributos //

    public Loja(String nome, int quantidadedeFuncionarios, double salarioBaseFuncionarios, Endereco endereco, Data dataFundacao, int maxProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadedeFuncionarios;
        this.salarioBaseFuncionarios = salarioBaseFuncionarios;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[maxProdutos];
    }

    // Inicializar apenas nome e quantidadedeFuncionarios, com salario base -1 //

    public Loja(String nome, int quantidadedeFuncionarios, Endereco endereco, Data dataFundacao) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadedeFuncionarios;
        this.salarioBaseFuncionarios = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
    }

    public Loja(String nome, int quantidadeFuncionarios, int maxProdutos) {
        this(nome, quantidadeFuncionarios, -1, null, null, maxProdutos);
    }

    // Getters e Setters //

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadedeFuncionarios(int quantidadedeFuncionarios) {
        this.quantidadeFuncionarios = quantidadedeFuncionarios;
    }

    public double getsSalarioBaseFuncionario() {
        return salarioBaseFuncionarios;
    }

    public void setSalarioBaseFuncionarios(double salarioBaseFuncionarios) {
        this.salarioBaseFuncionarios = salarioBaseFuncionarios;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    // toString // 

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Loja [Nome: " + nome +
            ", Quantidade de Funcionários: " + quantidadeFuncionarios +
            ", Salário Base: " + salarioBaseFuncionarios +
            ", Endereço: " + endereco +
            ", Data de Fundação: " + dataFundacao +
            ", Produtos no Estoque: ");

        for (Produto produto : estoqueProdutos) {
            if (produto != null) {
                info.append("\n  ").append(produto);
            }
        }
        
        return info.toString();
    }

    public void imprimeProdutos() {
        System.out.println("Produtos da Loja:");
        for (Produto produto : estoqueProdutos) {
            if (produto != null) {
                System.out.println(produto);
            }
        }
    }

    public boolean insereProduto(Produto produto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] == null) {
                estoqueProdutos[i] = produto;
                return true;
            }
        }
        return false;
    }

    public boolean removeProduto(String nomeProduto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equals(nomeProduto)) {
                estoqueProdutos[i] = null; // Remove o produto
                return true; // Produto removido com sucesso
            }
        }
        return false; // Produto não encontrado
    }

    // Método gastosComSalario //

    public double gastosComSalario() {
        if (salarioBaseFuncionarios == -1) {
            return -1;
        }
        return quantidadeFuncionarios * salarioBaseFuncionarios;
    }

    // Método tamanhoDaLoja //

    public char tamanhoDaLoja() {
        if (quantidadeFuncionarios < 10) {
            return 'P'; // Pequena
        } else if (quantidadeFuncionarios <= 30) {
            return 'M'; // Média
        } else {
            return 'G'; //Grande
        }
    }
}
