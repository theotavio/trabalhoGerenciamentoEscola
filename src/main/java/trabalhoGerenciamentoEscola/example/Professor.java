package trabalhoGerenciamentoEscola.example;

public class Professor extends Pessoa{
    // Atributos
    private int numeroAulasMinistradas;
    private int numeroProfessores;

    // Construtor com as devidas verificações
    public Professor(String nome, String cpf){
        super(nome, cpf);
    }

    // Metodo toString
    @Override
    public String toString(){
        return "Nome: " + getNome() + "\nCPF: " + formatarCpf(getCpf()) + "\nAulas: " + getNumeroAulasMinistradas();
    }

    // Get e set do numero de aulas ministradas
    public int getNumeroAulasMinistradas(){
        return numeroAulasMinistradas;
    }

    public void setNumeroAulasMinistradas(int numeroAulasMinistradas){
        this.numeroAulasMinistradas = numeroAulasMinistradas;
    }

    // Get e set do numero de professores
    public int getNumeroProfessores(){
        return numeroProfessores;
    }

    public void setNumeroProfessores(int numeroProfessores){
        this.numeroProfessores = numeroProfessores;
    }

    // Metodo para formatar o CPF
    private String formatarCpf(String cpf){
        return cpf.substring(0, 3) + "." +  cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
}
