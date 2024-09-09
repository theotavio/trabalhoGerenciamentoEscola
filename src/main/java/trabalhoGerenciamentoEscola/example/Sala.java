package trabalhoGerenciamentoEscola.example;
import java.util.ArrayList;

public class Sala{
    // Atributos
    private int numero;
    private int capacidadeSala;
    private int numeroDeTurmas;
    private int numeroSalas;;

    // Construtor com as devidas verificações
    public Sala(int numero, int capacidadeSala){
        if (numero <= 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_SALA);
        if (capacidadeSala < 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_CAPACIDADE_SALA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.numero = numero;
        this.capacidadeSala = capacidadeSala;
    }

    // Metodo toString
    @Override
    public String toString(){
        return "Número: " + numero + "\nCapacidade: " + capacidadeSala + "\nTurmas: " + getNumeroDeTurmas();
    }

    // Get e set do numero da sala  com as devidas verificações
    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        if (numero <= 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_SALA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.numero = numero;
    }

    // Get e set da capacidade da sala com as devidas verificações
    public int getCapacidadeSala(){
        return capacidadeSala;
    }

    public void setCapacidadeSala(int capacidadeSala){
        if (capacidadeSala < 0)
            MensagensErro.adicionarErro(MensagensErro.NUM_CAPACIDADE_SALA);

        if (!MensagensErro.getErros().isEmpty())
            throw new IllegalArgumentException(String.join("\n ", MensagensErro.getErros()));
        this.capacidadeSala = capacidadeSala;
    }

    // Get e set do numero de turmas da sala
    public int getNumeroDeTurmas(){
        return numeroDeTurmas;
    }

    public void setNumeroDeTurmas(int numeroDeTurmas){
        this.numeroDeTurmas = numeroDeTurmas;
    }

    // Get e set do numero de salas
    public int getNumeroSalas(){
        return numeroSalas;
    }

    public void setNumeroSalas(int numeroSalas){
        this.numeroSalas = numeroSalas;
    }
}