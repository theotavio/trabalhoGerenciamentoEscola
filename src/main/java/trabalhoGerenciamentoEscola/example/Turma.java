package trabalhoGerenciamentoEscola.example;
import java.util.ArrayList;

public class Turma{
    // Atributos
    private String curso;
    private int anoTurma;
    private int numeroAlunos;
    private Sala sala;
    private Professor professor;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Horario> horarios =  new ArrayList<>();

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
        return "Curso: " + getCurso() + "\nAno: " + getAnoTurma() + "\nNumero de Alunos: " + getNumeroAlunos() + "\nTempo de aula por semana: " + tempoAulaSemanaMinutos();
    }


    public int getNumeroAlunos(){
        return numeroAlunos;
    }

    public void setNumeroAlunos(int numeroAlunos){
        this.numeroAlunos = numeroAlunos;
    }

    // Metodo para calcular o tempo de aula semanal em minutos
    public int tempoAulaSemanaMinutos(){
        int totalMinutos = 0;
        for (Horario horario : horarios) {
            totalMinutos += horario.TempoDeAulaMinutos();
        }
        return totalMinutos;
    }

    // Get e set de sala
    public Sala getSala(){
        return sala;
    }

    public void setSala(Sala sala){
        this.sala = sala;
    }

    // Get e set de aluno
    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos){
        this.alunos = alunos;
    }

    // Metodo para adicionar os alunos
    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    // Get e set de professor
    public Professor getProfessor(){
        return professor;
    }

    public void setProfessor(Professor professor){
        this.professor = professor;
    }

    // Get e set de horarios
    public ArrayList<Horario> getHorarios(){
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios){
        this.horarios = horarios;
    }
}