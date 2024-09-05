package trabalhoGerenciamentoEscola.example;
import java.util.ArrayList;

public class Aluno extends Pessoa {
    // Atributos
    private int matricula;
    private int idade;
    private int numeroAlunos;
    private ArrayList<Turma> turmas;

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
        this.turmas = new ArrayList<>();
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

    // Metodo para associar uma turma ao aluno
    public void adicionarTurma(Turma turma){
        if (!turmas.contains(turma)) {
            turmas.add(turma);
            turma.adicionarAluno(this);  // Atualiza a turma para incluir o aluno
        }
    }

    // Get do array de turmas
    public ArrayList<Turma> getTurmas(){
        return turmas;
    }
}