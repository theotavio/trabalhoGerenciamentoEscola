package trabalhoGerenciamentoEscola.example;

public class Professor extends Pessoa{
    // Atributos
    private int numeroAulasMinistradas;
    private int numeroProfessores = 0;

    // Construtor com as devidas verificações
    public Professor(String nome, String cpf, int numeroAulasMinistradas) {
        super(nome, cpf);
        this.numeroAulasMinistradas = numeroAulasMinistradas;
        this.numeroProfessores++;

        if(numeroAulasMinistradas < 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_MINISTRADAS);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    // Metodo toString
    @Override
    public String toString(){
        return "Professor: " + getNome() + ", CPF: " + formatarCpf(getCpf()) + ", Aulas: " + getNumeroAulasMinistradas();
    }

    // Getters e Setters com as devidas verificações
    public int getNumeroAulasMinistradas(){
        return numeroAulasMinistradas;
    }

    public void setNumeroAulasMinistradas(int numeroAulasMinistradas){
        numeroAulasMinistradas = numeroAulasMinistradas;
    }

    public int getNumeroProfessores(){
        return numeroProfessores;
    }

    public void setNumeroProfessores(int numeroProfessores){
        this.numeroProfessores++;
    }

    // Metodo para formatar o CPF
    private String formatarCpf(String cpf){
        return cpf.substring(0, 3) + "." +  cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
}
