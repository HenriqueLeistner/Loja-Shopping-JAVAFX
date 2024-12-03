package funcionarios;

public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
    private String cpf;

    // Construtor
    public Funcionario(String nome, String cargo, double salario, String cpf) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.cpf = cpf;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo()  {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override

    public String toString() {
        return "Nome: " + nome + ", Cargo: " + cargo + ", Salário: R$" + salario + ", CPF: " + cpf;
    }
}
