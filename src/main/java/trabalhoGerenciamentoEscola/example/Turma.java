package trabalhoGerenciamentoEscola.example;
import java.util.ArrayList;

public class Turma{
    // Atributos
    private String curso;
    private int anoTurma;
    private int numeroAlunos;
    private Sala sala;
    private Professor professor;
    private ArrayList<Aluno> alunos;
    private ArrayList<Horario> horarios = new ArrayList<>();

    // Construtor
    public Turma(String curso, int anoTurma){
        if(curso.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.CURSO_VAZIO);
        if(anoTurma <= 0)
            MensagensErro.adicionarErro(MensagensErro.ANO_TURMA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join(" ", MensagensErro.getErros()));
        MensagensErro.limparErros();

        this.curso = curso;
        this.anoTurma = anoTurma;
        this.alunos = new ArrayList<>();
    }

    // Getters e Setters
    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso;

        if(curso.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.CURSO_VAZIO);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join(" ", MensagensErro.getErros()));
        MensagensErro.limparErros();
    }

    public int getAnoTurma(){
        return anoTurma;
    }

    public void setAnoTurma(int anoTurma){
        this.anoTurma = anoTurma;

        if(anoTurma <= 0)
            MensagensErro.adicionarErro(MensagensErro.ANO_TURMA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join(" ", MensagensErro.getErros()));
        MensagensErro.limparErros();
    }

    @Override
    public String toString() {
        return "Curso: " + getCurso() + "\nAno: " + getAnoTurma() + "\nNumero de Alunos: " + getNumeroAlunos();
    }


    public int getNumeroAlunos(){
        return numeroAlunos;
    }

    public void setNumeroAlunos(int numeroAlunos){
        this.numeroAlunos = numeroAlunos;
    }

    // Metodo para calcular o tempo de aula semanal em minutos
    public void TempoAulaSemanaMinutos(){
    }

    // Metodo e get de horário
    public void adicionarHorario(Horario horario){
        horarios.add(horario);
    }

    public ArrayList<Horario> getHorarios(){
        return horarios;
    }

    // Set e get de sala
    public void setSala(Sala sala){
        this.sala = sala;
    }

    public Sala getSala(){
        return  sala;
    }

    // Set e get de professor
    public void setProfessor(Professor professor){
        this.professor = professor;
    }

    public Professor getProfessor(){
        return professor;
    }

    // Metodo para adicionar aluno a turma
    public void adicionarAluno(Aluno aluno){
        if (!alunos.contains(aluno) && sala.getCapacidadeSala() > numeroAlunos){
            alunos.add(aluno);
            numeroAlunos++;
        }
        else{
            MensagensErro.adicionarErro(MensagensErro.SALA_ERRO);
            if (!MensagensErro.getErros().isEmpty())
                throw new IllegalArgumentException(String.join(" ", MensagensErro.getErros()));
            MensagensErro.limparErros();
        }
    }

    // Get do array de alunos
    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }
}