package trabalhoGerenciamentoEscola.example;
import java.util.ArrayList;

public class Aluno extends Pessoa {
    // Atributos
    private int matricula;
    private int idade;
    private int numeroAlunos;
    private ArrayList<Turma> turmas = new ArrayList<>();

    // Construtor com as devidas verificações
    public Aluno(String nome, String cpf, int matricula, int idade) {
        super(nome, cpf);
        if (matricula <= 0)
            MensagensErro.adicionarErro(MensagensErro.MATRICULA_INVALIDA);
        if (idade < 0)
            MensagensErro.adicionarErro(MensagensErro.IDADE_INVALIDA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.matricula = matricula;
        this.idade = idade;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nCPF: " + formatarCpf(getCpf()) + "\nMatricula: " + "2024" + getMatricula() + "\nIdade: " + getIdade();
    }

    // Get e set de matrícula com as devidas verificações
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if (matricula <= 0)
            MensagensErro.adicionarErro(MensagensErro.MATRICULA_INVALIDA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.matricula = matricula;
    }

    // Get e set de idade com as devidas verificações
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0)
            MensagensErro.adicionarErro(MensagensErro.IDADE_INVALIDA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.idade = idade;
    }

    // Get e set de numero de alunos
    public int getNumeroAlunos() {
        return numeroAlunos;
    }

    public void setNumeroAlunos(int numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }

    // Metodo para formatar o CPF
    private String formatarCpf(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    // Get e set de turmas
    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    // Metodo para adicionar turmas
    public void adicionarTurma(Turma turma){
        turmas.add(turma);
    }
}