public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Inicializar todos os atributos //

    public Data(int dia, int mes, int ano) {
        if (validaData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data Inválida. Definindo data padrão: 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    // Getters e Setters //
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (validaData(dia, this.mes, this.ano)) {
            this.dia = dia;
        } else {
            System.out.println("Dia inválido!");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (validaData(this.dia, mes, this.ano)) {
            this.mes = mes;
        } else {
            System.out.println("Mês inválido!");
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (validaData(this.dia, this.mes, ano)) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido!");
        }
    }

    // toString //
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    // Ano Bissexto //

    public boolean verificaAnoBissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // validaData //

    private boolean validaData(int dia, int mes, int ano) {

        if (mes < 1 || mes > 12) {
            return false;
        }
        int[] diasPorMes = { 31, (verificaAnoBissexto() ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        return dia > 0 && dia <= diasPorMes[mes - 1];
    }
}
