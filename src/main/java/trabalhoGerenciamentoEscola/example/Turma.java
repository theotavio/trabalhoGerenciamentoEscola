package trabalhoGerenciamentoEscola.example;

public class Turma{
    // Atributos
    private String curso;
    private int anoTurma;
    private int numeroAlunos;

    // Construtor
    public Turma(String curso, int anoTurma, int numeroAlunos){
        this.curso = curso;
        this.anoTurma = anoTurma;
        this.numeroAlunos = numeroAlunos;

        if(curso.isEmpty())
            MensagensErro.adicionarErro(MensagensErro.CURSO_VAZIO);
        if(anoTurma <= 0)
            MensagensErro.adicionarErro(MensagensErro.ANO_TURMA);
        if(numeroAlunos < 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_ALUNOS_TURMA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join(" ", MensagensErro.getErros()));
        MensagensErro.limparErros();
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

    public int getNumeroAlunos(){
        return numeroAlunos;
    }

    public void setNumeroAlunos(int numeroAlunos){
        this.numeroAlunos = numeroAlunos;

        if(numeroAlunos < 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_ALUNOS_TURMA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join(" ", MensagensErro.getErros()));
        MensagensErro.limparErros();
    }

    // Metodo para calcular o tempo de aula semanal em minutos
    public void TempoAulaSemanaMinutos(){
    }
}