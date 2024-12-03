public class Vestuario extends Loja{
    private boolean produtosImportados;

    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, 
                    Endereco endereco, Data dataFundacao, boolean produtosImportados) {
        // Chamando o construtor da classe pai (Loja)
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeFuncionarios);
        this.produtosImportados = produtosImportados;
    }

    // Getter para produtosImportados
    public boolean isProdutosImportados() {
        return produtosImportados;
    }

    // Setter para produtosImportados
    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }

    // Sobrescrevendo o método toString para incluir se a loja vende produtos importados
    @Override
    public String toString() {
        return super.toString() + 
            ", Produtos Importados: " + (produtosImportados ? "Sim" : "Não");
    }
}
