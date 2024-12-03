public class Informatica extends Loja {
    private double seguroEletronicos;

    // Construtor que recebe todos os parâmetros, incluindo os de Loja e Informatica
    public Informatica(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, 
                        Endereco endereco, Data dataFundacao, double seguroEletronicos) {
        // Chamando o construtor da classe pai (Loja)
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeFuncionarios);
        this.seguroEletronicos = seguroEletronicos;
    }

    // Getter para seguroEletronicos
    public double getSeguroEletronicos() {
        return seguroEletronicos;
    }

    // Setter para seguroEletronicos
    public void setSeguroEletronicos(double seguroEletronicos) {
        this.seguroEletronicos = seguroEletronicos;
    }

    // Sobrescrevendo o método toString para incluir o seguro eletrônico
    @Override
    public String toString() {
        return super.toString() + 
            ", Seguro Eletrônicos Mensal: R$ " + seguroEletronicos;
    }
}
