public class Alimentacao extends Loja{
    private Data dataAlvara;

    // Construtor que recebe todos os parâmetros, incluindo os de Loja e Alimentacao
    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, 
                    Endereco endereco, Data dataFundacao, Data dataAlvara) {
        // Chamando o construtor da classe pai (Loja)
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeFuncionarios);
        this.dataAlvara = dataAlvara;
    }

    // Getter para dataAlvara
    public Data getDataAlvara() {
        return dataAlvara;
    }

    // Setter para dataAlvara
    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }

    // Sobrescrevendo o método toString para incluir a data do alvará
    @Override
    public String toString() {
        return super.toString() + 
            ", Data do Alvará: " + dataAlvara;
    }
}
