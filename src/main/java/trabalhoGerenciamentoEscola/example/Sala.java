package trabalhoGerenciamentoEscola.example;

public class Sala{
    // Atributos
    private int numero;
    private int capacidadeSala;
    private int numeroDeTurmas;

    // Construtor
    public Sala(int numero, int capacidadeSala, int numeroDeTurmas){
        this.numero = numero;
        this.capacidadeSala = capacidadeSala;
        this.numeroDeTurmas = numeroDeTurmas;

        if (numero <= 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_SALA);
        if (capacidadeSala < 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_CAPACIDADE_SALA);
        if(numeroDeTurmas < 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_TURMAS_SALA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    // Metodo toString
    @Override
    public String toString(){
        return "Número: " + numero + ", Capacidade: " + capacidadeSala + ", Turmas: " + numeroDeTurmas;
    }

    // Getters e Setters
    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;

        if (numero <= 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_SALA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    public int getCapacidadeSala(){
        return capacidadeSala;
    }

    public void setCapacidadeSala(int capacidadeSala){
        this.capacidadeSala = capacidadeSala;

        if (capacidadeSala < 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_CAPACIDADE_SALA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }

    public int getNumeroDeTurmas(){
        return numeroDeTurmas;
    }

    public void setNumeroDeTurmas(int numeroDeTurmas){
        this.numeroDeTurmas = numeroDeTurmas;

        if(numeroDeTurmas < 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_TURMAS_SALA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
    }
}