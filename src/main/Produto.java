public class Produto {
    private String nome;
    private Double preco;
    private Data dataValidade;
    private int quantidade;
    
    // Inicializar todos os atributos //

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    // Getters e Setters //

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    // toString //

    public String toString() {
        return "Produto [Nome: " + nome + ", Preço: R$ " + preco + ", Validade: " + dataValidade + ",quantidade: " + quantidade" ]";
    }

    // Método para verificar se o produto está vencido

    public boolean estaVencido(Data dataAtual) {
    
    // Verifica se o ano de validade é menor, ou, em caso de igualdade, verifica mês e dia
        
        if (dataValidade.getAno() < dataAtual.getAno()) {
            return true;
        } else if (dataValidade.getAno() == dataAtual.getAno()) {
            if (dataValidade.getMes() < dataAtual.getMes()) {
                return true;
            } else if (dataValidade.getMes() == dataAtual.getMes()) {
                return dataValidade.getDia() < dataAtual.getDia();
            }
        }
        return false;
    }

}

