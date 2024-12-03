public class Bijuteria extends Loja{
    private double metaVendas;

    // Construtor que recebe todos os parâmetros, incluindo os de Loja e Bijuteria
    public Bijuteria(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, 
                    Endereco endereco, Data dataFundacao, double metaVendas) {
        // Chamando o construtor da classe pai (Loja)
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeFuncionarios);
        this.metaVendas = metaVendas;
    }

    // Getter para metaVendas
    public double getMetaVendas() {
        return metaVendas;
    }

    // Setter para metaVendas
    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    // Sobrescrevendo o método toString para incluir a meta de vendas
    @Override
    public String toString() {
        return super.toString() + 
            ", Meta de Vendas Mensais: R$ " + metaVendas;
    }
}
