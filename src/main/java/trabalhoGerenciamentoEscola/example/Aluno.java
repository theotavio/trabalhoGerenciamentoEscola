package trabalhoGerenciamentoEscola.example;

public class Aluno extends Pessoa{
    // Atributos
    private int matricula;
    private int idade;

    // Construtor com as devidas verificações
    public Aluno(String nome, String cpf, int matricula, int idade){
        super(nome, cpf);
        this.matricula = matricula;
        this.idade = idade;

        if (matricula <= 0)
            MensagensErro.adicionarErro(MensagensErro.MATRICULA_INVALIDA);
        if (idade < 0)
            MensagensErro.adicionarErro(MensagensErro.IDADE_INVALIDA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    // Metodo toString
    @Override
    public String toString(){
        return "Aluno: " + getNome() + ", CPF: " + formatarCpf(getCpf()) + ", Matricula: " + "2024" + getMatricula() + ", Idade: " + getIdade();
    }

    // Getters e Setters com as devidas verificações
    public int getMatricula(){
        return matricula;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;

        if (matricula <= 0)
            MensagensErro.adicionarErro(MensagensErro.MATRICULA_INVALIDA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;

        if (idade < 0)
            MensagensErro.adicionarErro(MensagensErro.IDADE_INVALIDA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    // Metodo para formatar o CPF
    private String formatarCpf(String cpf){
        return cpf.substring(0, 3) + "." +  cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
}