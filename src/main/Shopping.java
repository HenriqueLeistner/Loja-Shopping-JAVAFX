public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    // Construtor da classe Shopping
    public Shopping(String nome, Endereco endereco, int maxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[maxLojas]; // Inicializa o array com a capacidade máxima
    }

    // Métodos de acesso para os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    // Sobrescrita do método toString para exibir informações do shopping
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Shopping [Nome: " + nome + ", Endereço: " + endereco + ", Lojas:\n");
        for (Loja loja : lojas) {
            if (loja != null) {
                info.append(loja).append("\n");
            }
        }
        info.append("]");
        return info.toString();
    }

    // Método insereLoja: insere uma loja na primeira posição livre do array
    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true; // Loja inserida com sucesso
            }
        }
        return false; // Sem espaço para inserir a loja
    }

    // Método removeLoja: remove uma loja pelo nome
    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null; // Remove a loja
                return true; // Loja removida com sucesso
            }
        }
        return false; // Loja não encontrada
    }

    // Método quantidadeLojasPorTipo: retorna a quantidade de lojas de um tipo específico
    public int quantidadeLojasPorTipo(String tipo) {
        int contador = 0;
        for (Loja loja : lojas) {
            if (loja != null) {
                switch (tipo.toLowerCase()) {
                    case "cosmetico":
                        if (loja instanceof Cosmetico) contador++;
                        break;
                    case "vestuario":
                        if (loja instanceof Vestuario) contador++;
                        break;
                    case "bijuteria":
                        if (loja instanceof Bijuteria) contador++;
                        break;
                    case "alimentacao":
                        if (loja instanceof Alimentacao) contador++;
                        break;
                    case "informatica":
                        if (loja instanceof Informatica) contador++;
                        break;
                    default:
                        return -1; // Tipo não encontrado
                }
            }
        }
        return contador;
    }

    // Método lojaSeguroMaisCaro: retorna a loja de informática com o seguro mais caro
    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCara = null;
        double maiorSeguro = 0;

        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica lojaInfo = (Informatica) loja;
                if (lojaInfo.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = lojaInfo.getSeguroEletronicos();
                    maisCara = lojaInfo;
                }
            }
        }
        return maisCara;
    }
}
