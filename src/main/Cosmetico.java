public class Cosmetico extends Loja {
    private double taxaComercializacao;

    // Construtor que recebe todos os parâmetros, incluindo os de Loja e Cosmetico
    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, 
        Endereco endereco, Data dataFundacao, double taxaComercializacao) {

        // Chamando o construtor da classe pai (Loja)
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeFuncionarios);
        this.taxaComercializacao = taxaComercializacao;
    }

    // Getter para taxaComercializacao
    public double getTaxaComercializacao() {
        return taxaComercializacao;
    }

    // Setter para taxaComercializacao
    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }

    // Sobrescrevendo o método toString para incluir a taxa de comercialização
    @Override
    public String toString() {
        return super.toString() + 
        ", Taxa de Comercialização: " + taxaComercializacao;
    }
}